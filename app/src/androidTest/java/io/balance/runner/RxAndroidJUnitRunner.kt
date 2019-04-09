package io.balance.runner

import android.os.Bundle
import androidx.test.espresso.Espresso
import io.balance.util.RxIdlingExecutionHook
import io.balance.util.RxIdlingResource
import rx.plugins.RxJavaPlugins

/**
 * Runner that registers a Espresso Indling resource that handles waiting for
 * RxJava Observables to finish.
 * WARNING - Using this runner will block the tests if the application uses long-lived hot
 * Observables such us event buses, etc.
 */
class RxAndroidJUnitRunner : UnlockDeviceAndroidJUnitRunner() {

    override fun onCreate(arguments: Bundle) {
        super.onCreate(arguments)
        val rxIdlingResource = RxIdlingResource()
        RxJavaPlugins.getInstance()
                .registerObservableExecutionHook(RxIdlingExecutionHook(rxIdlingResource))
        Espresso.registerIdlingResources(rxIdlingResource)
    }
}