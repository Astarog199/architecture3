package ru.gb.android.homework3

import android.app.Application
import ru.gb.android.homework3.di.AppComponent
import ru.gb.android.homework3.di.DaggerAppComponent

class MarketSampleApp: Application() {

    val appComponent: AppComponent = DaggerAppComponent.factory().create(this)
}
