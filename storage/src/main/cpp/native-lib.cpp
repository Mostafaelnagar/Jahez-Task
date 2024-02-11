//
// Created by t-e-s on ٢٠‏/٦‏/٢٠٢٢.
//

#include <string>
#include <jni.h>

extern "C" jstring
Java_te_app_storage_Keys_debugBaseUrl(JNIEnv *env, jobject thiz) {
    std::string debugBaseUrl = "https://endPoint/api/";
    return env->NewStringUTF(debugBaseUrl.c_str());
}

extern "C"
JNIEXPORT jstring JNICALL
Java_te_app_storage_Keys_socketBaseUrl(JNIEnv *env, jobject thiz) {
    std::string debugBaseUrl = "wss://socketsbay.com/wss/v2/1/demo/";
    return env->NewStringUTF(debugBaseUrl.c_str());
}