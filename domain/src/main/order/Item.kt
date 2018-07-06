package kotlinddd.domain.order

import kotlinddd.domain.BusinessException

class Item {
    val product: Product
    private var quantity: Int

    constructor(product: Product, quantity: Int) {
        validateQuantity(quantity)
        this.product = product
        this.quantity = quantity
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