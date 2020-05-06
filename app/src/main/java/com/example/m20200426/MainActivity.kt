package com.example.m20200426

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.widget.TextView
import com.example.m20200426.inject.InjectUtils
import com.example.m20200426.inject.InjectView

@Vinson(1, "2")
class MainActivity : AppCompatActivity() {

    @InjectView(R.id.tv)
    private lateinit var tv1: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        InjectUtils().injectView(this)
        tv1.text = "太帅了"
        tv1.setOnClickListener {
            startActivity(
                Intent(this@MainActivity, SecondActivity::class.java)
                    .putExtra("test", "传输过去了")
                    .putExtra("test1", "默认数据")
                    .putExtra("test2", true)
                    .putParcelableArrayListExtra("test3", arrayListOf(testData()))
                    .putStringArrayListExtra("test4", arrayListOf("测试列表"))
            )
        }
    }
}

data class testData(
    val test: String? = ""
) : Parcelable {
    constructor(source: Parcel) : this(
        source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(test)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<testData> = object : Parcelable.Creator<testData> {
            override fun createFromParcel(source: Parcel): testData = testData(source)
            override fun newArray(size: Int): Array<testData?> = arrayOfNulls(size)
        }
    }
}