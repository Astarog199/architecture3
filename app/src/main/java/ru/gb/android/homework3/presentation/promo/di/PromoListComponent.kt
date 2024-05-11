package ru.gb.android.homework3.presentation.promo.di

import dagger.Subcomponent
import ru.gb.android.homework3.di.FeatureScope
import ru.gb.android.homework3.presentation.promo.PromoListFragment

@FeatureScope
@Subcomponent
interface PromoListComponent {
@Subcomponent.Factory
interface Factory{
    fun create(): PromoListComponent
}
    fun inject(fragment: PromoListFragment)
}