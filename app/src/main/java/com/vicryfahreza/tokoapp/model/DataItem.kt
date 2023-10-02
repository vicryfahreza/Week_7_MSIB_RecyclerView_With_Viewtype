package com.vicryfahreza.tokoapp.model

data class DataItem(val viewType: Int){

    var accountList : List<Account>? = null
    var bannerList : List<Banner>? = null
    var menuList: List<Menu>? = null
    var section: Section? = null
    var bestSellerList: List<BestSeller>? = null

    // account viewType
    constructor(viewType: Int, accountList : List<Account>, bannerList : List<Banner>, menuList : List<Menu>, bestSeller: List<BestSeller>) : this(viewType){
        this.accountList = accountList
        this.bannerList = bannerList
        this.menuList = menuList
        this.bestSellerList = bestSeller
    }

    constructor(viewType: Int, section: Section) : this(viewType) {
        this.section = section
    }
}
