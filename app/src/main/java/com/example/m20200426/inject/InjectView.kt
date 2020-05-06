package com.example.m20200426.inject

import androidx.annotation.IdRes

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FIELD)
annotation class InjectView(@IdRes val value: Int)
