package com.aligkts.campaignsapp.common

/**
 * Created by Ali Göktaş on 01,February,2020
 */
interface Mapper<R, D> {

    fun mapFrom(type: R): D

}