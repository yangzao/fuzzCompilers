import os.path
import shutil
from enum import Enum

class status(Enum):
    OKAY = 1
    NODEC = 2
    ERROR = 3

def clear_dir(dir):
    if os.path.isdir(dir):
        for item in os.listdir(dir):
            item_path = os.path.join(dir, item)
            if os.path.isfile(item_path):
                os.remove(item_path)
            elif os.path.isdir(item_path):
                shutil.rmtree(item_path)

def create_folder_for_program(folder, cnt=0):
    folder_name = f"{folder}_{cnt}"
    if os.path.exists(folder_name):
        return create_folder_for_program(folder, cnt + 1)
    else:
        os.makedirs(folder_name)
    return folder_name

def rm_result_mark(text):
    mark = "End of program"
    pos = text.find(mark)
    if pos != -1:
        text = text[:pos]
        if text.endswith('\r\n'):
            return text[:-2]
        elif text.endswith('\n'):
            return text[:-1]
    return text

def get_checksum(str):

    ret_str = str

    if ' ' in str:
        str = str.split(' ')
        ret_str = str[-3] + ' ' + str[-2] + ' ' + str[-1]

    return ret_str

def show_divergence_outputs(target_result_str, second_result_str, target_compiler, second_compiler):

    print()
    print("{} output:   ".format(target_compiler))
    print(target_result_str + " "*100)
    print("{} output: ".format(second_compiler))
    print(second_result_str + " "*100)
    print()


class c_code:
    def __init__(self):
        self.c_code = None

        self.compiler = None
        self.state_exec = None

        self.subprocess_ret = None
        self.exec_result = None
        self.exec_result_str = None
        self.exec_result_checksum = None

        self.add_state_cmd = None
        self.comp_state_cmd = None
        self.comp_state_status = None

