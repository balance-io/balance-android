package io.balance.data.remote

import android.content.Context
import com.facebook.stetho.okhttp3.StethoInterceptor
import com.readystatesoftware.chuck.ChuckInterceptor
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import io.balance.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import timber.log.Timber

object BalanceApiFactory {

    fun makeEthExplorerApi(context: Context): EthplorerApi {
        val okHttpClient = makeOkHttpClient(provideHttpLoggingInterceptor(), provideChuckInterceptor(context), provideStetho())
        return makeEthplorerService(okHttpClient, provideMoshi(), BuildConfig.ETHPLORER_API_URL)
    }

    fun makeMkrToolsApi(context: Context): MkrToolsApi {
        val okHttpClient = makeOkHttpClient(provideHttpLoggingInterceptor(), provideChuckInterceptor(context), provideStetho())
        return makeMkrToolsService(okHttpClient, provideMoshi(), BuildConfig.MKR_TOOLS_API_URL)
    }

    fun makeCoinMarketCapApi(context: Context): CoinMarketCapApi {
        val okHttpClient = makeOkHttpClient(provideHttpLoggingInterceptor(), provideChuckInterceptor(context), provideStetho())
        return makeCoinMarketCapService(okHttpClient, provideMoshi(), BuildConfig.COINMARKETCAP_API_URL)
    }


    fun makeCoinMarketCapService(okHttpClient: OkHttpClient, moshi: Moshi, baseUrl: String): CoinMarketCapApi {
        val retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
        return retrofit.create(CoinMarketCapApi::class.java)
    }

    fun makeMkrToolsService(okHttpClient: OkHttpClient, moshi: Moshi, baseUrl: String): MkrToolsApi {
        val retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
        return retrofit.create(MkrToolsApi::class.java)
    }

    fun makeEthplorerService(okHttpClient: OkHttpClient, moshi: Moshi, baseUrl: String): EthplorerApi {
        val retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
        return retrofit.create(EthplorerApi::class.java)
    }

    fun makeOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor,
                         chuckInterceptor: ChuckInterceptor,
                         stethoInterceptor: StethoInterceptor): OkHttpClient {
        val httpClientBuilder = OkHttpClient.Builder()
        if (BuildConfig.DEBUG) {
            httpClientBuilder.addInterceptor(httpLoggingInterceptor)
            httpClientBuilder.addInterceptor(chuckInterceptor)
            httpClientBuilder.addNetworkInterceptor(stethoInterceptor)
        }
        return httpClientBuilder.build()
    }

    fun provideMoshi(): Moshi = Moshi
            .Builder()
            .add(KotlinJsonAdapterFactory())
            .build()


    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor =
            HttpLoggingInterceptor { message ->
                Timber.d(message)
            }.setLevel(HttpLoggingInterceptor.Level.BODY)

    fun provideChuckInterceptor(context: Context): ChuckInterceptor = ChuckInterceptor(context)

    fun provideStetho(): StethoInterceptor = StethoInterceptor()

}


