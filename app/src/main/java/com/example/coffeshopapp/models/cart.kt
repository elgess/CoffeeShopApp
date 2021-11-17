package com.example.coffeshopapp.models

open class CartModel {
    var cartList = mutableListOf<ItemModel>()

    fun addToCart(item : ItemModel) {
        cartList.add(item)
    }

    fun removeFromCart(index : Int) {
        cartList.removeAt(index)
    }

    fun getSum() : Int {
        return cartList.sumOf { it.price }
    }
}

