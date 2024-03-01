set(LLVM_LINK_COMPONENTS support)

add_clang_library(CustomCodeMutator
  SHARED
  MutationModule.c
  )
target_link_libraries(CustomCodeMutator
  PRIVATE
  codeMutators
  )
include_directories(
  ${CMAKE_CURRENT_LIST_DIR}/../../../../AFLplusplus/include/
)