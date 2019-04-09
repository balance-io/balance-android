package io.balance

import com.nhaarman.mockito_kotlin.doReturn
import com.nhaarman.mockito_kotlin.mock
import io.balance.common.TestDataFactory
import io.balance.data.DataManager
import io.balance.data.model.PokemonListResponse
import io.balance.data.remote.CoinMarketCapApi
import io.balance.data.remote.EthplorerApi
import io.balance.data.remote.MkrToolsApi
import io.balance.util.RxSchedulersOverrideRule
import io.reactivex.Single
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers.anyInt
import org.mockito.ArgumentMatchers.anyString
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DataManagerTest {

    @Rule
    @JvmField
    val overrideSchedulersRule = RxSchedulersOverrideRule()
    val namedResourceList = TestDataFactory.makeNamedResourceList(5)
    val pokemonListResponse = PokemonListResponse(namedResourceList)
    val name = "charmander"
    val pokemon = TestDataFactory.makePokemon(name)
    val mockEthplorerApi: EthplorerApi = mock()
    val mkrToolsApi: MkrToolsApi = mock()
    val coinMarketCapApi: CoinMarketCapApi = mock {
        on { getPokemonList(anyInt()) } doReturn Single.just(pokemonListResponse)
        on { getPokemon(anyString()) } doReturn Single.just(pokemon)
    }

    private var dataManager = DataManager(mockEthplorerApi, mkrToolsApi, coinMarketCapApi)

    @Test
    fun getPokemonListCompletesAndEmitsPokemonList() {
        dataManager.getPokemonList(10)
                .test()
                .assertComplete()
                .assertValue(TestDataFactory.makePokemonNameList(namedResourceList))
    }

    @Test
    fun getPokemonCompletesAndEmitsPokemon() {
        dataManager.getPokemon(name)
                .test()
                .assertComplete()
                .assertValue(pokemon)
    }
}
