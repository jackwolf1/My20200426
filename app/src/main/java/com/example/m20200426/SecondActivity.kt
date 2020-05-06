package com.example.m20200426

import android.os.Bundle
import android.os.Parcelable
import androidx.appcompat.app.AppCompatActivity
import com.example.m20200426.inject.InjectField
import com.example.m20200426.inject.InjectUtils
import kotlinx.android.synthetic.main.activity_main.*

class SecondActivity : AppCompatActivity() {


    @InjectField("test")
    lateinit var test: String

    @InjectField
    lateinit var test1: String

    @InjectField
    var test2: Boolean = false

    @InjectField
    lateinit var test3: ArrayList<Parcelable>

    @InjectField
    lateinit var test4: ArrayList<String>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val utils = InjectUtils()
        utils.injectField(this)

        tv.text = test1
        tv.text = test4[0]
    }

}