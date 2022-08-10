plugins {
    id(GradlePluginId.ANDROID_APPLICATION)
    id(GradlePluginId.KOTLIN_ANDROID_EXTENSIONS)
    kotlin("android")
}

android {
    compileSdkVersion(AndroidConfig.COMPILE_SDK_VERSION)
    buildToolsVersion(AndroidConfig.BUILD_TOOLS_VERSION)

    defaultConfig {
        applicationId(AndroidConfig.ID)
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
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    api(project(ModuleDependency.LIBRARY_RESOURCES))
    api(project(ModuleDependency.LIBRARY_CORE))

    implementation(LibraryDependency.recyclerView)
    implementation(LibraryDependency.constrainLayout)

    implementation(LibraryDependency.navigationFragment)
    implementation(LibraryDependency.navigationUi)

    testImplementation(TestDependency.jUnit)
    testImplementation(TestDependency.kluent)
    androidTestImplementation(TestDependency.kluentAndroid)
    testImplementation(TestDependency.mockk)
    testImplementation(TestDependency.coroutines)
    testImplementation(TestDependency.arch)
}