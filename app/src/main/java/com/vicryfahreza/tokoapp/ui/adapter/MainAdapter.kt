package com.vicryfahreza.tokoapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.vicryfahreza.tokoapp.R
import com.vicryfahreza.tokoapp.databinding.EachItemBinding
import com.vicryfahreza.tokoapp.databinding.SectionBinding
import com.vicryfahreza.tokoapp.model.Account
import com.vicryfahreza.tokoapp.model.Banner
import com.vicryfahreza.tokoapp.model.BestSeller
import com.vicryfahreza.tokoapp.model.DataItem
import com.vicryfahreza.tokoapp.model.DataItemType
import com.vicryfahreza.tokoapp.model.Menu
import com.vicryfahreza.tokoapp.model.Section

class MainAdapter(private val dataItemList: List<DataItem>)
    : RecyclerView.Adapter<RecyclerView.ViewHolder>(){


    inner class SectionItemViewHolder(private val binding: SectionBinding) : RecyclerView.ViewHolder(binding.root){

        fun bindSectionView(section: Section){
            binding.tvSection.text = section.text
        }

    }

    inner class RecyclerItemViewHolder(private val binding: EachItemBinding) : RecyclerView.ViewHolder(binding.root){

        init {
            binding.childRecyclerView.setHasFixedSize(true)
            binding.childRecyclerView.layoutManager = LinearLayoutManager(binding.root.context, RecyclerView.HORIZONTAL, false)
        }


        fun bindAccountRecyclerView(accountItemList: List<Account>) {
            val adapter = AccountAdapter(DataItemType.ACCOUNT, accountItemList)
            binding.childRecyclerView.adapter = adapter
        }

        fun bindBannerRecyclerView(bannerItemList: List<Banner>) {
            val adapter = BannerAdapter(DataItemType.BANNER, bannerItemList)
            binding.childRecyclerView.adapter = adapter
        }

        fun bindMenuRecyclerView(menuItemList: List<Menu>) {
            val adapter = MenuAdapter(DataItemType.MENU, menuItemList)
            binding.childRecyclerView.adapter = adapter
        }

        fun bindBestSellerRecyclerView(bestSellerItemList: List<BestSeller>) {
            val adapter = BestSellerAdapter(DataItemType.BEST_SELLER, bestSellerItemList)
            binding.childRecyclerView.adapter = adapter
        }

    }

    override fun getItemViewType(position: Int): Int {
        return when(dataItemList[position].viewType) {
            DataItemType.SECTION ->
                R.layout.section
            else ->
                R.layout.each_item
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType) {
            R.layout.section -> {
                val binding = SectionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                SectionItemViewHolder(binding)
            }

            else -> {
                val binding = EachItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                RecyclerItemViewHolder(binding)
            }

        }
    }

    override fun getItemCount(): Int = dataItemList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {
            is SectionItemViewHolder -> {
                dataItemList[position].section?.let { holder.bindSectionView(it) }
            }
            else -> {
                when (dataItemList[position].viewType) {
                    DataItemType.ACCOUNT -> {
                        dataItemList[position].accountList?.let {
                            (holder as RecyclerItemViewHolder).bindAccountRecyclerView(it)
                        }
                    }
                    DataItemType.BANNER -> {
                        dataItemList[position].bannerList?.let {
                            (holder as RecyclerItemViewHolder).bindBannerRecyclerView(it)
                        }
                    }
                    DataItemType.MENU -> {
                        dataItemList[position].menuList?.let {
                            (holder as RecyclerItemViewHolder).bindMenuRecyclerView(it)
                        }
                    }
                    DataItemType.BEST_SELLER -> {
                        dataItemList[position].bestSellerList?.let {
                            (holder as RecyclerItemViewHolder).bindBestSellerRecyclerView(it)
                        }
                    }
                }
            }
        }
    }
}