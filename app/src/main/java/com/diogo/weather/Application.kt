package com.diogo.weather

import android.app.Application
import com.diogo.core.di.coreModule
import com.diogo.weather.di.appModule
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule

class Application : Application(), KodeinAware {

    override val kodein = Kodein.lazy {
        import(androidXModule(this@Application))
        import(appModule)
        import(coreModule)
    }

}