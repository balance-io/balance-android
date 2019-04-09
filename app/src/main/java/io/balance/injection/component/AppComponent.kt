package io.balance.injection.component

import android.app.Application
import android.content.Context
import dagger.Component
import io.balance.data.DataManager
import io.balance.data.remote.CoinMarketCapApi
import io.balance.data.remote.EthplorerApi
import io.balance.data.remote.MkrToolsApi
import io.balance.injection.ApplicationContext
import io.balance.injection.module.AppModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    @ApplicationContext
    fun context(): Context

    fun application(): Application

    fun dataManager(): DataManager

    fun ethplorerApi(): EthplorerApi

    fun mkrToolsApi(): MkrToolsApi

    fun coinMarketCapApi(): CoinMarketCapApi
}
