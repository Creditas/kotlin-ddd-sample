package org.dddsample.domain.order

import org.axonframework.commandhandling.model.AggregateIdentifier
import org.axonframework.eventhandling.EventHandler
import org.dddsample.domain.order.events.OrderCreatedEvent

class Order {
    @AggregateIdentifier
    var id: Int? = null
    var user: User? = null
    val products = mutableListOf<Product>()

    constructor(user: User) {
        this.user = user

       //fire event
    }

    @EventHandler
    fun on(event: OrderCreatedEvent) {
        this.id = event.orderId
    }
}