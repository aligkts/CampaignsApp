package com.aligkts.campaignsapp.ui.campaigns.module

import com.aligkts.campaignsapp.common.di.scope.ActivityScope
import com.aligkts.campaignsapp.ui.campaigns.adapter.CampaignsAdapter
import dagger.Module
import dagger.Provides

/**
 * Created by Ali Göktaş on 02,February,2020
 */
@Module
class CampaignsActivityModule {

    @Provides
    @ActivityScope
    fun provideCampaignsAdapter(): CampaignsAdapter {
        return CampaignsAdapter()
    }

}