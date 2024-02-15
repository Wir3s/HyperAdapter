package com.hyperadapter; // Adjust the package name to match your project's structure

import android.content.Context
import android.os.BatteryManager
import com.facebook.react.bridge.Promise
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod

class BatteryReadout(reactContext: ReactApplicationContext) : ReactContextBaseJavaModule(reactContext) {

    override fun getName(): String {
        return "BatteryReadout"
    }

    @ReactMethod
    fun getBatteryLevel(promise: Promise) {
        val batteryManager = reactApplicationContext.getSystemService(Context.BATTERY_SERVICE) as BatteryManager
        val batteryLevel = batteryManager.getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY)
        promise.resolve(batteryLevel)
    }
}