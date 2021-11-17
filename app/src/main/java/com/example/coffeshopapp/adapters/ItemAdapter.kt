package com.example.coffeshopapp

import android.content.Context
import android.content.Intent
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.coffeshopapp.fragments.HomeFragment
import com.example.coffeshopapp.models.CartModel
import com.example.coffeshopapp.models.ItemModel
import java.io.Serializable

class ItemAdapter (val context: Context?, val arr: List<ItemModel>, var _cart : CartModel): RecyclerView.Adapter<ItemHolder>(){
    override fun onBindViewHolder(holder : ItemHolder, current : Int){
        val obj = arr[current]
        holder.title.text = obj.title
        holder.price.text = ( obj.price.toString() + " " + context!!.getString(R.string.item_rub) )
        if (obj.itemStatus) {
            holder.status.text = context.getString(R.string.item_available)
            holder.status.setTextColor(context.getColor(R.color.green))
        } else {
            holder.status.text = context.getString(R.string.item_in_stock)
            holder.status.setTextColor(context.getColor(R.color.red))
        }
        holder.image.setImageResource(obj.image)
        holder.button.isEnabled = obj.itemStatus

        holder.wrapper.setOnClickListener {
            val itemIntent = Intent(context, ItemActivity::class.java)
            itemIntent.putExtra("title", obj.title)
            itemIntent.putExtra("price", obj.price)
            itemIntent.putExtra("status", obj.itemStatus)
            itemIntent.putExtra("weight", obj.weight)
            itemIntent.putExtra("description", obj.descr)
            itemIntent.putExtra("image", obj.image)
            context.startActivity(itemIntent)
        }
        holder.button.setOnClickListener {
            _cart.addToCart(obj)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.sample_item_view, parent, false)
        return ItemHolder(itemView)
    }

    override fun getItemCount(): Int {
        return arr.size
    }

}

class ItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val title: TextView = itemView.findViewById(R.id.it_title)
    val price: TextView = itemView.findViewById(R.id.it_price)
    val status: TextView = itemView.findViewById(R.id.it_status)
    val wrapper: LinearLayout = itemView.findViewById(R.id.rl_1_wrapper)
    val image: ImageView = itemView.findViewById(R.id.it_image)
    val button: Button = itemView.findViewById(R.id.it_addtocart)
}