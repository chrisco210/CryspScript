#include <jni.h>
#include "add.h"

JNIEXPORT jint JNICALL Java_cf_rachlinsk_cryspScript_prerun_parsing_expression_Operator_add(JNIEnv* env, jint a, jint, b)
{
    return a + b;
}