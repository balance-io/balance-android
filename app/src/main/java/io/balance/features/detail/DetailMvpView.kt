package io.balance.features.detail

import io.balance.data.model.Pokemon
import io.balance.data.model.Statistic
import io.balance.features.base.MvpView

interface DetailMvpView : MvpView {

    fun showPokemon(pokemon: Pokemon)

    fun showStat(statistic: Statistic)

    fun showProgress(show: Boolean)

    fun showError(error: Throwable)

}