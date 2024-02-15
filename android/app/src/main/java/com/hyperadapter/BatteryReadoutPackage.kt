package com.hyperadapter // Replace with your actual package name

import com.facebook.react.ReactPackage
import com.facebook.react.bridge.NativeModule
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.uimanager.ViewManager

class BatteryReadoutPackage : ReactPackage {
    override fun createNativeModules(reactContext: ReactApplicationContext): List<NativeModule> {
        // Instantiate and return your BatteryReadout module here
        return listOf(BatteryReadout(reactContext))
    }

    override fun createViewManagers(reactContext: ReactApplicationContext): List<ViewManager<*, *>> {
        // If you're not providing any custom view managers, return an empty list
        return emptyList()
    }
}
