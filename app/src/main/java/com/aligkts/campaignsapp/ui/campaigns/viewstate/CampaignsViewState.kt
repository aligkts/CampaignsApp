package com.aligkts.campaignsapp.ui.campaigns.viewstate

import com.aligkts.campaignsapp.common.Status
import com.aligkts.campaignsapp.ui.campaigns.model.Campaigns

/**
 * Created by Ali Göktaş on 02,February,2020
 */
class CampaignsViewState(
    val status: Status,
    val error: Throwable? = null,
    val data: Campaigns? = null
) {

    fun getCampaigns() = data

    fun getHotDeals() = data?.hotDeals ?: mutableListOf()

    fun getBanners() = data?.banners ?: mutableListOf()

    fun isLoading() = status == Status.LOADING

    fun getErrorMessage() = error?.message

    fun shouldShowErrorMessage() = error != null
}