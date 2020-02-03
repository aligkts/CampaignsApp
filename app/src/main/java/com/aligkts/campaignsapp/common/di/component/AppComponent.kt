package com.aligkts.campaignsapp.common.di.component

import android.app.Application
import com.aligkts.campaignsapp.CampaignApplication
import com.aligkts.campaignsapp.common.di.module.ActivityBuilderModule
import com.aligkts.campaignsapp.common.di.module.DataModule
import com.aligkts.campaignsapp.common.di.module.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

/**
 * Created by Ali Göktaş on 01,February,2020
 */

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        ActivityBuilderModule::class,
        ViewModelModule::class,
        DataModule::class
    ]
)
interface AppComponent : AndroidInjector<CampaignApplication> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<CampaignApplication>() {
        @BindsInstance
        abstract fun app(application: Application): Builder
    }

}