package com.ckw.kotlindemo

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
/*
* 主要介绍
* val var
* 寻找控件的方式
* 监听事件
* 简单地使用函数
* ？ :: !! 符号的使用
* */
class MainActivity : AppCompatActivity() {

    //全局变量 val不可变的，一旦赋值就不可变化 val 可变的
    private val mName = "ckw"
    private var mAge: Int = 0
    private var mBtn: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mBtn = findViewById(R.id.btn_go)
        
        //var 可以被重新赋值
        mAge = 18
        /*
        * 寻找控件（局部变量）的三种种方式
        * */
        //方式一
        val btn = findViewById<Button>(R.id.btn_go)
        //方式二
        val btn2 = findViewById(R.id.btn_go) as Button?

        //方式三：直接取到它的名字 需要在module的build.gradle中加入apply plugin: 'kotlin-android-extensions'
        btn_go.setOnClickListener {
            val intent = Intent(this@MainActivity,Main2Activity::class.java)
            startActivity(intent)
        }

        /*
         * 设置监听，简单地使用函数
         * */
        clickNotNull(mBtn!!)
        clickCanNull(mBtn)
        clickCanNullTwo(mBtn)
        anotherClick(mBtn!!)

    }

    /*
    * 参数需要一个非空的button,
    * 当实参是一个空的Button时，比如mBtn实际上是空的，输入mBtn!!,代码会奔溃
    * */
    private fun clickNotNull(btn: Button): Unit {
        btn.setOnClickListener {
            // ::符号返回类的.class 文件
            val intent = Intent(this@MainActivity, Main2Activity::class.java)
            startActivity(intent)
        }
    }

    /*
    * 参数需要一个button，可空
    * */
    private fun clickCanNull(btn: Button?): Unit {
        //由于mBtn有可能为空，所以需要用 ？ 符号，返回它的非空,如果mBtn为空，则点击事件无效
        btn?.setOnClickListener {
            val intent = Intent(this@MainActivity, Main2Activity::class.java)
            startActivity(intent)
        }
    }

    /*
    * 参数需要一个button，可空
    * */
    private fun clickCanNullTwo(btn: Button?): Unit {
        // !! 符号返回一个非空的对象
        btn!!.setOnClickListener {
            val intent = Intent(this@MainActivity, Main2Activity::class.java)
            startActivity(intent)
        }
    }

    private fun anotherClick(btn: Button): Unit {
        //设置监听的另一种写法，一般不需要
        btn.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@MainActivity, Main2Activity::class.java)
            startActivity(intent)
        })
    }


}
