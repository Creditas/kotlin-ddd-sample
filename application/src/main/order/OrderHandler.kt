package kotlinddd.application.order

import kotlinddd.application.order.commands.CreateOrderCommand
import org.axonframework.commandhandling.CommandHandler

class OrderHandler {
    @CommandHandler
    fun createOrder(command: CreateOrderCommand) {
        //val order = Order(command.user)
        //...
    }
}
