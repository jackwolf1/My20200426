package com.example.m20200426.inject

@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
annotation class InjectField(val key: String = "")