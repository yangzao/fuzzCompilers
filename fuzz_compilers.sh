#!/bin/bash

export AFL_DISABLE_TRIM=1
export AFL_CUSTOM_MUTATOR_ONLY=1 
export AFL_CUSTOM_MUTATOR_LIBRARY=$(pwd)/libCustomCodeMutator.so

export PYTHONPATH=$(pwd)/post_compilation/
export AFL_PYTHON_MODULE=post_comp

export CSMITH_RUNTIME=$(pwd)/post_compilation/csmith_install/include
export GNU=/usr/include/x86_64-linux-gnu/
export TMP_FOLDER=$(pwd)/tmp/
export MUTATED_CODE=$(pwd)/out/default/.cur_input.c
export SAVE_FOLDER=$(pwd)/saved/

export TARGET_COMPILER=gcc
export SECOND_COMPILER=clang

(AFLplusplus/afl-fuzz -i input/ -o out/ -e c -Q -- $TARGET_COMPILER -O0 @@)
