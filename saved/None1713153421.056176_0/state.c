#include "csmith.h"
int make_global(char *);
int make_global_a_b_o_r_t();
int make_global_e_x_i_t();
char __wrapper_val[256]="I";


#include <stdio.h>
#include <string.h>
#include <stdint.h>
#include <stdlib.h>

int i = 1;
short s = 123;
long l = 13134243432;
char *str = "global string";

int set_var(int i_l, short s_l, long l_l) {
    i = i_l;
    s = s_l + 42 * ((long)((((double)(s_l)) - ((double)(s_l))))) + ((int)((((int)(s)) ^ ((int)(s_l))))) - ((short)((((int)(s)) | ((int)(s_l))))) + ((int)((((int)(s_l)) >> ((int)(s))))) * ((int)((((double)(s)) - ((double)(s)))));
    l = l_l;
    return 0;
}

void func_1(){
    int i_l = 1;
    short s_l = 123;
    long l_l = 13134243432;
    char *str_l = "local string";
    char *str_l_alt = "another local string";

    i_l = 1 + 42 * ((long)((((double)(i_l)) - ((double)(1))))) + ((long)((((double)(i_l)) - ((double)(i_l))))) - ((int)((((int)(i_l)) >> ((int)(1)))));
    goto label_last;

label_while:
    while(i_l == 1){
        s_l = 321 + 42 - ((int)((((int)(321)) << ((int)(s_l))))) - ((long)((((int)(s_l)) >> ((int)(321))))) - ((long)((((int)(s_l)) ^ ((int)(321))))) - ((short)((((double)(s_l)) * ((double)(s_l))))) * ((int)((((double)(321)) + ((double)(s_l)))));
        i_l++;
        }
  
label_if: 
    if(((int)s_l == 123 + 41 * ((short)((((double)(123)) * ((double)(123))))) + ((long)((((double)(s_l)) + ((double)(s_l))))) - ((short)((((int)(s_l)) ^ ((int)(s_l))))) + ((int)((((double)(123)) * ((double)(123))))) * ((int)((((double)(s_l)) + ((double)(s_l))))) + ((int)((((double)(s_l)) + ((double)(s_l))))))){
        s_l--;
        l_l++;
        }

label_switch:
    switch(i_l){
        case 0:
            i_l = 15;
            break;
        case 1:
            s_l = 456;
            break;
        case 2:
            str_l = str_l_alt;
            break;
        default:
            l_l = 9876543;
            break;
    }
    
label_for:
    for (int loop = 0; loop < 111; loop++){
        l_l = 13134243433;
    }

label_none:
    set_var(i_l, s_l, l_l);
    str = str_l;
    make_global(__wrapper_val); sprintf(__wrapper_val,"%s", str);
    return;

label_last:   
    goto label_while;
}

int func_0(){
    func_1();
    return 0;
}

int i_csmith_transform = 0;
int i_print_hash_value = 0;
int make_global_a_b_o_r_t(){
	transparent_crc(i_csmith_transform, "abort call", i_print_hash_value);
	i_csmith_transform=i_csmith_transform+1;
	return 0;
} 

int make_global_e_x_i_t(){
	transparent_crc(i_csmith_transform, "abort exit", i_print_hash_value);
	i_csmith_transform=i_csmith_transform+1;
	return 0;
} 

int make_global(char *val){
	if ((val == 0) || (strlen(val) == 0)) {
		transparent_crc(i_csmith_transform, "empty string", i_print_hash_value);
	} else {
		char name[100]; sprintf(name, "gprnt%d", i_csmith_transform);
		transparent_crc_bytes(val, strlen(val), name , i_print_hash_value);
	}
	i_csmith_transform=i_csmith_transform+1;
	return 0;
} 
int main(int argc, char* argv[]){
	if (argc == 2 && strcmp(argv[1], "1") == 0) i_print_hash_value = 1;
	platform_main_begin();
	crc32_gentab();

	func_0(); /* Original main of the program */
	make_global(__wrapper_val); /* Print the last use of the wrapper, or if never used it will print empty string */
	transparent_crc(i, "i", i_print_hash_value);
	printf("i: %d ", i);
	transparent_crc(s, "s", i_print_hash_value);
	printf("s: %d ", s);
	transparent_crc(l, "l", i_print_hash_value);
	printf("l: %ld ", l);
	if (str != 0)
{		transparent_crc((*str), "(*str)", i_print_hash_value);
	printf("str: %s ", str);

}	platform_main_end(crc32_context ^ 0xFFFFFFFFUL, i_print_hash_value);
	printf("End of program\n");
	return 0;
}
	