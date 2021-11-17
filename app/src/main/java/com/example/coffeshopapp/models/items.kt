package com.example.coffeshopapp.models

import com.example.coffeshopapp.R

data class ItemModel(
    val title : String,
    val price : Int,
    val weight : Int,
    val itemStatus : Boolean,
    val descr : String,
    val image : Int,
    val itemid : Int
)

val itemList = listOf<ItemModel>(
    ItemModel("Test Coffee 1", 1500, 1000, true, "test Coffee", R.drawable.item_1, 1001),
    ItemModel("Test Coffee 2", 2500, 900, true, "test Coffee", R.drawable.item_1, 1002),
    ItemModel("Test Coffee 3", 3500, 1500, true, "test Coffee", R.drawable.item_1, 1003),
    ItemModel("Test Coffee 4", 2000, 1000, false, "test Coffee", R.drawable.item_1, 1004),
    ItemModel("Test Coffee 5", 2750, 600, false, "test Coffee", R.drawable.item_1, 1005),
    ItemModel("Test Coffee 6", 1250, 900, true, "test Coffee", R.drawable.item_1, 1006),
    ItemModel("Test Coffee 7", 1000, 1000, true, "test Coffee", R.drawable.item_1, 1007),
    ItemModel("Test Coffee 8", 2250, 1000, false, "test Coffee", R.drawable.item_1, 1008),
    ItemModel("Test Coffee 9", 1750, 600, false, "test Coffee", R.drawable.item_1, 1009)
)

/*
val item1 = ItemModel("Coffe 1", 1500, 1000, true, "test Coffee", "@drawable/item_1")
val item2 = ItemModel("Coffe 2", 2500, 900, true, "test Coffee", "@drawable/item_1")
val item3 = ItemModel("Coffe 3", 3500, 1500, true, "test Coffee", "@drawable/item_1")
val item4 = ItemModel("Coffe 4", 2000, 1000, false, "test Coffee", "@drawable/item_1")
val item5 = ItemModel("Coffe 5", 2750, 600, false, "test Coffee", "@drawable/item_1")
val item6 = ItemModel("Coffe 6", 1250, 900, true, "test Coffee", "@drawable/item_1")
val item7 = ItemModel("Coffe 7", 1000, 1000, true, "test Coffee", "@drawable/item_1")
val item8 = ItemModel("Coffe 8", 2250, 1000, false, "test Coffee", "@drawable/item_1")
val item9 = ItemModel("Coffe 9", 1750, 600, false, "test Coffee", "@drawable/item_1")
*/