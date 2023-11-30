package com.example.shoppingcart.model

object OrderFactory {
    var id = 0

    fun createInitialOrders(initialQuantity: Int = 4): MutableList<Order> {
        val orders = mutableListOf<Order>()

        repeat(initialQuantity) {
            orders.add(
                Order(
                    id = id++,
                    product = SampleProduct.values().random().toString(),
                    quantity = (1..100).random(),
                )
            )
        }

        return orders
    }
}