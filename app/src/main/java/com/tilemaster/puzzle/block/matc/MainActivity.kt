package com.tilemaster.puzzle.block.matc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import com.appsflyer.AppsFlyerConversionListener
import com.appsflyer.AppsFlyerLib
import com.facebook.applinks.AppLinkData
import com.orhanobut.hawk.Hawk
import com.tilemaster.puzzle.block.matc.CNSTNC.DL8
import com.tilemaster.puzzle.block.matc.CNSTNC.DL7
import com.tilemaster.puzzle.block.matc.CNSTNC.DL6
import com.tilemaster.puzzle.block.matc.CNSTNC.DL5
import com.tilemaster.puzzle.block.matc.CNSTNC.DL4
import com.tilemaster.puzzle.block.matc.CNSTNC.DL3
import com.tilemaster.puzzle.block.matc.CNSTNC.DL2
import com.tilemaster.puzzle.block.matc.CNSTNC.DL1
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var stringH: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val prefs = getSharedPreferences("ActivityPREF", MODE_PRIVATE)

        if (prefs.getBoolean("activity_exec", false)) {
            Intent(this, MoverClass::class.java).also { startActivity(it) }
            finish()
        } else {
            val exec = prefs.edit()
            exec.putBoolean("activity_exec", true)
            exec.apply()
        }
    }

    override fun onResume() {
        super.onResume()
        appsIntegration()

    }

    fun mc() {
        Intent(this, MoverClass::class.java)
            .also { startActivity(it) }
        finish()
    }

    private fun appLin() {
        AppLinkData.fetchDeferredAppLinkData(
            this
        ) { appLinkData: AppLinkData? ->
            appLinkData?.let {
                val params =
                    appLinkData.targetUri.pathSegments
                Log.d("D11PL", "$params")
                val conjoined = TextUtils.join("/", params)
                val tokenizer = StringTokenizer(conjoined, "/")
                val firstLink = tokenizer.nextToken()
                val secondLink = tokenizer.nextToken()
                val thirdLink = tokenizer.nextToken()
                val fourthLink = tokenizer.nextToken()
                val fifthLink = tokenizer.nextToken()
                val sixthLink = tokenizer.nextToken()
                val seventhLink = tokenizer.nextToken()
                val eightLink = tokenizer.nextToken()
                Hawk.put(DL1, firstLink)
                Hawk.put(DL2, secondLink)
                Hawk.put(DL3, thirdLink)
                Hawk.put(DL4, fourthLink)
                Hawk.put(DL5, fifthLink)
                Hawk.put(DL6, sixthLink)
                Hawk.put(DL7, seventhLink)
                Hawk.put(DL8, eightLink)
                Hawk.put(CNSTNC.FULL_DEEPLINK, conjoined)

                mc()
                finish()
            }
            if (appLinkData == null){
                Log.d("FB_TEST:", "Params = null")
                mc()
                finish()
            }
        }
    }

    private fun normalizer(str: String):String{
        if(str[0] == '[')
            return str.substring(1, str.length-1).replace("][", "_")
        else
            return str
    }

    private fun appsIntegration() {
        val conversionDataListener = object : AppsFlyerConversionListener {
            override fun onConversionDataSuccess(data: Map<String, Any>) {
                Log.d("TESTING_ZONE", "af stat is " + data["af_status"])
                stringH = (data["campaign"] as String?)!!
                Log.d("NAMING", "campaign attributed: $stringH")

                val tokenizer = StringTokenizer(normalizer(stringH), "_")

                val one = tokenizer.nextToken()
                val two = tokenizer.nextToken()
                val three = tokenizer.nextToken()
                val four = tokenizer.nextToken()
                val five = tokenizer.nextToken()
                val six = tokenizer.nextToken()
                val seven = tokenizer.nextToken()
                val eight = tokenizer.nextToken()
                Hawk.put(CNSTNC.C11, one)
                Hawk.put(CNSTNC.C22, two)
                Hawk.put(CNSTNC.C33, three)
                Hawk.put(CNSTNC.C44, four)
                Hawk.put(CNSTNC.C55, five)
                Hawk.put(CNSTNC.C66, six)
                Hawk.put(CNSTNC.C77, seven)
                Hawk.put(CNSTNC.C88, eight)
                Hawk.put(CNSTNC.FULL_NAMING, stringH)
                appLin()
                mc()
                finish()
            }

            override fun onConversionDataFail(error: String?) {
                Log.e("LOG_TAG", "error onAttributionFailure :  $error")

                appLin()

                mc()
                finish()
            }

            override fun onAppOpenAttribution(data: MutableMap<String, String>?) {
                data?.map {
                    Log.d("LOG_TAG", "onAppOpen_attribute: ${it.key} = ${it.value}")
                }
            }

            override fun onAttributionFailure(error: String?) {
                Log.e("LOG_TAG", "error onAttributionFailure :  $error")
            }
        }
        AppsFlyerLib.getInstance().init(CNSTNC.AF_DEV_KEY, conversionDataListener, applicationContext)
        AppsFlyerLib.getInstance().start(this)
    }
}