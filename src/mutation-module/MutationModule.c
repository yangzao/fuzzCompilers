#include "afl-fuzz.h"

#include <stdint.h>
#include <stdlib.h>
#include <string.h>
#include <stdio.h>
#include <unistd.h>

typedef struct my_mutator {
    afl_state_t *afl;
    u8 *mutated_out;
} my_mutator_t;

// for storing C code
typedef struct src_code {
    size_t size;
    uint8_t *code;
    char *code_alt;
} src_code;

my_mutator_t *afl_custom_init(afl_state_t *afl, unsigned int seed) {

  srand(seed);

  my_mutator_t *data = calloc(1, sizeof(my_mutator_t));

  if (!data) {

    perror("afl_custom_init alloc");
    return NULL;

  }

  if ((data->mutated_out = (u8 *)malloc(MAX_FILE)) == NULL) {

    perror("afl_custom_init malloc");
    return NULL;

  }

  data->afl = afl;

  return data;

}

// Write mutated C code to SOURCE_FILE_PATH (config.compile.srcfile)

size_t afl_custom_fuzz(my_mutator_t *data, uint8_t *buf, size_t buf_size, u8 **out_buf, uint8_t *add_buf, size_t add_buf_size, size_t max_size) {
    src_code *codeBuf = calloc(1, sizeof(src_code));
  
    codeBuf->code = (u8 *)malloc(MAX_FILE);
    codeBuf->code_alt = (char *)malloc(MAX_FILE);

    codeBuf->size = buf_size;

    // copy C code into codeBuf
    memcpy(codeBuf->code, buf, codeBuf->size);

    // C code mutation, see srccode-mutators/CodeMutators.cpp
    src_code_mutation(codeBuf->code, codeBuf->size, codeBuf->code_alt);

    // get the length of mutated C code
    codeBuf->size = strlen(codeBuf->code_alt);
    // replace original C code with the mutated one
    memcpy(codeBuf->code, codeBuf->code_alt, codeBuf->size);

    // write mutated c code into disk for compilation
    //write_mutated_src_to_file(codeBuf->code, codeBuf->size);

    // concatenate mutated flag bytes and mutated c code
    memcpy(data->mutated_out, codeBuf->code, codeBuf->size);

    // the output buffer size
    size_t out_size = codeBuf->size;
    *out_buf = data->mutated_out;

    free(codeBuf->code);
    free(codeBuf->code_alt);
    codeBuf->code = NULL;
    codeBuf->code_alt = NULL;
    free(codeBuf);
    
    return out_size;
}



void afl_custom_deinit(my_mutator_t *data) {

  free(data->mutated_out);
  free(data);

}
