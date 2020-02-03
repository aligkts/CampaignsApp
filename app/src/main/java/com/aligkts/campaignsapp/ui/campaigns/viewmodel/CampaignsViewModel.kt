package com.aligkts.campaignsapp.ui.campaigns.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.aligkts.campaignsapp.common.Resource
import com.aligkts.campaignsapp.common.RxAwareViewModel
import com.aligkts.campaignsapp.common.ui.plusAssign
import com.aligkts.campaignsapp.domain.FetchCampaignUseCase
import com.aligkts.campaignsapp.ui.campaigns.model.Campaigns
import com.aligkts.campaignsapp.ui.campaigns.viewstate.CampaignsViewState
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

/**
 * Created by Ali Göktaş on 02,February,2020
 */
class CampaignsViewModel @Inject constructor(private val fetchCampaignsUseCase: FetchCampaignUseCase) :
    RxAwareViewModel() {

    private val campaignsLiveData = MutableLiveData<CampaignsViewState>()

    fun getCampaignsLiveData(): LiveData<CampaignsViewState> = campaignsLiveData

    fun fetchCampaigns(page: Int) {
        fetchCampaignsUseCase
            .fetchCampaigns(page)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(this::onCampaignsResultReady)
            .also {
                disposable += it
            }
    }

    private fun onCampaignsResultReady(resource: Resource<Campaigns>) {
        campaignsLiveData.value = CampaignsViewState(
            status = resource.status,
            error = resource.error,
            data = resource.data
        )
    }
}