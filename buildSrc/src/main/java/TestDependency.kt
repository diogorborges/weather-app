private object TestVersion {
    const val JUNIT_VERSION = "4.13"
    const val KLUENT_VERSION = "1.64"
    const val MOCKK_VERSION = "1.10.0"
    const val ARCH_VERSION = "2.1.0"
}

object TestDependency {
    val jUnit by lazy { "junit:junit:${TestVersion.JUNIT_VERSION}" }
    val kluent by lazy { "org.amshove.kluent:kluent:${TestVersion.KLUENT_VERSION}" }
    val kluentAndroid by lazy { "org.amshove.kluent:kluent-android:${TestVersion.KLUENT_VERSION}" }
    val mockk by lazy { "io.mockk:mockk:${TestVersion.MOCKK_VERSION}" }
    val coroutines by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-test:${LibraryVersion.COROUTINES_VERSION}" }
    val arch by lazy { "androidx.arch.core:core-testing:${TestVersion.ARCH_VERSION}" }

}