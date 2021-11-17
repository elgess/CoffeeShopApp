package com.example.coffeshopapp.fragments

import android.graphics.Typeface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.coffeshopapp.ItemAdapter
import com.example.coffeshopapp.R
import com.example.coffeshopapp.adapters.CartAdapter
import com.example.coffeshopapp.models.CartModel
import com.example.coffeshopapp.models.itemList
import kotlinx.android.synthetic.main.fragment_cart.*
import kotlinx.android.synthetic.main.fragment_home.*

class CartFragment : Fragment() {
    lateinit var _cart : CartModel

    fun initCart(cart: CartModel) {
        _cart = cart
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_cart, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter: CartAdapter?
        cart_recyclerView.layoutManager = LinearLayoutManager(context)
        adapter = CartAdapter(context, _cart, sum_price)
        cart_recyclerView.adapter = adapter
    }

    companion object {
        @JvmStatic
        fun newInstance() : CartFragment {
            return CartFragment()
        }
    }
}


