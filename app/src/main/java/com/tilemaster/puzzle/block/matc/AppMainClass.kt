package com.tilemaster.puzzle.block.matc

import android.app.Application
import android.content.Context
import com.onesignal.OneSignal
import com.orhanobut.hawk.Hawk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class AppMainClass: Application() {
    override fun onCreate() {
        super.onCreate()
        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE)
        OneSignal.initWithContext(this)
        OneSignal.setAppId(CNSTNC.ONESIGNAL_APP_ID)
        GlobalScope.launch(Dispatchers.IO) {
            applyDeviceId(context = applicationContext)
        }
        Hawk.init(this).build()
    }

    private suspend fun applyDeviceId(context: Context) {
        val advertisingInfo = AData(context)
        val idInfo = advertisingInfo.getAdvertisingId()
        Hawk.put(CNSTNC.MAIN_ID, idInfo)
    }

}