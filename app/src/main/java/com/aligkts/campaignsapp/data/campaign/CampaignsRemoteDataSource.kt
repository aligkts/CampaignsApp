package com.aligkts.campaignsapp.data.campaign

import com.aligkts.campaignsapp.data.CampaignsRestInterface
import javax.inject.Inject

/**
 * Created by Ali Göktaş on 01,February,2020
 */

class CampaignsRemoteDataSource @Inject constructor(private val restInterface: CampaignsRestInterface) {

    fun fetchCampaigns(page: Int) = restInterface.fetchCampaigns(page)

}