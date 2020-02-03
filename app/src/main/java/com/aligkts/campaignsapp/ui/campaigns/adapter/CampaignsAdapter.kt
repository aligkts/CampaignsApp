package com.aligkts.campaignsapp.ui.campaigns.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aligkts.campaignsapp.R
import com.aligkts.campaignsapp.common.ui.inflate
import com.aligkts.campaignsapp.databinding.ItemCampaignBinding
import com.aligkts.campaignsapp.ui.campaigns.model.Banners
import com.aligkts.campaignsapp.ui.campaigns.model.HotDeals
import com.aligkts.campaignsapp.ui.campaigns.viewstate.CampaignsItemViewState
import javax.inject.Inject

/**
 * Created by Ali Göktaş on 02,February,2020
 */
class CampaignsAdapter @Inject constructor() : RecyclerView.Adapter<CampaignsAdapter.CampaignsItemViewHolder>() {

    private var hotDeals: MutableList<HotDeals> = mutableListOf()
    private var banners: MutableList<Banners> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CampaignsItemViewHolder {
        val itemBinding = parent.inflate<ItemCampaignBinding>(R.layout.item_campaign, false)
        return CampaignsItemViewHolder(itemBinding)
    }

    override fun getItemCount(): Int = hotDeals.size

    override fun onBindViewHolder(holder: CampaignsItemViewHolder, position: Int) {
        holder.bind(getHotDeals(position), getBanners(position))
    }

    fun getHotDeals(position: Int) = hotDeals[position]

    fun getBanners(position: Int) = banners[position]

    fun setCampaigns(hotDealsList: List<HotDeals>, bannersList: List<Banners>) {
        val beforeSize = hotDeals.size
        hotDeals.addAll(hotDealsList)
        banners.addAll(bannersList)
        notifyItemRangeInserted(beforeSize, hotDealsList.size)
    }

    inner class CampaignsItemViewHolder(private val binding: ItemCampaignBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(hotDeals: HotDeals,
                 banners: Banners) {
            with(binding) {
                campaignItemViewState = CampaignsItemViewState(hotDeals, banners)
                executePendingBindings()
            }

        }
    }

}