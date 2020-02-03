package com.aligkts.campaignsapp.data.campaign.response

import com.google.gson.annotations.SerializedName

data class ImageResponse(

	@field:SerializedName("width")
	val width: Int? = null,

	@field:SerializedName("url")
	val url: String? = null,

	@field:SerializedName("height")
	val height: Int? = null
)