package com.vicryfahreza.tokoapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vicryfahreza.tokoapp.databinding.AccountItemBinding
import com.vicryfahreza.tokoapp.model.Account
import com.vicryfahreza.tokoapp.model.DataItemType

class AccountAdapter(private val viewType: Int ,private val recyclerItemList: List<Account>)
    : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    inner class AccountViewHolder(private val binding : AccountItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bindAccountView(account: Account) {
            binding.ivAccount.setImageResource(account.image)
            binding.tvAccount.text = account.account
            binding.tvTextAccount.text = account.text
        }
    }

    override fun getItemViewType(position: Int): Int {
        return viewType
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when(viewType) {
            DataItemType.ACCOUNT -> {
                val binding = AccountItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                return AccountViewHolder(binding)
            }
            else -> {
                val binding = AccountItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                return AccountViewHolder(binding)
            }
        }
    }

    override fun getItemCount(): Int = recyclerItemList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        when(holder) {

            is AccountViewHolder -> {
                holder.bindAccountView(recyclerItemList[position])
            }
        }

    }
}