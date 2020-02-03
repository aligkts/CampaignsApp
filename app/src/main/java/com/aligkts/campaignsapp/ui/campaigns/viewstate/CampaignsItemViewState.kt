package com.aligkts.campaignsapp.ui.campaigns.viewstate

import com.aligkts.campaignsapp.common.ui.calculateRemainingTime
import com.aligkts.campaignsapp.ui.campaigns.model.Banners
import com.aligkts.campaignsapp.ui.campaigns.model.HotDeals

/**
 * Created by Ali Göktaş on 02,February,2020
 */

class CampaignsItemViewState(private val hotDeals: HotDeals,
                             private val banners: Banners) {

    fun getHotDealTitle() = hotDeals.title
    fun getHotDealExpirationDate() = hotDeals.expirationDate.calculateRemainingTime()
    fun getBannerImageWidth() = banners.image?.width
    fun getBannerImageHeight() = banners.image?.height
    fun getBannerImageUrl() = banners.image?.url

}