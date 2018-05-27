package org.dddsample

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.axonframework.commandhandling.gateway.DefaultCommandGateway
import org.axonframework.commandhandling.gateway.CommandGateway
import org.axonframework.commandhandling.SimpleCommandBus
import org.axonframework.commandhandling.CommandBus
import org.axonframework.eventsourcing.EventSourcingRepository
import org.axonframework.eventsourcing.eventstore.EmbeddedEventStore
import org.axonframework.eventsourcing.eventstore.EventStore
import org.axonframework.eventsourcing.eventstore.inmemory.InMemoryEventStorageEngine
import org.dddsample.domain.order.Order
import org.axonframework.commandhandling.AggregateAnnotationCommandHandler
import org.axonframework.eventhandling.AnnotationEventListenerAdapter
import org.dddsample.application.order.OrderHandler


@SpringBootApplication
class Application

fun main(args: Array<String>) {
    SpringApplication.run(Application::class.java, *args)

    val commandBus: SimpleCommandBus = SimpleCommandBus()
    val commandGateway = DefaultCommandGateway(commandBus)
    var eventStore = EmbeddedEventStore(InMemoryEventStorageEngine())

    val repository: EventSourcingRepository<OrderHandler> = EventSourcingRepository<OrderHandler>(OrderHandler::class.java, eventStore)
    val handler = AggregateAnnotationCommandHandler<OrderHandler>(OrderHandler::class.java, repository)
    handler.subscribe(commandBus)

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
}