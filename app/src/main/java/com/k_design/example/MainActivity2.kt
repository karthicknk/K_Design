package com.k_design.example

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {

    companion object{const val TAG = "MainActivity2"}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        Log.e(TAG, "onCreate: " )
        Log.e(TAG, "MainActivity2: " )
        Log.e(TAG, "Update2: " )
    }
}