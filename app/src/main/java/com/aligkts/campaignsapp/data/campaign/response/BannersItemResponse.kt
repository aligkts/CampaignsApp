package com.aligkts.campaignsapp.data.campaign.response

import com.google.gson.annotations.SerializedName

data class BannersItemResponse(

	@field:SerializedName("image")
	val image: ImageResponse? = null
)