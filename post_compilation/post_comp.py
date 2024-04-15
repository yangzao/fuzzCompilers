import os
import subprocess
import random
from timeout_decorator import timeout
import shutil
import time

from utils import *
from enhanCer import add_state_tracking

def init(seed):
    random.seed(seed)

def deinit():
    pass

@timeout(40)
def run_state_exec(file_path):
    
    try:
        ret = subprocess.run(file_path, stdout=subprocess.PIPE)
    except subprocess.TimeoutExpired:
        ret = None
    except Exception as e:
        ret = None
    return ret
       
def post_run():
    ret = 0
    try:
        ret = post_com()
    except Exception as e:
        #print(f"An error occurred in post_dec.py: {e}")
        pass
    return ret

@timeout(50)
def post_com():

    csmith = str(os.environ.get('CSMITH_RUNTIME'))
    gnu = " " + str(os.environ.get('GNU'))

    tmp_folder = str(os.environ.get('TMP_FOLDER'))

    mutated_code = str(os.environ.get('MUTATED_CODE'))

    if os.path.exists(tmp_folder) == False:
        os.makedirs(tmp_folder)

    target = c_code()
    second = c_code()

    target.compiler = str(os.environ.get('TARGET_COMPILER'))
    target.state_exec = os.path.join(tmp_folder, target.compiler+"_state_exec")

    second.compiler = str(os.environ.get('SECOND_COMPILER'))
    second.state_exec = os.path.join(tmp_folder, second.compiler+"_state_exec")

    mutated_code = str(os.environ.get('MUTATED_CODE'))
    src_code = os.path.join(tmp_folder, "src.c")
    state_code = os.path.join(tmp_folder, "state.c")

    shutil.copy2(mutated_code, src_code)

    enhancer_status = add_state_tracking(src_code, state_code, " -I"+csmith+" -I"+gnu)
    if enhancer_status != status.OKAY:
        clear_dir(tmp_folder)
        return 0
    
    codes = [target, second]
    for i in range(2):
        
        codes[i].comp_state_cmd = codes[i].compiler + ' -O0 '

        extern_lib = ''
        if codes[i].compiler == "tcc":
            extern_lib = csmith + "../tcc.o"

        codes[i].comp_state_cmd += state_code + ' ' + extern_lib + ' -o ' + codes[i].state_exec + ' -I' + csmith + ' > /dev/null 2>&1'
        codes[i].comp_state_status = os.system(codes[i].comp_state_cmd)
        if os.path.exists(codes[i].state_exec) != True:
            clear_dir(tmp_folder)
            return 0

        codes[i].subprocess_ret = run_state_exec(codes[i].state_exec)

        if codes[i].subprocess_ret == None:
            clear_dir(tmp_folder)
            return 0
        
        if i == 0 and codes[i].subprocess_ret.returncode != 0:
            clear_dir(tmp_folder)
            return 0
        else:
            codes[i].exec_result = codes[i].subprocess_ret.stdout
            if codes[i].subprocess_ret.returncode != 0:
                codes[i].exec_result = b'error with return code ' + str(codes[i].subprocess_ret.returncode).encode()
            
            codes[i].exec_result_str = rm_result_mark(codes[i].exec_result.decode())
            codes[i].exec_result_checksum = get_checksum(codes[i].exec_result_str)
        
    # if there is divergence between the checksums, mark the test case as crash
    if target.exec_result_checksum != second.exec_result_checksum:
        show_divergence_outputs(target.exec_result_str, second.exec_result_str, target.compiler, second.compiler)
        current_timestamp = str(time.time())
        save_folder = str(os.environ.get('SAVE_FOLDER')) + current_timestamp
        save_folder = create_folder_for_program(save_folder)
        shutil.copy2(state_code, save_folder)
    
        clear_dir(tmp_folder)
        return 1
    
    clear_dir(tmp_folder)
    return 0