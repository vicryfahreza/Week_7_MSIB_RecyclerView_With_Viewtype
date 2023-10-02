package com.vicryfahreza.tokoapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vicryfahreza.tokoapp.databinding.BannerItemBinding
import com.vicryfahreza.tokoapp.model.Banner
import com.vicryfahreza.tokoapp.model.DataItemType

class BannerAdapter(private val viewType: Int ,private val recyclerItemList: List<Banner>)
    : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    inner class BannerViewHolder(private val binding : BannerItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bindBannerView(banner: Banner) {
            binding.ivBanner.setImageResource(banner.image)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return viewType
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when(viewType) {
            DataItemType.BANNER -> {
                val binding = BannerItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                return BannerViewHolder(binding)
            }
            else -> {
                val binding = BannerItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                return BannerViewHolder(binding)
            }
        }
    }

    override fun getItemCount(): Int = recyclerItemList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {

            is BannerAdapter.BannerViewHolder -> {
                holder.bindBannerView(recyclerItemList[position])
            }
        }

    }

}