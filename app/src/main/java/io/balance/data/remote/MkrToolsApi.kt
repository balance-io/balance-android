package io.balance.data.remote

import io.balance.data.model.CDP
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface MkrToolsApi {

    @GET("lad/{addresss}")
    fun getCDPs(@Path("addresss") addresss: String): Single<List<CDP>>
}
