/**
 * This code was generated by [react-native-codegen](https://www.npmjs.com/package/react-native-codegen).
 *
 * Do not edit this file as changes may cause incorrect behavior and will be lost
 * once the code is regenerated.
 *
 * @generated by codegen project: GenerateModuleH.js
 */

#include "RTNGreeterSpecJSI.h"

namespace facebook {
namespace react {

static jsi::Value __hostFunction_NativeGreeterCxxSpecJSI_add(jsi::Runtime &rt, TurboModule &turboModule, const jsi::Value* args, size_t count) {
  return static_cast<NativeGreeterCxxSpecJSI *>(&turboModule)->add(rt, args[0].asNumber(), args[1].asNumber());
}

NativeGreeterCxxSpecJSI::NativeGreeterCxxSpecJSI(std::shared_ptr<CallInvoker> jsInvoker)
  : TurboModule("RTNGreeter", jsInvoker) {
  methodMap_["add"] = MethodMetadata {2, __hostFunction_NativeGreeterCxxSpecJSI_add};
}


} // namespace react
} // namespace facebook
