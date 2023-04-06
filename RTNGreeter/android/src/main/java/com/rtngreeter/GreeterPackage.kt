package com.rtngreeter;

import com.facebook.react.TurboReactPackage
import com.facebook.react.bridge.NativeModule
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.module.model.ReactModuleInfo
import com.facebook.react.module.model.ReactModuleInfoProvider

class GreeterPackage : TurboReactPackage() {
  override fun getModule(name: String?, reactContext: ReactApplicationContext): NativeModule? =
    if (name == GreeterModule.NAME) {
      GreeterModule(reactContext)
    } else {
      null
    }

 override fun getReactModuleInfoProvider() = ReactModuleInfoProvider {
   mapOf(
     GreeterModule.NAME to ReactModuleInfo(
       GreeterModule.NAME,
       GreeterModule.NAME,
       false, // canOverrideExistingModule
       false, // needsEagerInit
       true, // hasConstants
       false, // isCxxModule
       true // isTurboModule
     )
   )
 }
}