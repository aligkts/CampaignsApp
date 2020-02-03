package com.aligkts.campaignsapp.data.campaign

import com.aligkts.campaignsapp.common.Resource
import com.aligkts.campaignsapp.common.ui.applyLoading
import com.aligkts.campaignsapp.data.campaign.response.CampaignResponse
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by Ali Göktaş on 01,February,2020
 */
class CampaignsRepository @Inject constructor(private val campaignsRemoteDataSource: CampaignsRemoteDataSource) {

    fun fetchCampaigns(page: Int): Observable<Resource<CampaignResponse>> =
        campaignsRemoteDataSource
            .fetchCampaigns(page)
            .map { Resource.success(it) }
            .onErrorReturn { Resource.error(it) }
            .subscribeOn(Schedulers.io())
            .compose(applyLoading())
}