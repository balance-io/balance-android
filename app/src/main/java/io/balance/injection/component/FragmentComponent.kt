package io.balance.injection.component

import dagger.Subcomponent
import io.balance.injection.PerFragment
import io.balance.injection.module.FragmentModule

/**
 * This component inject dependencies to all Fragments across the application
 */
@PerFragment
@Subcomponent(modules = [FragmentModule::class])
interface FragmentComponent