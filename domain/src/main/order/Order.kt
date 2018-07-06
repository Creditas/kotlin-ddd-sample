package kotlinddd.domain.order

import kotlinddd.domain.BusinessException
import order.Customer
import java.util.UUID

class Order(val id: UUID, val customer: Customer) {
    private val items = mutableListOf<Item>()

    fun addProduct(product: Product, quantity: Int) {
        if (items.any { it.product == product })
            throw BusinessException("Product already exists!")

        var item = Item(product, quantity)
        items.add(item)
    }

    fun changeProductQuantity(product: Product, quantity: Int) {
        validadeIfProductIsOnList(product)

        var item = items.first { it.product == product }
        item.changeQuantity(quantity)
    }

    fun removeProduct(product: Product) {
        validadeIfProductIsOnList(product)

        items.removeAll { it.product == product }
    }

    private fun validadeIfProductIsOnList(product: Product) {
        var isOnList = items.any { it.product == product }
        if (!isOnList)
            throw BusinessException("The product isn't included in this order")
    }
}
