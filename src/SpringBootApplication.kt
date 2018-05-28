package org.dddsample

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.axonframework.commandhandling.gateway.DefaultCommandGateway
import org.axonframework.commandhandling.SimpleCommandBus
import org.axonframework.eventsourcing.EventSourcingRepository
import org.axonframework.eventsourcing.eventstore.EmbeddedEventStore
import org.axonframework.eventsourcing.eventstore.inmemory.InMemoryEventStorageEngine
import org.dddsample.domain.order.Order
import org.axonframework.commandhandling.AggregateAnnotationCommandHandler
import org.axonframework.commandhandling.GenericCommandMessage.asCommandMessage
import org.axonframework.commandhandling.callbacks.LoggingCallback
import org.axonframework.eventhandling.AnnotationEventListenerAdapter
import org.dddsample.application.order.commands.CreateOrderCommand
import org.dddsample.domain.order.User

@SpringBootApplication
class Application

fun main(args: Array<String>) {
    val commandBus = SimpleCommandBus()
    val commandGateway = DefaultCommandGateway(commandBus)
    var eventStore = EmbeddedEventStore(InMemoryEventStorageEngine())

    val repository: EventSourcingRepository<Order> = EventSourcingRepository<Order>(Order::class.java, eventStore)
    val handler = AggregateAnnotationCommandHandler<Order>(Order::class.java, repository)
    handler.subscribe(commandBus)

    val command = CreateOrderCommand(user = User(name = "ana"))
    commandBus.dispatch(asCommandMessage(command), LoggingCallback.INSTANCE)

    val eventListener = AnnotationEventListenerAdapter(Order())
    eventStore.subscribe { eventMessages ->
        eventMessages.forEach { e ->
            try {
                eventListener.handle(e)
            } catch (e1: Exception) {
                throw RuntimeException(e1)
            }
        }
    }

    commandGateway.send<CreateOrderCommand>(CreateOrderCommand(User(name = "ana")))

    SpringApplication.run(Application::class.java, *args)
}