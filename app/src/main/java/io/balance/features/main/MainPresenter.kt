package io.balance.features.main

import io.balance.data.DataManager
import io.balance.data.model.CDP
import io.balance.data.model.TickerPrice
import io.balance.data.model.WalletBalances
import io.balance.features.base.BasePresenter
import io.balance.injection.ConfigPersistent
import io.balance.util.rx.scheduler.SchedulerUtils
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Function3
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@ConfigPersistent
class MainPresenter @Inject
constructor(private val dataManager: DataManager) : BasePresenter<MainMvpView>() {

    fun getBalances(address: String) {
        checkViewAttached()
        mvpView?.showProgress(true)

        Single.zip(
                dataManager.getCDPs(address).subscribeOn(Schedulers.io()),
                dataManager.getWalletBalances(address).subscribeOn(Schedulers.io()),
                dataManager.getPrices().subscribeOn(Schedulers.io()),
                        Function3 { cdpResponse: List<CDP>, walletBalanceResponse: WalletBalances, prices:List<TickerPrice>  ->
                    BalancesViewModel(cdpResponse, walletBalanceResponse, prices)
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe( { balanceViewModel ->
                    mvpView?.apply {
                        showProgress(false)
                        showBalances(balanceViewModel)
                    }
                }) { throwable ->
                    mvpView?.apply {
                        showProgress(false)
                        showError(throwable)
                    }
                }
                .bindToLifecycle()

    }


    fun getPokemon(limit: Int) {
        checkViewAttached()
        mvpView?.showProgress(true)
        dataManager.getPokemonList(limit)
                .compose(SchedulerUtils.ioToMain<List<String>>())
                .subscribe({ pokemons ->
                    mvpView?.apply {
                        showProgress(false)
                        showBalances(pokemons)
                    }
                }) { throwable ->
                    mvpView?.apply {
                        showProgress(false)
                        showError(throwable)
                    }
                }
                .bindToLifecycle()
    }
}

data class BalancesViewModel(val cdpResponse: List<CDP>, val walletBalanceResponse: WalletBalances, val prices: List<TickerPrice>)