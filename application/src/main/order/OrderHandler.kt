package kotlinddd.application.order

import kotlinddd.application.order.commands.CreateOrderCommand
import org.axonframework.commandhandling.CommandHandler

class OrderHandler {
    @CommandHandler
    fun createOrder(command: CreateOrderCommand) {
        println("Create order handled!")
        //val order = Order(command.user)
        //...
    }
}
