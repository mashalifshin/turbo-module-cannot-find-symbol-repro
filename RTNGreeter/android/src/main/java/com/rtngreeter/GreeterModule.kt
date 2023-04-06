package com.rtngreeter

import com.facebook.react.bridge.Promise
import com.facebook.react.bridge.ReactApplicationContext
import com.rtngreeter.NativeCGreeterSpec

class GreeterModule(reactContext: ReactApplicationContext) : NativeGreeterSpec(reactContext) {

  override fun getName() = NAME

  override fun greet(name: string) {
    return "Well hello there, $name"
  }

  companion object {
    const val NAME = "RTNGreeter"
  }
}