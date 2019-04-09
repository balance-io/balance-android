package io.balance.data.remote


import io.balance.data.model.Pokemon
import io.balance.data.model.PokemonListResponse
import io.balance.data.model.TickerPrice
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CoinMarketCapApi {

    @GET("ticker/{ticker}/")
    fun getTickerPrice(@Path("ticker") ticker: String) : Single<List<TickerPrice>>

    @GET("ticker")
    fun getPrices() : Single<List<TickerPrice>>

    @GET("pokemon")
    fun getPokemonList(@Query("limit") limit: Int): Single<PokemonListResponse>

    @GET("pokemon/{name}")
    fun getPokemon(@Path("name") name: String): Single<Pokemon>

}
