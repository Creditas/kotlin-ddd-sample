package kotlinddd.domain.order

import kotlinddd.domain.BusinessException

class Item(val product: Product, private var quantity: Int) {
    init {
        validateQuantity(quantity)
    }

    fun changeQuantity(quantity: Int) {
        validateQuantity(quantity)
        this.quantity = quantity
    }

    fun validateQuantity(quantity: Int) {
        if (quantity <= 0)
            throw BusinessException("Quantity must be greater than zero")
    }
}