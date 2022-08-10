plugins {
    id(GradlePluginId.ANDROID_LIBRARY)
    id(GradlePluginId.KOTLIN_ANDROID_EXTENSIONS)
    kotlin("android")
}

android {
    compileSdkVersion(AndroidConfig.COMPILE_SDK_VERSION)

    defaultConfig {
        minSdkVersion(AndroidConfig.MIN_SDK_VERSION)
        targetSdkVersion(AndroidConfig.TARGET_SDK_VERSION)
        versionCode(AndroidConfig.VERSION_CODE)
        versionName(AndroidConfig.VERSION_NAME)

        testInstrumentationRunner(AndroidConfig.TEST_INSTRUMENTATION_RUNNER)
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            jvmTarget = "1.8"
        }
    }
}

dependencies {
    api(LibraryDependency.kodein)
    api(LibraryDependency.kodeinFramework)
    api(LibraryDependency.appCompat)
    api(LibraryDependency.fragmentKtx)
    api(LibraryDependency.kotlin)
    api(LibraryDependency.coreKtx)
    api(LibraryDependency.material)
    api(LibraryDependency.lifeCycleLiveData)
    api(LibraryDependency.lifeCycleViewModel)
}