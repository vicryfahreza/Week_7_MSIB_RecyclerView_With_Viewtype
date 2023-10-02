package com.vicryfahreza.tokoapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vicryfahreza.tokoapp.databinding.BestSellerItemBinding
import com.vicryfahreza.tokoapp.model.BestSeller
import com.vicryfahreza.tokoapp.model.DataItemType

class BestSellerAdapter (private val viewType: Int ,private val recyclerItemList: List<BestSeller>)
    : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    inner class BestSellerViewHolder(private val binding : BestSellerItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bindBestSellerView(bestSeller: BestSeller) {
            binding.ivBestSeller.setImageResource(bestSeller.image)
            binding.tvTextBestSeller.text = bestSeller.text
        }
    }

    override fun getItemViewType(position: Int): Int {
        return viewType
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when(viewType) {
            DataItemType.BEST_SELLER -> {
                val binding = BestSellerItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                return BestSellerViewHolder(binding)
            }
            else -> {
                val binding = BestSellerItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                return BestSellerViewHolder(binding)
            }
        }
    }

    override fun getItemCount(): Int = recyclerItemList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        when(holder) {

            is BestSellerAdapter.BestSellerViewHolder -> {
                holder.bindBestSellerView(recyclerItemList[position])
            }
        }

    }

}