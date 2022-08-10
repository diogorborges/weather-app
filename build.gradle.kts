buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(GradleDependency.android)
        classpath(GradleDependency.kotlin)
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

tasks.register("clean", Delete::class){
    delete(rootProject.buildDir)
}