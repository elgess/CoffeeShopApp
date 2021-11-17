package com.example.coffeshopapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.coffeshopapp.R
import com.example.coffeshopapp.models.CartModel

class CartAdapter (val context: Context?, var _cart : CartModel, val sum : TextView) : RecyclerView.Adapter<CartHolder>(){
    override fun onBindViewHolder(holder : CartHolder, current : Int){
        val obj = _cart.cartList[current]
        holder.title.text = obj.title
        holder.price.text = ( obj.price.toString() + " " + context!!.getString(R.string.item_rub) )
        holder.image.setImageResource(obj.image)

        sum.text = (_cart.cartList.sumOf { it.price }.toString() + " " + context.getString(R.string.item_rub))

        holder.button.setOnClickListener {
            _cart.removeFromCart(current)
            notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartHolder {
        val cartView = LayoutInflater.from(parent.context).inflate(R.layout.cart_item_view, parent, false)
        return CartHolder(cartView)
    }

    override fun getItemCount(): Int {
        return _cart.cartList.size
    }

}

class CartHolder(cartView: View) : RecyclerView.ViewHolder(cartView) {
    val title: TextView = cartView.findViewById(R.id.cit_title)
    val price: TextView = cartView.findViewById(R.id.cit_price)
    val image: ImageView = cartView.findViewById(R.id.cit_image)
    val button: Button = cartView.findViewById(R.id.cit_removefromcart)
}