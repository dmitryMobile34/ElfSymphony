package com.tilemaster.puzzle.block.matc

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.orhanobut.hawk.Hawk
import kotlinx.coroutines.*

class MoverClass : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mover_class)

        val textView: TextView = findViewById(R.id.txtMover)
        runBlocking {

            val job: Job = GlobalScope.launch(Dispatchers.IO) {
                getAsync(applicationContext)
            }
            job.join()
            val jsoup: String? = Hawk.get(CNSTNC.aResult, "")
            Log.d("cora", "cora $jsoup")

            textView.text = jsoup

            if (jsoup == "7pIx") {
                Intent(applicationContext, Symphony::class.java).also { startActivity(it) }

            } else {
                Intent(applicationContext, ElfViewAct::class.java).also { startActivity(it) }
            }
            finish()
        }
    }

    private suspend fun getAsync(context: Context) {
        val asyncKey = JSOU(context)
        val asyncResult = asyncKey.getDocSecretKey()
        Hawk.put(CNSTNC.aResult, asyncResult)
    }
}