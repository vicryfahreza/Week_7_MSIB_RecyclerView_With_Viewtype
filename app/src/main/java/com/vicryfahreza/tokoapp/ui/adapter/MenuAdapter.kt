package com.vicryfahreza.tokoapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vicryfahreza.tokoapp.databinding.MenuItemBinding
import com.vicryfahreza.tokoapp.model.DataItemType
import com.vicryfahreza.tokoapp.model.Menu

class MenuAdapter (private val viewType: Int ,private val recyclerItemList: List<Menu>)
    : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    inner class MenuViewHolder(private val binding : MenuItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bindMenuView(menu: Menu) {
            binding.ivMenu.setImageResource(menu.image)
            binding.tvTextMenu.text = menu.name
        }
    }

    override fun getItemViewType(position: Int): Int {
        return viewType
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when(viewType) {
            DataItemType.MENU -> {
                val binding = MenuItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                return MenuViewHolder(binding)
            }
            else -> {
                val binding = MenuItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                return MenuViewHolder(binding)
            }
        }    }

    override fun getItemCount(): Int = recyclerItemList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        when(holder) {

            is MenuAdapter.MenuViewHolder -> {
                holder.bindMenuView(recyclerItemList[position])
            }
        }

    }

}