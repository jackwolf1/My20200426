package com.example.kotlin_compiler

import javax.annotation.processing.AbstractProcessor
import javax.annotation.processing.Messager
import javax.annotation.processing.RoundEnvironment
import javax.annotation.processing.SupportedAnnotationTypes
import javax.lang.model.element.TypeElement
import javax.tools.Diagnostic


@SupportedAnnotationTypes("com.example.m20200426.Vinson")
class VinsonProcessor : AbstractProcessor() {

    override fun process(
        set: MutableSet<out TypeElement>?,
        roundEnvironment: RoundEnvironment?
    ): Boolean {
        val messager = processingEnv.messager
        messager.printMessage(Diagnostic.Kind.OTHER, "======ying======")
//        processingEnv.messager.printMessage(Diagnostic.Kind.NOTE, "msg")
        return false
    }
}
