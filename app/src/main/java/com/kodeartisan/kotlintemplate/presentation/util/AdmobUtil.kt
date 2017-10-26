package com.tutorial.learnlinuxpro.presentation.util

import android.content.Context
import android.util.Log
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.InterstitialAd
import com.kodeartisan.kotlintemplate.R

/**
 * Created by kodeartisan on 23/10/17.
 */
object AdmobUtil {

    val TAG = AdmobUtil::class.java.name
    val ARG_PREF_KEY = "ADMOB_SHOW"
    val ARG_TRIGGER_VALUE = 2

    fun loadInterstitial(context: Context, interstitialAd: InterstitialAd): InterstitialAd {
        interstitialAd.adUnitId = context.resources.getString(R.string.admob_insterstitial_key)
        val adRequest = AdRequest.Builder().build()

        interstitialAd.loadAd(adRequest)

        return interstitialAd
    }

    fun showInterstitial(interstitialAd: InterstitialAd) {
        when(interstitialAd.isLoaded) {
            true -> {
                Log.d(TAG, "loaded")
                interstitialAd.show()
            }
            false -> {
                Log.d(TAG, "notLoaded")
                interstitialAd.loadAd(AdRequest.Builder().addTestDevice("9431AFAA6AA09CFC99E925A29A01640C").build())
                interstitialAd.adListener = object : AdListener() {
                    override fun onAdLoaded() {
                        super.onAdLoaded()
                        interstitialAd.show()
                    }
                }
            }
        }
    }

    fun increaseAdmobValue(): Int {
        val oldAdmobValue: Int = PreferencesUtil.getInt(this.ARG_PREF_KEY, 0)
        PreferencesUtil.putInt(this.ARG_PREF_KEY, oldAdmobValue + 1)
        val newAdmobValue = PreferencesUtil.getInt(this.ARG_PREF_KEY, 0)

        return newAdmobValue
    }

    fun resetAdmobValue() = PreferencesUtil.putInt(this.ARG_PREF_KEY, 0)

}