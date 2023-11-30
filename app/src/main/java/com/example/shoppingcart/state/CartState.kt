package com.example.shoppingcart.state

import com.example.shoppingcart.model.Order
import com.example.shoppingcart.model.OrderFactory

data class CartState(
    val orders: MutableList<Order> = OrderFactory.createInitialOrders(
        initialQuantity = (5..10).random(),
    ),
    val selectedOrder: Order? = null,
)
