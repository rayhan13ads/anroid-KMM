buildscript {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    dependencies {
        //classpath( "com.google.gms:google-services:4.3.13")
        classpath(Build.buildTools)
        classpath(Build.kotlinGradlePlugin)
        classpath(Build.hiltGradlePlugin)
        classpath(Build.sqlDelightGradlePlugin)
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}