package com.example.coffeshopapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.coffeshopapp.ItemAdapter
import com.example.coffeshopapp.R
import com.example.coffeshopapp.models.CartModel
import com.example.coffeshopapp.models.itemList
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment() : Fragment() {
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
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter:ItemAdapter?

        rv_recyclerView.layoutManager = LinearLayoutManager(context)

        adapter = ItemAdapter(context, itemList, _cart)
        rv_recyclerView.adapter = adapter
    }

    companion object {
        @JvmStatic
        fun newInstance() : HomeFragment {
            return HomeFragment()
        }
    }
}