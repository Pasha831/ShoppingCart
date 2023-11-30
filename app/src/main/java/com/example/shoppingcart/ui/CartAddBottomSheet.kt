package com.example.shoppingcart.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.shoppingcart.databinding.CartAddBottomSheetBinding
import com.example.shoppingcart.model.Order
import com.example.shoppingcart.model.OrderFactory
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class CartAddBottomSheet(
    private val onSuccess: (Order) -> Unit,
) : BottomSheetDialogFragment() {

    companion object {
        const val TAG = "ModalBottomSheet"
    }

    private lateinit var binding: CartAddBottomSheetBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = CartAddBottomSheetBinding.inflate(inflater, container, false)

        binding.addButton.setOnClickListener {
            val itemName = binding.editText.text.toString()
            val quantity = binding.slider.value.toInt()

            if (itemName.isEmpty()) {
                binding.editText.error = "The item name cannot be empty!"
            } else {
                onSuccess(Order(id = OrderFactory.id++, product = itemName, quantity = quantity))
                dismiss()
            }
        }

        return binding.root
    }
}