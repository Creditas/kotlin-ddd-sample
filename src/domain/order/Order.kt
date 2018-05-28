package org.dddsample.domain.order

import org.axonframework.commandhandling.model.AggregateLifecycle.apply
import org.dddsample.application.order.commands.AddProductCommand
import org.dddsample.application.order.commands.CreateOrderCommand
import org.dddsample.domain.order.events.OrderCreatedEvent
import org.dddsample.domain.order.events.ProductAddedEvent

import org.axonframework.commandhandling.CommandHandler
import org.axonframework.commandhandling.model.AggregateIdentifier
import org.axonframework.eventsourcing.EventSourcingHandler
import org.axonframework.spring.stereotype.Aggregate

@Aggregate
class Order {
    @AggregateIdentifier
    var id: Int = 0

    lateinit var user: User
    val products = mutableListOf<Product>()

    constructor() {} //TODO: remove or replace for lombok @NoArgsConstructor

    @CommandHandler
    constructor(command: CreateOrderCommand) {
        println("chegou")
        apply(OrderCreatedEvent(orderId = 1, user = command.user))
    }

    @EventSourcingHandler
    fun on(event: OrderCreatedEvent) {
        this.id = event.orderId

        println("criou")
    }

    @CommandHandler
    fun addProduct(command: AddProductCommand) {
        apply(ProductAddedEvent(orderId = command.orderId, product = command.product))
    }

    @EventSourcingHandler
    fun on(event: ProductAddedEvent) {
        this.products.add(event.product)

        println("adicionou")
    }
}