package org.dddsample.domain.order

import org.axonframework.commandhandling.CommandHandler
import org.axonframework.commandhandling.model.AggregateIdentifier
import org.axonframework.commandhandling.model.AggregateRoot
import org.axonframework.eventhandling.EventHandler
import org.axonframework.eventsourcing.EventSourcingHandler
import org.dddsample.application.order.commands.AddProductCommand
import org.dddsample.application.order.commands.CreateOrderCommand
import org.dddsample.domain.order.events.OrderCreatedEvent
import org.dddsample.domain.order.events.ProductAddedEvent
import org.axonframework.spring.stereotype.Aggregate

@Aggregate
class Order {
    @AggregateIdentifier
    var id: Int = 0
    lateinit var user: User
    val products = mutableListOf<Product>()

    @CommandHandler
    fun createOrder(command: CreateOrderCommand) {
        apply(OrderCreatedEvent(orderId = 1, command.user))
    }

    @CommandHandler
    fun addProduct(command: AddProductCommand) {
        apply(ProductAddedEvent(orderId = command.orderId, product = command.product))
    }

    @EventSourcingHandler
    fun on(event: OrderCreatedEvent) {
        this.id = event.orderId

        println("criou")
    }

    @EventSourcingHandler
    fun on(event: ProductAddedEvent) {
        this.products.add(event.product)

        println("adicionou")
    }
}