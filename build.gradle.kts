// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.jetbrainsKotlinAndroid) apply false
    // LIBRARY
    id ("com.android.library") version "8.3.0" apply false
    //HILT
    id ("com.google.dagger.hilt.android") version "2.49" apply false
}