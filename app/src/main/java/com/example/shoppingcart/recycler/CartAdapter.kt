package com.example.shoppingcart.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppingcart.databinding.ShoppingCartCardBinding
import com.example.shoppingcart.model.Order
import com.example.shoppingcart.model.OrderViewHolder

class CartAdapter(
    private val orders: List<Order>,
    private val onDeleteClick: (Order) -> Unit = { },
) : RecyclerView.Adapter<OrderViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): OrderViewHolder {
        val binding = ShoppingCartCardBinding.inflate(
            LayoutInflater.from(viewGroup.context),
            viewGroup,
            false
        )
        return OrderViewHolder(binding)
    }

    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {
        val order = orders[position]
        holder.bind(
            order = order,
            onDeleteClick = {
                onDeleteClick(order)
                notifyDataSetChanged()
            },
        )
    }

    override fun getItemCount(): Int = orders.size
}