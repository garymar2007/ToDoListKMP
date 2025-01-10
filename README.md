This is a Kotlin Multiplatform project targeting Android, iOS, Desktop.

* `/composeApp` is for code that will be shared across your Compose Multiplatform applications.
  It contains several subfolders:
  - `commonMain` is for code that’s common for all targets.
  - Other folders are for Kotlin code that will be compiled for only the platform indicated in the folder name.
    For example, if you want to use Apple’s CoreCrypto for the iOS part of your Kotlin app,
    `iosMain` would be the right folder for such calls.

* `/iosApp` contains iOS applications. Even if you’re sharing your UI with Compose Multiplatform, 
  you need this entry point for your iOS app. This is also where you should add SwiftUI code for your project.


Learn more about [Kotlin Multiplatform](https://www.jetbrains.com/help/kotlin-multiplatform-dev/get-started.html)…

Original project: 
 - Video: https://www.youtube.com/watch?v=1TLk36FdmMA
 - Source Code: https://github.com/stevdza-san/ToDo-App-Compose-Multiplatform/tree/main

Libraries used:
 - Material3
 - theme-builder: https://m3.material.io/theme-builder
 - voyager: https://voyager.adriel.cafe (A multiplatform navigation library built for, and seamlessly integrated with, Jetpack Compose)
 - koin: Koin is a smart Kotlin dependency injection library to keep you focused on your app, not on your tools

Running apps:
 - Android: run composeApp in Android Studio IDE
 - Desktop: ./gradlew run (not working)
 - iOS: need to run in iOS computer

Release:
 - Android: In Android Studio IDE: 
    Go to Build
      --> Generated Signed App Bundle / APK 
      --> Create Key store(/home/garyma/todolistkmp.jks)
      --> keystore password: 123456; key alias: todolistkmp key password: 123456
      --> build Release
      --> you will find the compostApp-release.apk file in the composeApp/release folder