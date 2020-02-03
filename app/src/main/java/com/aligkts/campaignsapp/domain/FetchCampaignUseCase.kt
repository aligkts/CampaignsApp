package com.aligkts.campaignsapp.domain

import com.aligkts.campaignsapp.common.Resource
import com.aligkts.campaignsapp.data.campaign.CampaignsRepository
import com.aligkts.campaignsapp.ui.campaigns.model.Campaigns
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by Ali Göktaş on 01,February,2020
 */
class FetchCampaignUseCase @Inject constructor(private val repository: CampaignsRepository,
                                               private val mapper: CampaignsMapper) {

    fun fetchCampaigns(page: Int): Observable<Resource<Campaigns>> {
        return repository
            .fetchCampaigns(page)
            .map { resource ->
                Resource(
                    status = resource.status,
                    data = resource.data?.let{ mapper.mapFrom(it) },
                    error = resource.error
                )
            }
    }

}