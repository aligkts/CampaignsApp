package com.aligkts.campaignsapp.data.campaign.response

import com.google.gson.annotations.SerializedName

data class CampaignResponse(

	@field:SerializedName("hotDeals")
	val hotDeals: List<HotDealsItemResponse?>? = null,

	@field:SerializedName("banners")
	val banners: List<BannersItemResponse?>? = null
)