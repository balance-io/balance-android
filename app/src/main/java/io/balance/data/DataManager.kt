package io.balance.data

import io.balance.data.model.CDP
import io.balance.data.model.Pokemon
import io.balance.data.model.TickerPrice
import io.balance.data.model.WalletBalances
import io.balance.data.remote.CoinMarketCapApi
import io.balance.data.remote.EthplorerApi
import io.balance.data.remote.MkrToolsApi
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DataManager @Inject
constructor(private val ethplorerApi: EthplorerApi,
            private val mkrToolsApi: MkrToolsApi,
            private val coinMarketCapApi: CoinMarketCapApi) {

    fun getPrice(ticker: String): Single<List<TickerPrice>> = coinMarketCapApi.getTickerPrice(ticker)

    fun getPrices(): Single<List<TickerPrice>> = coinMarketCapApi.getPrices()

    fun getCDPs(address: String): Single<List<CDP>> = mkrToolsApi.getCDPs(address)

    fun getWalletBalances(address: String): Single<WalletBalances> = ethplorerApi.getWalletBalances(address)

    fun getPokemonList(limit: Int): Single<List<String>> {
        return coinMarketCapApi.getPokemonList(limit)
                .toObservable()
                .flatMapIterable { (results) -> results }
                .map { (name) -> name }
                .toList()
    }

    fun getPokemon(name: String): Single<Pokemon> {
        return coinMarketCapApi.getPokemon(name)
    }
}