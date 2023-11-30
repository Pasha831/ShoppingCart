package com.example.shoppingcart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.shoppingcart.databinding.ActivityMainBinding
import com.example.shoppingcart.state.CartState
import com.example.shoppingcart.recycler.CartAdapter
import com.example.shoppingcart.ui.CartAddBottomSheet

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val state = CartState()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViews()
    }

    private fun initViews() {
        binding = ActivityMainBinding.inflate(layoutInflater)

        val adapter = CartAdapter(
            orders = state.orders,
            onDeleteClick = { order ->
                state.orders.remove(order)
            },
        )
        val recyclerView = binding.recyclerView
        recyclerView.adapter = adapter

        binding.fab.setOnClickListener {
            val bottomSheet = CartAddBottomSheet(
                onSuccess = { order ->
                    state.orders.add(order)
                    adapter.notifyDataSetChanged()
                }
            )
            bottomSheet.show(supportFragmentManager, CartAddBottomSheet.TAG)
        }

        setSupportActionBar(binding.toolbar)
        setContentView(binding.root)
    }
}