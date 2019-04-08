package io.balance

import android.content.Context
import androidx.multidex.MultiDexApplication
import com.facebook.stetho.Stetho
import com.singhajit.sherlock.core.Sherlock
import com.squareup.leakcanary.LeakCanary
import com.tspoon.traceur.Traceur
import io.balance.injection.component.AppComponent
import io.balance.injection.component.DaggerAppComponent
import io.balance.injection.module.AppModule
import timber.log.Timber

class BalanceApplication : MultiDexApplication() {

    private var appComponent: AppComponent? = null

    companion object {
        operator fun get(context: Context): BalanceApplication {
            return context.applicationContext as BalanceApplication
        }
    }

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
            Stetho.initializeWithDefaults(this)
            LeakCanary.install(this)
            Sherlock.init(this)
            Traceur.enableLogging()
        }
    }

    // Needed to replace the component with a test specific one
    var component: AppComponent
        get() {
            if (appComponent == null) {
                appComponent = DaggerAppComponent.builder()
                        .appModule(AppModule(this))
                        .build()
            }
            return appComponent as AppComponent
        }
        set(appComponent) {
            this.appComponent = appComponent
        }

}