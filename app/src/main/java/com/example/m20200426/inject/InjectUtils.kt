package com.example.m20200426.inject

import android.app.Activity
import android.view.View

class InjectUtils {
    fun injectView(activity: Activity) {
        val cls = activity.javaClass
        val declaredFileds = cls.declaredFields
        for (field in declaredFileds) {
            if (field.isAnnotationPresent(InjectView::class.java)) {
                val injectView = field.getAnnotation(InjectView::class.java)
                val id = injectView.value
                val view = activity.findViewById<View>(id)
                field.isAccessible = true
                field.set(activity, view)
            }
        }
    }

    fun injectField(activity: Activity) {
        val cls = activity.javaClass
        val bundle = activity.intent.extras
        val declaredFields = cls.declaredFields
        for (field in declaredFields) {
            if (field.isAnnotationPresent(InjectField::class.java)) {
                val injectFiled = field.getAnnotation(InjectField::class.java)
                val key = injectFiled.key
                val componentType = field.type.componentType
                val value =
                    if (key.isEmpty()) {
                        bundle?.get(field.name)
                    } else {
                        bundle?.get(key)
                    }

                field.isAccessible = true
                field.set(activity, value)
            }
        }
    }
}