package com.example.shoppingcart.model

import androidx.recyclerview.widget.RecyclerView
import com.example.shoppingcart.R
import com.example.shoppingcart.databinding.ShoppingCartCardBinding

data class Order(
    val id: Int,
    val product: String,
    val quantity: Int,
)

class OrderViewHolder(
    private val binding: ShoppingCartCardBinding,
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(
        order: Order,
        onDeleteClick: () -> Unit = { },
    ) = with(binding) {
        val context = quantity.context

        title.text = order.product.lowercase().replaceFirstChar { it.uppercase() }
        quantity.text = context.getString(R.string.quantity_in_card, order.quantity.toString())

        delete.setOnClickListener { onDeleteClick() }
    }
}