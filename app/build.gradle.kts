plugins {
  id("org.jetbrains.kotlin.android") version "2.0.0"
  id("org.jetbrains.kotlin.plugin.compose") version "2.0.0"
  id("com.android.application") version "8.5.0"
}

android {
  namespace = "land.sungbin.compose.playground"
  compileSdk = 34

  defaultConfig {
    minSdk = 30
  }

  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
  }

  sourceSets {
    getByName("main").java.srcDir("src/main/kotlin")
  }
}

dependencies {
  implementation("androidx.compose.runtime:runtime:1.6.8")
  implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.9.0-RC")
}
