package io.balance.runner

import android.app.Application
import android.content.Context
import io.appflate.restmock.android.RESTMockTestRunner
import io.balance.BalanceApplication

/**
 * Created by ravindra on 4/2/17.
 */
class TestRunner : RESTMockTestRunner() {

    @Throws(InstantiationException::class, IllegalAccessException::class, ClassNotFoundException::class)
    override fun newApplication(cl: ClassLoader, className: String, context: Context): Application {
        return super.newApplication(cl, BalanceApplication::class.java.name, context)
    }

}
