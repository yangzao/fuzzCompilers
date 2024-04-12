#!/bin/bash

export AFL_DISABLE_TRIM=1
export AFL_CUSTOM_MUTATOR_ONLY=1 
export AFL_CUSTOM_MUTATOR_LIBRARY=$(pwd)/libCustomCodeMutator.so

export CSMITH_RUNTIME=$(pwd)/post_compilation/csmith_install/include
export GNU=/usr/include/x86_64-linux-gnu/
export TMP_FOLDER=$(pwd)/tmp/
export MUTATED_CODE=$(pwd)/output/default/.cur_input

export TARGET_COMPILER=gcc
export SECOND_COMPILER=clang

(AFLplusplus/afl-fuzz -i input/ -o out/ -e c -Q -- $TARGET_COMPILER -O0 @@)