package com.tilemaster.puzzle.block.matc

import android.content.Context
import com.orhanobut.hawk.Hawk
import com.tilemaster.puzzle.block.matc.CNSTNC.C11
import com.tilemaster.puzzle.block.matc.CNSTNC.DL1
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.jsoup.Jsoup

class JSOU(val context:Context) {

    private var jsoup: String? = "null"
    private val hawk : String? = Hawk.get(C11,"null")
    private val hawkTheII : String? = Hawk.get(DL1, "null")
    private var forJsoupSet: String = CNSTNC.mainU + CNSTNC.carryMe + hawk + "&" + CNSTNC.carryMeTwice + hawkTheII

    suspend fun getDocSecretKey(): String?{
        withContext(Dispatchers.IO){
            val doc = Jsoup.connect(forJsoupSet).get()
            jsoup = doc.text().toString()
        }
        return jsoup
    }
}