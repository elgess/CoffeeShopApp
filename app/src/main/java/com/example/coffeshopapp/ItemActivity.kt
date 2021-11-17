package com.example.coffeshopapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.coffeshopapp.models.CartModel
import com.example.coffeshopapp.models.ItemModel
import kotlinx.android.synthetic.main.activity_item.*
import org.w3c.dom.Text

class ItemActivity : AppCompatActivity() {
    lateinit var _cart : CartModel

    fun initCart(cartModel: CartModel) {
        _cart = cartModel
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item)

        val titleView : TextView = findViewById(R.id.ai_title)
        val imageView : ImageView = findViewById(R.id.ai_image)
        val statusView : TextView = findViewById(R.id.ai_status)
        val descriptionView : TextView = findViewById(R.id.ai_description)
        val priceView : TextView = findViewById(R.id.ai_price)
        val weightView : TextView = findViewById(R.id.ai_weight)

        val title = intent.getSerializableExtra("title") as String?
        val image = intent.getSerializableExtra("image") as Int
        val descr = intent.getSerializableExtra("description") as String?
        val weight = intent.getSerializableExtra("weight") as Int?
        val price = intent.getSerializableExtra("price") as Int?
        val status = intent.getSerializableExtra("status") as Boolean

        titleView.text = title
        imageView.setImageResource(image)
        descriptionView.text = descr
        if (status) {
            statusView.text = getString(R.string.item_available)
            statusView.setTextColor(getColor(R.color.green))
        } else {
            statusView.text = getString(R.string.item_in_stock)
            statusView.setTextColor(getColor(R.color.red))
        }
        weightView.text = (weight.toString() + getString(R.string.item_weight))
        priceView.text = (price.toString() + " " + getString(R.string.item_rub))

    }
}