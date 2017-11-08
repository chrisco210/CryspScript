#include <jni.h>
#include "Operator.h"

/*
 * Class:     Operator
 * Method:    add
 * Signature: (II)I
 */
JNIEXPORT jint JNICALL Java_cf_rachlinski_cryspScript_prerun_parsing_expression_Operator_add(JNIEnv * env, jobject j, jint a, jint b)
{
	return a + b;
}


/*
 * Class:     Operator
 * Method:    sub
 * Signature: (II)I
 */
JNIEXPORT jint JNICALL Java_cf_rachlinski_cryspScript_prerun_parsing_expression_Operator_sub(JNIEnv * env, jobject j, jint a, jint b)
{
	return a - b;
}

/*
 * Class:     Operator
 * Method:    mul
 * Signature: (II)I
 */
JNIEXPORT jint JNICALL Java_cf_rachlinski_cryspScript_prerun_parsing_expression_Operator_mul(JNIEnv * env, jobject j, jint a, jint b)
{
	return a * b;
}

/*
 * Class:     Operator
 * Method:    div
 * Signature: (II)I
 */
JNIEXPORT jint JNICALL Java_cf_rachlinski_cryspScript_prerun_parsing_expression_Operator_div(JNIEnv * env, jobject j, jint a, jint b)
{
	return a / b;
}

/*
 * Class:     Operator
 * Method:    mod
 * Signature: (II)I
 */
JNIEXPORT jint JNICALL Java_cf_rachlinski_cryspScript_prerun_parsing_expression_Operator_mod(JNIEnv * env, jobject j, jint a, jint b)
{
	return a % b;
}