plugins {
  id("org.jetbrains.kotlin.android") version "2.1.21"
  id("org.jetbrains.kotlin.plugin.compose") version "2.1.21"
  id("com.android.application") version "8.10.1"
}

android {
  namespace = "land.sungbin.compose.playground"
  compileSdk = 35

  defaultConfig {
    minSdk = 30
  }

  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
  }

  sourceSets {
    getByName("main").java.srcDir("src/main/kotlin")
  }
}

dependencies {
  implementation("androidx.compose.runtime:runtime:1.8.2")
  implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.10.2")
}
