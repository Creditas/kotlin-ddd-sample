package kotlinddd.order.domain

import kotlinddd.application.order.commands.CreateOrderCommand
import org.axonframework.commandhandling.CommandHandler
import org.axonframework.commandhandling.model.AggregateIdentifier
import org.axonframework.commandhandling.model.AggregateLifecycle.apply


class Order {
    @AggregateIdentifier
    private lateinit var id: String

    constructor() //TODO remove

    @CommandHandler
    constructor(command: CreateOrderCommand) {
        println("wooopa!" + command.user)
        //apply
    }
}


