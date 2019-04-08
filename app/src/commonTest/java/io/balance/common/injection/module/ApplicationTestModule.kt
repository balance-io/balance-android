package io.balance.common.injection.module

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import io.balance.data.DataManager
import io.balance.data.remote.CoinMarketCapApi
import io.balance.data.remote.EthplorerApi
import io.balance.data.remote.MkrToolsApi
import io.balance.injection.ApplicationContext
import org.mockito.Mockito.mock
import javax.inject.Singleton

/**
 * Provides application-level dependencies for an app running on a testing environment
 * This allows injecting mocks if necessary.
 */
@Module
class ApplicationTestModule(private val application: Application) {

    @Provides
    @Singleton
    internal fun provideApplication(): Application {
        return application
    }

    @Provides
    @ApplicationContext
    internal fun provideContext(): Context {
        return application
    }

    /*************
     * MOCKS
     */

    @Provides
    @Singleton
    internal fun providesDataManager(): DataManager {
        return mock(DataManager::class.java)
    }

    @Provides
    @Singleton
    internal fun provideEthplorerApi(): EthplorerApi = mock(EthplorerApi::class.java)

    @Provides
    @Singleton
    internal fun provideMkrToolsApi(): MkrToolsApi = mock(MkrToolsApi::class.java)

    @Provides
    @Singleton
    internal fun provideCoinMarketCapApi(): CoinMarketCapApi = mock(CoinMarketCapApi::class.java)

}
