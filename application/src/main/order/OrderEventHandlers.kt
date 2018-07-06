package kotlinddd.application.order

import kotlinddd.application.order.commands.CreateOrderCommand
import kotlinddd.domain.order.OrderRepository
import org.axonframework.eventhandling.EventHandler

open class OrderEventHandlers(val repository: OrderRepository) {
    @EventHandler
    fun shipProduct(event: CreateOrderCommand) {

    }
}

