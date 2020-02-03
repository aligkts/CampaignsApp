package com.aligkts.campaignsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.aligkts.campaignsapp.common.ui.EndlessScrollListener
import com.aligkts.campaignsapp.common.ui.observeNonNull
import com.aligkts.campaignsapp.common.ui.runIfNull
import com.aligkts.campaignsapp.databinding.ActivityMainBinding
import com.aligkts.campaignsapp.ui.campaigns.adapter.CampaignsAdapter
import com.aligkts.campaignsapp.ui.campaigns.viewmodel.CampaignsViewModel
import com.aligkts.campaignsapp.ui.campaigns.viewstate.CampaignsViewState
import dagger.android.AndroidInjection
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    internal lateinit var viewModelProviderFactory: ViewModelProvider.Factory

    @Inject
    internal lateinit var campaignsAdapter: CampaignsAdapter

    private lateinit var campaignsViewModel: CampaignsViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        campaignsViewModel =
            ViewModelProvider(this, viewModelProviderFactory).get(CampaignsViewModel::class.java)
        campaignsViewModel.getCampaignsLiveData().observeNonNull(this) {
            renderCampaigns(it)
        }

        savedInstanceState.runIfNull {
            fetchCampaigns(FIRST_PAGE)
        }
        initCampaignsRecyclerView()
    }

    private fun initCampaignsRecyclerView() {
        val linearLayoutManager = LinearLayoutManager(this)
        binding.campaignsRecyclerView.apply {
            adapter = campaignsAdapter
            layoutManager = linearLayoutManager
            addOnScrollListener(object : EndlessScrollListener(linearLayoutManager) {
                override fun onLoadMore(page: Int) {
                    fetchCampaigns(page)
                }

            })
        }
    }

    private fun renderCampaigns(campaignsViewState: CampaignsViewState) {
        with(binding) {
            mainViewState = campaignsViewState
            executePendingBindings()
        }
        campaignsAdapter.setCampaigns(campaignsViewState.getHotDeals(), campaignsViewState.getBanners())
    }

    private fun fetchCampaigns(page: Int) {
        campaignsViewModel.fetchCampaigns(page)
    }

    companion object {
        const val FIRST_PAGE = 1
    }
}
