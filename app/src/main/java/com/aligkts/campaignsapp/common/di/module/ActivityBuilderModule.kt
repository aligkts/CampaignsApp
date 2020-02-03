package com.aligkts.campaignsapp.common.di.module

import com.aligkts.campaignsapp.MainActivity
import com.aligkts.campaignsapp.common.di.scope.ActivityScope
import com.aligkts.campaignsapp.ui.campaigns.module.CampaignsActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Ali Göktaş on 01,February,2020
 */
@Module
abstract class ActivityBuilderModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [CampaignsActivityModule::class])
    abstract fun bindMainActivity(): MainActivity
}