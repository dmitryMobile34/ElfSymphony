package com.tilemaster.puzzle.block.matc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Symphony : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_symphony)
    }

    fun startTune(view: View) {
        Intent(applicationContext, TuneCreator::class.java).also { startActivity(it) }
    }
}