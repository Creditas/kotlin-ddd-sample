package kotlinddd.application.order

import kotlinddd.application.order.commands.CreateOrderCommand
import org.axonframework.commandhandling.CommandHandler
import java.security.InvalidParameterException

open class OrderHandler {
    @CommandHandler
    fun createOrder(command: CreateOrderCommand): String {
        if (command.user == "Foo")
            throw InvalidParameterException()

        return "Hello, ${command.user}!"
    }
}

