plugins {
    id(GradlePluginId.ANDROID_LIBRARY)
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

        buildConfigField(
            "String",
            "BASE_API_URL",
            "\"https://cdn.faire.com/static/mobile-take-home/\""
        )
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
    api(LibraryDependency.gson)

    implementation(LibraryDependency.okHttp)
    implementation(LibraryDependency.loggingInterceptor)
    implementation(LibraryDependency.coroutinesAndroid)
    implementation(LibraryDependency.coroutinesCore)
    implementation(LibraryDependency.retrofit)
    implementation(LibraryDependency.retrofitAdapters)
    implementation(LibraryDependency.retrofitGsonConverter)
    implementation(LibraryDependency.kotlin)
}