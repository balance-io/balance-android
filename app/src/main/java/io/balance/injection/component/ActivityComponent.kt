package io.balance.injection.component

import dagger.Subcomponent
import io.balance.features.base.BaseActivity
import io.balance.features.detail.DetailActivity
import io.balance.features.main.MainActivity
import io.balance.injection.PerActivity
import io.balance.injection.module.ActivityModule

@PerActivity
@Subcomponent(modules = [ActivityModule::class])
interface ActivityComponent {
    fun inject(baseActivity: BaseActivity)

    fun inject(mainActivity: MainActivity)

    fun inject(detailActivity: DetailActivity)
}
