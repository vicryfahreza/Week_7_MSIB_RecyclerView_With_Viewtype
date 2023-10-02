package com.vicryfahreza.tokoapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.vicryfahreza.tokoapp.R
import com.vicryfahreza.tokoapp.databinding.ActivityMainBinding
import com.vicryfahreza.tokoapp.model.Account
import com.vicryfahreza.tokoapp.model.Banner
import com.vicryfahreza.tokoapp.model.BestSeller
import com.vicryfahreza.tokoapp.model.DataItem
import com.vicryfahreza.tokoapp.model.DataItemType
import com.vicryfahreza.tokoapp.model.Menu
import com.vicryfahreza.tokoapp.model.Section
import com.vicryfahreza.tokoapp.ui.adapter.MainAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var mList: ArrayList<DataItem>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.rvMain.setHasFixedSize(true)
        binding.rvMain.layoutManager = LinearLayoutManager(this)

        mList = ArrayList()
        fillRecyclerView()

        val adapter = MainAdapter(mList)
        binding.rvMain.adapter = adapter
    }

    private fun fillRecyclerView() {
        val accountList = ArrayList<Account>()
        accountList.add(Account(R.drawable.wallet, "Rp 100.000,00", "0 Coins"))
        accountList.add(Account(R.drawable.langganan, "Coba 1 Bulan", "Langganan Yuk!"))
        accountList.add(Account(R.drawable.tier_pelanggan, "Gold", "15 Kupon"))

        val bannerList = ArrayList<Banner>()
        bannerList.add(Banner(R.drawable.banner1))
        bannerList.add(Banner(R.drawable.banner2))
        bannerList.add(Banner(R.drawable.banner3))

        val menuList = ArrayList<Menu>()
        menuList.add(Menu(R.drawable.menu1, "Lihat Semua"))
        menuList.add(Menu(R.drawable.menu2, "Diskon 50%"))
        menuList.add(Menu(R.drawable.menu3, "Top-up & Tagihan"))
        menuList.add(Menu(R.drawable.menu4, "Travel dan Entertainment"))
        menuList.add(Menu(R.drawable.menu5, "Promo Hari ini"))
        menuList.add(Menu(R.drawable.menu6, "Go Food"))

        val bestSellerList = ArrayList<BestSeller>()
        bestSellerList.add(BestSeller(R.drawable.bestseller1, "Topi"))
        bestSellerList.add(BestSeller(R.drawable.bestseller2, "Lainnya"))
        bestSellerList.add(BestSeller(R.drawable.bestseller3, "Monitor Gaming"))
        bestSellerList.add(BestSeller(R.drawable.bestseller4, "Sepatu Sport"))
        bestSellerList.add(BestSeller(R.drawable.bestseller5, "Kaos Pria"))
        bestSellerList.add(BestSeller(R.drawable.bestseller6, "Action Figure"))

        mList.add(DataItem(DataItemType.ACCOUNT, accountList, bannerList, menuList, bestSellerList))
        mList.add(DataItem(DataItemType.BANNER, accountList, bannerList, menuList, bestSellerList))
        mList.add(DataItem(DataItemType.MENU, accountList, bannerList, menuList, bestSellerList))
        mList.add(DataItem(DataItemType.SECTION, Section("Lanjut Cek ini, yuk")))
        mList.add(DataItem(DataItemType.BEST_SELLER, accountList, bannerList, menuList, bestSellerList))


    }

}