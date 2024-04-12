#!/bin/bash

export AFL_DISABLE_TRIM=1
export AFL_CUSTOM_MUTATOR_ONLY=1 
export AFL_CUSTOM_MUTATOR_LIBRARY=$(pwd)/libCustomCodeMutator.so

(AFLplusplus/afl-fuzz -i input/ -o out/ -e c -- tcc @@)