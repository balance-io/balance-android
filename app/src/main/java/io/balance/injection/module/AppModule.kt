package io.balance.injection.module

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import io.balance.data.remote.BalanceApiFactory
import io.balance.data.remote.CoinMarketCapApi
import io.balance.data.remote.EthplorerApi
import io.balance.data.remote.MkrToolsApi
import io.balance.injection.ApplicationContext
import javax.inject.Singleton

@Module
class AppModule(private val application: Application) {

    @Provides
    internal fun provideApplication(): Application {
        return application
    }

    @Provides
    @ApplicationContext
    internal fun provideContext(): Context {
        return application
    }

    @Provides
    @Singleton
    fun provideEthplorerApi(): EthplorerApi {
        return BalanceApiFactory.makeEthExplorerApi(provideContext())
    }

    @Provides
    @Singleton
    fun provideMkrToolsApi(): MkrToolsApi {
        return BalanceApiFactory.makeMkrToolsApi(provideContext())
    }

    @Provides
    @Singleton
    fun provideCoinMarketCapApi(): CoinMarketCapApi {
        return BalanceApiFactory.makeCoinMarketCapApi(provideContext())
    }
}