package com.aligkts.campaignsapp.domain

import com.aligkts.campaignsapp.common.Mapper
import com.aligkts.campaignsapp.data.campaign.response.CampaignResponse
import com.aligkts.campaignsapp.ui.campaigns.model.Banners
import com.aligkts.campaignsapp.ui.campaigns.model.Campaigns
import com.aligkts.campaignsapp.ui.campaigns.model.HotDeals
import com.aligkts.campaignsapp.ui.campaigns.model.Image
import javax.inject.Inject

/**
 * Created by Ali Göktaş on 02,February,2020
 */
class CampaignsMapper @Inject constructor() : Mapper<CampaignResponse, Campaigns> {

    override fun mapFrom(type: CampaignResponse): Campaigns {
        val hotDeals = type.hotDeals?.map { hotDealsItemResponse ->
            HotDeals(
                title = hotDealsItemResponse?.title,
                expirationDate = hotDealsItemResponse?.expirationDate
            )
        }

        val banners = type.banners?.map { bannersItemResponse ->
            val image = Image(
                bannersItemResponse?.image?.width,
                bannersItemResponse?.image?.url,
                bannersItemResponse?.image?.height)
            Banners(image = image)
        }

        return Campaigns(hotDeals, banners)
    }

}