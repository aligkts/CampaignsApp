package com.aligkts.campaignsapp.common.di.module

import com.aligkts.campaignsapp.data.NetworkModule
import dagger.Module

/**
 * Created by Ali Göktaş on 01,February,2020
 */

@Module(
    includes = [NetworkModule::class]
)
class DataModule