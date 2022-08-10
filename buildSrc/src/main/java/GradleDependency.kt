private object GradleVersion {
    const val ANDROID = "4.2.2"
    const val KOTLIN = "1.5.31"
}

object GradleDependency {
    val android by lazy { "com.android.tools.build:gradle:${GradleVersion.ANDROID}" }
    val kotlin by lazy { "org.jetbrains.kotlin:kotlin-gradle-plugin:${GradleVersion.KOTLIN}" }
}

object GradlePluginId {
    const val KOTLIN_ANDROID_EXTENSIONS = "org.jetbrains.kotlin.android.extensions"
    const val ANDROID_APPLICATION = "com.android.application"
    const val ANDROID_LIBRARY = "com.android.library"
}