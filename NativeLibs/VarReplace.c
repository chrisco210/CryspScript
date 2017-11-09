#include <jni.h>

JNIEXPORT void JNICALL Java_todo_fillVariable(JNIEnv * env, jobject imp, jobject map, jstring string)
{
	jmethodID mapGet = (*env)->GetMethodID(env, map, "put", "(I)I");
	 
}