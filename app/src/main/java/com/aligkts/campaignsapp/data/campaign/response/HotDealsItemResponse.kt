package com.aligkts.campaignsapp.data.campaign.response

import com.google.gson.annotations.SerializedName

data class HotDealsItemResponse(

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("expirationDate")
	val expirationDate: String? = null
)