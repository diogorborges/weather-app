internal object LibraryVersion {
    const val LIFE_CYCLE_VERSION = "2.2.0"
    const val KOTLIN_VERSION = "1.4.31"
    const val CORE_KTX_VERSION = "1.2.0"
    const val APP_COMPAT_VERSION = "1.3.1"
    const val MATERIAL_VERSION = "1.4.0"
    const val NAVIGATION_VERSION = "2.5.1"
    const val CONSTRAINT_LAYOUT_VERSION = "1.1.3"
    const val FRAGMENT_VERSION = "1.5.1"
    const val KODEIN_VERSION = "6.5.5"
    const val GSON_VERSION = "2.8.8"
    const val OK_HTTP_VERSION = "4.7.2"
    const val COROUTINES_VERSION = "1.4.3"
    const val RETROFIT_VERSION = "2.7.0"
    const val GLIDE_VERSION = "4.13.0"
}

object LibraryDependency {
    val lifeCycleViewModel by lazy { "androidx.lifecycle:lifecycle-viewmodel-ktx:${LibraryVersion.LIFE_CYCLE_VERSION}" }
    val lifeCycleLiveData by lazy { "androidx.lifecycle:lifecycle-livedata-ktx:${LibraryVersion.LIFE_CYCLE_VERSION}" }
    val kotlin by lazy { "org.jetbrains.kotlin:kotlin-stdlib:${LibraryVersion.KOTLIN_VERSION}" }
    val coreKtx by lazy { "androidx.core:core-ktx:${LibraryVersion.CORE_KTX_VERSION}" }
    val appCompat by lazy { "androidx.appcompat:appcompat:${LibraryVersion.APP_COMPAT_VERSION}" }
    val material by lazy { "com.google.android.material:material:${LibraryVersion.MATERIAL_VERSION}" }
    val fragmentKtx by lazy { "androidx.fragment:fragment-ktx:${LibraryVersion.FRAGMENT_VERSION}" }
    val navigationFragment by lazy { "androidx.navigation:navigation-fragment-ktx:${LibraryVersion.NAVIGATION_VERSION}" }
    val navigationUi by lazy { "androidx.navigation:navigation-ui-ktx:${LibraryVersion.NAVIGATION_VERSION}" }
    val constrainLayout by lazy { "androidx.constraintlayout:constraintlayout:${LibraryVersion.CONSTRAINT_LAYOUT_VERSION}" }
    val kodein by lazy { "org.kodein.di:kodein-di-generic-jvm:${LibraryVersion.KODEIN_VERSION}" }
    val kodeinFramework by lazy { "org.kodein.di:kodein-di-framework-android-x:${LibraryVersion.KODEIN_VERSION}" }
    val gson by lazy { "com.google.code.gson:gson:${LibraryVersion.GSON_VERSION}" }
    val okHttp by lazy { "com.squareup.okhttp3:okhttp:${LibraryVersion.OK_HTTP_VERSION}" }
    val loggingInterceptor by lazy { "com.squareup.okhttp3:logging-interceptor:${LibraryVersion.OK_HTTP_VERSION}" }
    val coroutinesAndroid by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-android:${LibraryVersion.COROUTINES_VERSION}" }
    val coroutinesCore by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-core:${LibraryVersion.COROUTINES_VERSION}" }
    val retrofit by lazy { "com.squareup.retrofit2:retrofit:${LibraryVersion.RETROFIT_VERSION}" }
    val retrofitAdapters by lazy { "com.squareup.retrofit2:retrofit-adapters:${LibraryVersion.RETROFIT_VERSION}" }
    val retrofitGsonConverter by lazy { "com.squareup.retrofit2:converter-gson:${LibraryVersion.RETROFIT_VERSION}" }
    val glide by lazy { "com.github.bumptech.glide:glide:${LibraryVersion.GLIDE_VERSION}" }
    val glideCompiler by lazy { "com.github.bumptech.glide:compiler:${LibraryVersion.GLIDE_VERSION}" }
}