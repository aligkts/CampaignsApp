package com.aligkts.campaignsapp.data

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Ali Göktaş on 01,February,2020
 */

@Singleton
class RequestInterceptor @Inject constructor() : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()

        val httpUrl = request.url.newBuilder().build()

        request = request.newBuilder().url(httpUrl).build()

        return chain.proceed(request)
    }
}