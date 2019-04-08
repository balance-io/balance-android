package io.balance.data.remote


import io.balance.data.model.WalletBalances
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface EthplorerApi {

    @GET("getAddressInfo/{address}")
    fun getWalletBalances(@Path("address") address: String): Single<WalletBalances>

}
