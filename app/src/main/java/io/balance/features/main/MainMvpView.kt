package io.balance.features.main

import io.balance.features.base.MvpView

interface MainMvpView : MvpView {

    fun showBalances(balanceViewModel: BalancesViewModel)

    fun showBalances(pokemon: List<String>)

    fun showProgress(show: Boolean)

    fun showError(error: Throwable)

}