package com.tilemaster.puzzle.block.matc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_tune_creator.*

class TuneCreator : AppCompatActivity() {

    var scoreMain = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tune_creator)

        m1.setOnClickListener {
            scoreMain++
            m1.isVisible = false
            m1.isClickable = false
            cs()
        }

        m2.setOnClickListener {
            scoreMain++
            m2.isVisible = false
            m2.isClickable = false
            cs()
        }

        m3.setOnClickListener {
            scoreMain++
            m3.isVisible = false
            cs()
        }

        m4.setOnClickListener {
            scoreMain++
            m4.isVisible = false
            cs()
        }
        m5.setOnClickListener {
            scoreMain++
            m5.isVisible = false
            cs()
        }

        m6.setOnClickListener {
            scoreMain++
            m6.isVisible = false
            cs()
        }

    }
    fun cs(){
        if(scoreMain == 6){
            m1.isVisible=true
            m1.isClickable=true

            m2.isVisible=true
            m2.isClickable=true

            m3.isVisible=true
            m3.isClickable=true

            m4.isVisible=true
            m4.isClickable=true

            m5.isVisible=true
            m5.isClickable=true

            m6.isVisible=true
            m6.isClickable=true

            upperTV.text = "Wrong tune try again!"
        }
        if(scoreMain == 12){
            m1.isVisible=true
            m1.isClickable=true

            m2.isVisible=true
            m2.isClickable=true

            m3.isVisible=true
            m3.isClickable=true

            m4.isVisible=true
            m4.isClickable=true

            m5.isVisible=true
            m5.isClickable=true

            m6.isVisible=true
            m6.isClickable=true
        }
        if(scoreMain == 18){
            m1.isVisible=true
            m1.isClickable=true

            m2.isVisible=true
            m2.isClickable=true

            m3.isVisible=true
            m3.isClickable=true

            m4.isVisible=true
            m4.isClickable=true

            m5.isVisible=true
            m5.isClickable=true

            m6.isVisible=true
            m6.isClickable=true
        }

        if(scoreMain == 24){
            m1.isVisible=true
            m1.isClickable=true

            m2.isVisible=true
            m2.isClickable=true

            m3.isVisible=true
            m3.isClickable=true

            m4.isVisible=true
            m4.isClickable=true

            m5.isVisible=true
            m5.isClickable=true

            m6.isVisible=true
            m6.isClickable=true
            upperTV.text = "Try again some other time! The Great Tune Tree is tired."
        }

        if(scoreMain == 30){
            m1.isVisible=true
            m1.isClickable=true

            m2.isVisible=true
            m2.isClickable=true

            m3.isVisible=true
            m3.isClickable=true

            m4.isVisible=true
            m4.isClickable=true

            m5.isVisible=true
            m5.isClickable=true

            m6.isVisible=true
            m6.isClickable=true

            tryAgainBtn.isVisible = true


        }
    }

    fun endTune(view: View) {
        Intent(applicationContext, Symphony::class.java).also { startActivity(it) }
        finish()
    }
}