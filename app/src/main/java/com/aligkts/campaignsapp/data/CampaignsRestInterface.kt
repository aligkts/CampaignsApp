package com.aligkts.campaignsapp.data

import com.aligkts.campaignsapp.data.campaign.response.CampaignResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by Ali Göktaş on 01,February,2020
 */

interface CampaignsRestInterface {

    @GET("campaigns/{page}")
    fun fetchCampaigns(@Path("page") page: Int): Observable<CampaignResponse>

}