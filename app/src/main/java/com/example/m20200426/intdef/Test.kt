package com.example.m20200426.intdef

import androidx.annotation.DrawableRes
import androidx.annotation.IntDef
import androidx.annotation.StringDef
import com.example.m20200426.R
import java.lang.annotation.RetentionPolicy

class Test {

    @IntDef(value = [WekDay.SUNDAY, WekDay.MONDAY], flag = true)
    @Retention(AnnotationRetention.SOURCE)
    @Target(
        AnnotationTarget.FIELD,
        AnnotationTarget.VALUE_PARAMETER
    )
    annotation class WekDay {
        companion object {
            const val SUNDAY = 1
            const val MONDAY = 2
        }
    }

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            val test = Test()
            test.setDrawable(R.drawable.ic_launcher_background)
            test.setCurrentDay(WeekDay.MONDAY)
            test.setCurrentDay(123)

        }
    }

    enum class WeekDay {
        SUNDAY, MONDAY
    }


    private lateinit var mCurrentDay: WeekDay
    @WekDay
    private var mCurrentIntDay: Int = 0

    fun setCurrentDay(currentData: WeekDay) {
        mCurrentDay = currentData
    }

    fun setCurrentDay(@WekDay weekDay: Int) {
        mCurrentIntDay = weekDay
    }

    fun setDrawable(@DrawableRes id: Int) {

    }


}


