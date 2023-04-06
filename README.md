This repo is for posting on the [React Native New Architecture discussion/community feedback working group](https://reactnative.dev/docs/the-new-architecture/pillars-turbomodules#android). 

The setup
- An out-of-the-box react native app built according to the [getting started instructions](https://reactnative.dev/docs/environment-setup?guide=native&platform=ios&package-manager=npm&os=macos#installing-dependencies)
- A turbo module set up according to [the guide here](https://reactnative.dev/docs/the-new-architecture/pillars-turbomodules#android). 
 
The difference is that the module is named slightly differently (the module is a `Greeter`, unlike the example `Calculator`), and has a function named `greet` (instead of `add`), and returns a different type (`string` instead of `promise` -- I've also tried returning a Promise here and I get the same error). 

Only the Android / kotlin side is implemented in this example. In a different repo I have tried implementing the `Greeter` interface natively on the iOS side as well and am getting a different but perhaps related error.  The app does build and run, but I get this error in the logs: ` LOG  [TypeError: Cannot read property 'greet' of null]`. Let me know if it would be helpful for me to add the native iOS implementation to this repo, too.

This is the exception I'm currently getting when attempting `npx react-native run-android`
```bash
$ npx react-native run-android

warn Multiple Podfiles were found: ios/Podfile,vendor/bundle/ruby/3.0.0/gems/cocoapods-core-1.12.0/lib/cocoapods-core/Podfile. Choosing ios/Podfile automatically. If you would like to select a different one, you can configure it via "project.ios.sourceDir". You can learn more about it here: https://github.com/react-native-community/cli/blob/master/docs/configuration.md
info JS server already running.
info Launching emulator...
info Successfully launched emulator.
info Installing the app...

> Task :app:compileDebugJavaWithJavac FAILED
34 actionable tasks: 3 executed, 31 up-to-date
/Users/masha/Code/turbo-module-cannot-find-symbol-repoducer/AwesomeProject/android/app/build/generated/rncli/src/main/java/com/facebook/react/PackageList.java:15: error: cannot find symbol
import com.rtngreeter.GreeterPackage;
                     ^
  symbol:   class GreeterPackage
  location: package com.rtngreeter
/Users/masha/Code/turbo-module-cannot-find-symbol-repoducer/AwesomeProject/android/app/build/generated/rncli/src/main/java/com/facebook/react/PackageList.java:61: error: cannot find symbol
      new GreeterPackage()
          ^
  symbol:   class GreeterPackage
  location: class PackageList
2 errors

FAILURE: Build completed with 2 failures.

1: Task failed with an exception.
-----------
* What went wrong:
Execution failed for task ':app:compileDebugJavaWithJavac'.
> Compilation failed; see the compiler error output for details.

* Try:
> Run with --stacktrace option to get the stack trace.
> Run with --info or --debug option to get more log output.
> Run with --scan to get full insights.
==============================================================================

2: Task failed with an exception.
-----------
* What went wrong:
java.lang.StackOverflowError (no error message)

* Try:
> Run with --stacktrace option to get the stack trace.
> Run with --info or --debug option to get more log output.
> Run with --scan to get full insights.
==============================================================================

* Get more help at https://help.gradle.org

BUILD FAILED in 3s

error Failed to install the app. Make sure you have the Android development environment set up: https://reactnative.dev/docs/environment-setup.
Error: Command failed: ./gradlew app:installDebug -PreactNativeDevServerPort=8081
/Users/masha/Code/turbo-module-cannot-find-symbol-repoducer/AwesomeProject/android/app/build/generated/rncli/src/main/java/com/facebook/react/PackageList.java:15: error: cannot find symbol
import com.rtngreeter.GreeterPackage;
                     ^
  symbol:   class GreeterPackage
  location: package com.rtngreeter
/Users/masha/Code/turbo-module-cannot-find-symbol-repoducer/AwesomeProject/android/app/build/generated/rncli/src/main/java/com/facebook/react/PackageList.java:61: error: cannot find symbol
      new GreeterPackage()
          ^
  symbol:   class GreeterPackage
  location: class PackageList
2 errors

FAILURE: Build completed with 2 failures.

1: Task failed with an exception.
-----------
* What went wrong:
Execution failed for task ':app:compileDebugJavaWithJavac'.
> Compilation failed; see the compiler error output for details.

* Try:
> Run with --stacktrace option to get the stack trace.
> Run with --info or --debug option to get more log output.
> Run with --scan to get full insights.
==============================================================================

2: Task failed with an exception.
-----------
* What went wrong:
java.lang.StackOverflowError (no error message)

* Try:
> Run with --stacktrace option to get the stack trace.
> Run with --info or --debug option to get more log output.
> Run with --scan to get full insights.
==============================================================================

* Get more help at https://help.gradle.org

BUILD FAILED in 3s

    at makeError (/Users/masha/Code/turbo-module-cannot-find-symbol-repoducer/AwesomeProject/node_modules/execa/index.js:174:9)
    at /Users/masha/Code/turbo-module-cannot-find-symbol-repoducer/AwesomeProject/node_modules/execa/index.js:278:16
    at processTicksAndRejections (node:internal/process/task_queues:96:5)
    at async runOnAllDevices (/Users/masha/Code/turbo-module-cannot-find-symbol-repoducer/AwesomeProject/node_modules/@react-native-community/cli-platform-android/build/commands/runAndroid/runOnAllDevices.js:82:7)
    at async Command.handleAction (/Users/masha/Code/turbo-module-cannot-find-symbol-repoducer/AwesomeProject/node_modules/@react-native-community/cli/build/index.js:108:9)
info Run CLI with --verbose flag for more details.
```

![varundo-error-recording](https://user-images.githubusercontent.com/709758/229642039-689d2ae5-7eb8-45df-9106-e060267d766f.gif)
