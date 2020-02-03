package com.aligkts.campaignsapp.common.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.aligkts.campaignsapp.common.di.ViewModelFactory
import com.aligkts.campaignsapp.common.di.key.ViewModelKey
import com.aligkts.campaignsapp.ui.campaigns.viewmodel.CampaignsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by Ali Göktaş on 01,February,2020
 */

@Module
abstract class ViewModelModule {

    @IntoMap
    @Binds
    @ViewModelKey(CampaignsViewModel::class)
    abstract fun provideCampaignsViewModel(campaignsViewModel: CampaignsViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory
}