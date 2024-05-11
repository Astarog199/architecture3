package ru.gb.android.homework3.di

import dagger.Module
import ru.gb.android.homework3.presentation.product.di.ProductListComponent

@Module(subcomponents = [
    ProductListComponent::class,
    ProductListComponent::class,

])
object SubcomponentsModule