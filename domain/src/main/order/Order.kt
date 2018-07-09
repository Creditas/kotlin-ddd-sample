package kotlinddd.domain.order

import kotlinddd.domain.BusinessException
import order.Customer
import org.axonframework.eventhandling.EventBus
import org.axonframework.eventhandling.GenericEventMessage
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
        validateIfProductIsOnList(product)

        var item = items.first { it.product == product }
        item.changeQuantity(quantity)
    }

    fun removeProduct(product: Product) {
        validateIfProductIsOnList(product)

        items.removeAll { it.product == product }
    }

    fun pay(paymentService: PaymentService, eventBus: EventBus) {
        val debitedWithSuccess = paymentService.debitValueByCreditCart("1234");
        if (debitedWithSuccess)
            eventBus.publish(GenericEventMessage.asEventMessage<OrderPaid>(OrderPaid(this.id))) //TODO improve this by putting some helpers in a aggregate base class and may creating an DomainEvent base class
    }

    private fun validateIfProductIsOnList(product: Product) {
        var isOnList = items.any { it.product == product }
        if (!isOnList)
            throw BusinessException("The product isn't included in this order")
    }
}
