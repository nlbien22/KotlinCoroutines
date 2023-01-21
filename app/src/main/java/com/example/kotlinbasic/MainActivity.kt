package com.example.kotlinbasic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlinbasic.kotlincoroutines.coroutinescontext.TestWithContext

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //run dispatchers
        //TestDispatchers.runMyFirstCoroutines()

        //run withContext - Chuyển đổi qua lại giữa các Thread
        //TestWithContext.testMyFirstWithContext();

        //run withContext - Long Task & Update UI on Main
        //TestWithContext.testMySecondWithContext();

        //Job - nắm giữ vòng đời Life Cycle


    }
}