This repo is for posting on the [React Native New Architecture discussion/community feedback working group](https://reactnative.dev/docs/the-new-architecture/pillars-turbomodules#android). I've applied to be able to participate, so hopefully they'll let me in and lmk what I'm doing wrong. 

The setup
- An out-of-the-box react native app built according to the [getting started instructions](https://reactnative.dev/docs/environment-setup?guide=native&platform=ios&package-manager=npm&os=macos#installing-dependencies)
- A turbo module set up according to [the guide here](https://reactnative.dev/docs/the-new-architecture/pillars-turbomodules#android). 
 
The difference is that the module is named slightly differently (the module is a `Greeter`, unlike the example `Calculator`), and has a function named `greet` (instead of `add`), and returns a different type (`string` instead of `promise` -- I've also tried returning a Promise here and I get the same error). Only the Android / kotlin side is implemented, and I'm only running in Android, but the error is related to the Android build. I have not tried iOS yet.

This is the exception I'm currently getting when attempting `npx react-native run-android`
```bash
$ npx react-native run-android

warn Multiple Podfiles were found: ios/Podfile,vendor/bundle/ruby/3.0.0/gems/cocoapods-core-1.12.0/lib/cocoapods-core/Podfile. Choosing ios/Podfile automatically. If you would like to select a different one, you can configure it via "project.ios.sourceDir". You can learn more about it here: https://github.com/react-native-community/cli/blob/master/docs/configuration.md
info Starting JS server...
info Launching emulator...
info Successfully launched emulator.
info Installing the app...

> Task :app:configureCMakeDebug[arm64-v8a]
C/C++: CMake Warning at /Users/masha/Library/Android/sdk/ndk/23.1.7779620/build/cmake/android-legacy.toolchain.cmake:416 (message):
C/C++:   An old version of CMake is being used that cannot automatically detect
C/C++:   compiler attributes.  Compiler identification is being bypassed.  Some
C/C++:   values may be wrong or missing.  Update to CMake 3.19 or newer to use
C/C++:   CMake's built-in compiler identification.
C/C++: Call Stack (most recent call first):
C/C++:   /Users/masha/Library/Android/sdk/ndk/23.1.7779620/build/cmake/android.toolchain.cmake:55 (include)
C/C++:   /Users/masha/Library/Android/sdk/cmake/3.18.1/share/cmake-3.18/Modules/CMakeDetermineSystem.cmake:93 (include)
C/C++:   CMakeLists.txt:28 (project)
C/C++: CMake Warning at /Users/masha/Library/Android/sdk/ndk/23.1.7779620/build/cmake/android-legacy.toolchain.cmake:416 (message):
C/C++:   An old version of CMake is being used that cannot automatically detect
C/C++:   compiler attributes.  Compiler identification is being bypassed.  Some
C/C++:   values may be wrong or missing.  Update to CMake 3.19 or newer to use
C/C++:   CMake's built-in compiler identification.
C/C++: Call Stack (most recent call first):
C/C++:   /Users/masha/Library/Android/sdk/ndk/23.1.7779620/build/cmake/android.toolchain.cmake:55 (include)
C/C++:   /Users/masha/Code/FlorenceX-Inc/experiments/turbo-module-cannot-find-symbol-repoducer/AwesomeProject/android/app/.cxx/Debug/391g4d4p/arm64-v8a/CMakeFiles/3.18.1-g262b901/CMakeSystem.cmake:6 (include)
C/C++:   /Users/masha/Code/FlorenceX-Inc/experiments/turbo-module-cannot-find-symbol-repoducer/AwesomeProject/android/app/.cxx/Debug/391g4d4p/arm64-v8a/CMakeFiles/CMakeTmp/CMakeLists.txt:2 (project)
C/C++: CMake Warning at /Users/masha/Library/Android/sdk/ndk/23.1.7779620/build/cmake/android-legacy.toolchain.cmake:416 (message):
C/C++:   An old version of CMake is being used that cannot automatically detect
C/C++:   compiler attributes.  Compiler identification is being bypassed.  Some
C/C++:   values may be wrong or missing.  Update to CMake 3.19 or newer to use
C/C++:   CMake's built-in compiler identification.
C/C++: Call Stack (most recent call first):
C/C++:   /Users/masha/Library/Android/sdk/ndk/23.1.7779620/build/cmake/android.toolchain.cmake:55 (include)
C/C++:   /Users/masha/Code/FlorenceX-Inc/experiments/turbo-module-cannot-find-symbol-repoducer/AwesomeProject/android/app/.cxx/Debug/391g4d4p/arm64-v8a/CMakeFiles/3.18.1-g262b901/CMakeSystem.cmake:6 (include)
C/C++:   /Users/masha/Code/FlorenceX-Inc/experiments/turbo-module-cannot-find-symbol-repoducer/AwesomeProject/android/app/.cxx/Debug/391g4d4p/arm64-v8a/CMakeFiles/CMakeTmp/CMakeLists.txt:2 (project)

> Task :app:configureCMakeDebug[armeabi-v7a]
C/C++: CMake Warning at /Users/masha/Library/Android/sdk/ndk/23.1.7779620/build/cmake/android-legacy.toolchain.cmake:416 (message):
C/C++:   An old version of CMake is being used that cannot automatically detect
C/C++:   compiler attributes.  Compiler identification is being bypassed.  Some
C/C++:   values may be wrong or missing.  Update to CMake 3.19 or newer to use
C/C++:   CMake's built-in compiler identification.
C/C++: Call Stack (most recent call first):
C/C++:   /Users/masha/Library/Android/sdk/ndk/23.1.7779620/build/cmake/android.toolchain.cmake:55 (include)
C/C++:   /Users/masha/Library/Android/sdk/cmake/3.18.1/share/cmake-3.18/Modules/CMakeDetermineSystem.cmake:93 (include)
C/C++:   CMakeLists.txt:28 (project)
C/C++: CMake Warning at /Users/masha/Library/Android/sdk/ndk/23.1.7779620/build/cmake/android-legacy.toolchain.cmake:416 (message):
C/C++:   An old version of CMake is being used that cannot automatically detect
C/C++:   compiler attributes.  Compiler identification is being bypassed.  Some
C/C++:   values may be wrong or missing.  Update to CMake 3.19 or newer to use
C/C++:   CMake's built-in compiler identification.
C/C++: Call Stack (most recent call first):
C/C++:   /Users/masha/Library/Android/sdk/ndk/23.1.7779620/build/cmake/android.toolchain.cmake:55 (include)
C/C++:   /Users/masha/Code/FlorenceX-Inc/experiments/turbo-module-cannot-find-symbol-repoducer/AwesomeProject/android/app/.cxx/Debug/391g4d4p/armeabi-v7a/CMakeFiles/3.18.1-g262b901/CMakeSystem.cmake:6 (include)
C/C++:   /Users/masha/Code/FlorenceX-Inc/experiments/turbo-module-cannot-find-symbol-repoducer/AwesomeProject/android/app/.cxx/Debug/391g4d4p/armeabi-v7a/CMakeFiles/CMakeTmp/CMakeLists.txt:2 (project)
C/C++: CMake Warning at /Users/masha/Library/Android/sdk/ndk/23.1.7779620/build/cmake/android-legacy.toolchain.cmake:416 (message):
C/C++:   An old version of CMake is being used that cannot automatically detect
C/C++:   compiler attributes.  Compiler identification is being bypassed.  Some
C/C++:   values may be wrong or missing.  Update to CMake 3.19 or newer to use
C/C++:   CMake's built-in compiler identification.
C/C++: Call Stack (most recent call first):
C/C++:   /Users/masha/Library/Android/sdk/ndk/23.1.7779620/build/cmake/android.toolchain.cmake:55 (include)
C/C++:   /Users/masha/Code/FlorenceX-Inc/experiments/turbo-module-cannot-find-symbol-repoducer/AwesomeProject/android/app/.cxx/Debug/391g4d4p/armeabi-v7a/CMakeFiles/3.18.1-g262b901/CMakeSystem.cmake:6 (include)
C/C++:   /Users/masha/Code/FlorenceX-Inc/experiments/turbo-module-cannot-find-symbol-repoducer/AwesomeProject/android/app/.cxx/Debug/391g4d4p/armeabi-v7a/CMakeFiles/CMakeTmp/CMakeLists.txt:2 (project)

> Task :app:configureCMakeDebug[x86]
C/C++: CMake Warning at /Users/masha/Library/Android/sdk/ndk/23.1.7779620/build/cmake/android-legacy.toolchain.cmake:416 (message):
C/C++:   An old version of CMake is being used that cannot automatically detect
C/C++:   compiler attributes.  Compiler identification is being bypassed.  Some
C/C++:   values may be wrong or missing.  Update to CMake 3.19 or newer to use
C/C++:   CMake's built-in compiler identification.
C/C++: Call Stack (most recent call first):
C/C++:   /Users/masha/Library/Android/sdk/ndk/23.1.7779620/build/cmake/android.toolchain.cmake:55 (include)
C/C++:   /Users/masha/Library/Android/sdk/cmake/3.18.1/share/cmake-3.18/Modules/CMakeDetermineSystem.cmake:93 (include)
C/C++:   CMakeLists.txt:28 (project)
C/C++: CMake Warning at /Users/masha/Library/Android/sdk/ndk/23.1.7779620/build/cmake/android-legacy.toolchain.cmake:416 (message):
C/C++:   An old version of CMake is being used that cannot automatically detect
C/C++:   compiler attributes.  Compiler identification is being bypassed.  Some
C/C++:   values may be wrong or missing.  Update to CMake 3.19 or newer to use
C/C++:   CMake's built-in compiler identification.
C/C++: Call Stack (most recent call first):
C/C++:   /Users/masha/Library/Android/sdk/ndk/23.1.7779620/build/cmake/android.toolchain.cmake:55 (include)
C/C++:   /Users/masha/Code/FlorenceX-Inc/experiments/turbo-module-cannot-find-symbol-repoducer/AwesomeProject/android/app/.cxx/Debug/391g4d4p/x86/CMakeFiles/3.18.1-g262b901/CMakeSystem.cmake:6 (include)
C/C++:   /Users/masha/Code/FlorenceX-Inc/experiments/turbo-module-cannot-find-symbol-repoducer/AwesomeProject/android/app/.cxx/Debug/391g4d4p/x86/CMakeFiles/CMakeTmp/CMakeLists.txt:2 (project)
C/C++: CMake Warning at /Users/masha/Library/Android/sdk/ndk/23.1.7779620/build/cmake/android-legacy.toolchain.cmake:416 (message):
C/C++:   An old version of CMake is being used that cannot automatically detect
C/C++:   compiler attributes.  Compiler identification is being bypassed.  Some
C/C++:   values may be wrong or missing.  Update to CMake 3.19 or newer to use
C/C++:   CMake's built-in compiler identification.
C/C++: Call Stack (most recent call first):
C/C++:   /Users/masha/Library/Android/sdk/ndk/23.1.7779620/build/cmake/android.toolchain.cmake:55 (include)
C/C++:   /Users/masha/Code/FlorenceX-Inc/experiments/turbo-module-cannot-find-symbol-repoducer/AwesomeProject/android/app/.cxx/Debug/391g4d4p/x86/CMakeFiles/3.18.1-g262b901/CMakeSystem.cmake:6 (include)
C/C++:   /Users/masha/Code/FlorenceX-Inc/experiments/turbo-module-cannot-find-symbol-repoducer/AwesomeProject/android/app/.cxx/Debug/391g4d4p/x86/CMakeFiles/CMakeTmp/CMakeLists.txt:2 (project)

> Task :app:configureCMakeDebug[x86_64]
C/C++: CMake Warning at /Users/masha/Library/Android/sdk/ndk/23.1.7779620/build/cmake/android-legacy.toolchain.cmake:416 (message):
C/C++:   An old version of CMake is being used that cannot automatically detect
C/C++:   compiler attributes.  Compiler identification is being bypassed.  Some
C/C++:   values may be wrong or missing.  Update to CMake 3.19 or newer to use
C/C++:   CMake's built-in compiler identification.
C/C++: Call Stack (most recent call first):
C/C++:   /Users/masha/Library/Android/sdk/ndk/23.1.7779620/build/cmake/android.toolchain.cmake:55 (include)
C/C++:   /Users/masha/Library/Android/sdk/cmake/3.18.1/share/cmake-3.18/Modules/CMakeDetermineSystem.cmake:93 (include)
C/C++:   CMakeLists.txt:28 (project)
C/C++: CMake Warning at /Users/masha/Library/Android/sdk/ndk/23.1.7779620/build/cmake/android-legacy.toolchain.cmake:416 (message):
C/C++:   An old version of CMake is being used that cannot automatically detect
C/C++:   compiler attributes.  Compiler identification is being bypassed.  Some
C/C++:   values may be wrong or missing.  Update to CMake 3.19 or newer to use
C/C++:   CMake's built-in compiler identification.
C/C++: Call Stack (most recent call first):
C/C++:   /Users/masha/Library/Android/sdk/ndk/23.1.7779620/build/cmake/android.toolchain.cmake:55 (include)
C/C++:   /Users/masha/Code/FlorenceX-Inc/experiments/turbo-module-cannot-find-symbol-repoducer/AwesomeProject/android/app/.cxx/Debug/391g4d4p/x86_64/CMakeFiles/3.18.1-g262b901/CMakeSystem.cmake:6 (include)
C/C++:   /Users/masha/Code/FlorenceX-Inc/experiments/turbo-module-cannot-find-symbol-repoducer/AwesomeProject/android/app/.cxx/Debug/391g4d4p/x86_64/CMakeFiles/CMakeTmp/CMakeLists.txt:2 (project)
C/C++: CMake Warning at /Users/masha/Library/Android/sdk/ndk/23.1.7779620/build/cmake/android-legacy.toolchain.cmake:416 (message):
C/C++:   An old version of CMake is being used that cannot automatically detect
C/C++:   compiler attributes.  Compiler identification is being bypassed.  Some
C/C++:   values may be wrong or missing.  Update to CMake 3.19 or newer to use
C/C++:   CMake's built-in compiler identification.
C/C++: Call Stack (most recent call first):
C/C++:   /Users/masha/Library/Android/sdk/ndk/23.1.7779620/build/cmake/android.toolchain.cmake:55 (include)
C/C++:   /Users/masha/Code/FlorenceX-Inc/experiments/turbo-module-cannot-find-symbol-repoducer/AwesomeProject/android/app/.cxx/Debug/391g4d4p/x86_64/CMakeFiles/3.18.1-g262b901/CMakeSystem.cmake:6 (include)
C/C++:   /Users/masha/Code/FlorenceX-Inc/experiments/turbo-module-cannot-find-symbol-repoducer/AwesomeProject/android/app/.cxx/Debug/391g4d4p/x86_64/CMakeFiles/CMakeTmp/CMakeLists.txt:2 (project)

> Task :app:compileDebugJavaWithJavac FAILED
61 actionable tasks: 44 executed, 17 up-to-date
/Users/masha/Code/FlorenceX-Inc/experiments/turbo-module-cannot-find-symbol-repoducer/AwesomeProject/android/app/build/generated/rncli/src/main/java/com/facebook/react/PackageList.java:15: error: cannot find symbol
import com.rtngreeter.GreeterPackage;
                     ^
  symbol:   class GreeterPackage
  location: package com.rtngreeter
/Users/masha/Code/FlorenceX-Inc/experiments/turbo-module-cannot-find-symbol-repoducer/AwesomeProject/android/app/build/generated/rncli/src/main/java/com/facebook/react/PackageList.java:61: error: cannot find symbol
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

BUILD FAILED in 28s

error Failed to install the app. Make sure you have the Android development environment set up: https://reactnative.dev/docs/environment-setup.
Error: Command failed: ./gradlew app:installDebug -PreactNativeDevServerPort=8081
/Users/masha/Code/FlorenceX-Inc/experiments/turbo-module-cannot-find-symbol-repoducer/AwesomeProject/android/app/build/generated/rncli/src/main/java/com/facebook/react/PackageList.java:15: error: cannot find symbol
import com.rtngreeter.GreeterPackage;
                     ^
  symbol:   class GreeterPackage
  location: package com.rtngreeter
/Users/masha/Code/FlorenceX-Inc/experiments/turbo-module-cannot-find-symbol-repoducer/AwesomeProject/android/app/build/generated/rncli/src/main/java/com/facebook/react/PackageList.java:61: error: cannot find symbol
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

BUILD FAILED in 28s

    at makeError (/Users/masha/Code/FlorenceX-Inc/experiments/turbo-module-cannot-find-symbol-repoducer/AwesomeProject/node_modules/execa/index.js:174:9)
    at /Users/masha/Code/FlorenceX-Inc/experiments/turbo-module-cannot-find-symbol-repoducer/AwesomeProject/node_modules/execa/index.js:278:16
    at processTicksAndRejections (node:internal/process/task_queues:96:5)
    at async runOnAllDevices (/Users/masha/Code/FlorenceX-Inc/experiments/turbo-module-cannot-find-symbol-repoducer/AwesomeProject/node_modules/@react-native-community/cli-platform-android/build/commands/runAndroid/runOnAllDevices.js:82:7)
    at async Command.handleAction (/Users/masha/Code/FlorenceX-Inc/experiments/turbo-module-cannot-find-symbol-repoducer/AwesomeProject/node_modules/@react-native-community/cli/build/index.js:108:9)
info Run CLI with --verbose flag for more details.
```

![varundo-error-recording](https://user-images.githubusercontent.com/709758/229642039-689d2ae5-7eb8-45df-9106-e060267d766f.gif)
