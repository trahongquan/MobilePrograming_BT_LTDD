// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()  // Thêm kho lưu trữ Google
        mavenCentral()
    }
}
plugins {
    id("com.android.application") version "8.1.0" apply false
}