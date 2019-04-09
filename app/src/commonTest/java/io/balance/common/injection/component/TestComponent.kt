package io.balance.common.injection.component

import dagger.Component
import io.balance.common.injection.module.ApplicationTestModule
import io.balance.injection.component.AppComponent
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationTestModule::class])
interface TestComponent : AppComponent