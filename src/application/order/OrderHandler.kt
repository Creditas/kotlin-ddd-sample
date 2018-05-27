package org.dddsample.application.order

import org.axonframework.commandhandling.CommandHandler
import org.dddsample.application.order.commands.AddProductCommand
import org.dddsample.application.order.commands.CreateOrderCommand
import org.dddsample.domain.order.Order
import org.dddsample.domain.order.User

class OrderHandler {
    @CommandHandler
    fun CreateOrder(command: CreateOrderCommand) {
        //val order = Order(command.user)

        //...
    }

    @CommandHandler
    fun AddProduct(command: AddProductCommand) {
        //val order = Order(User("foo")) //find from database ...

        //...
    }
}