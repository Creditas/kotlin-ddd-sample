package kotlinddd.application

import kotlinddd.application.order.OrderHandler
import kotlinddd.application.order.commands.CreateOrderCommand
import org.axonframework.commandhandling.SimpleCommandBus
import org.axonframework.commandhandling.gateway.DefaultCommandGateway
import org.axonframework.config.DefaultConfigurer

fun registerHandlers() {
    val commandBus = SimpleCommandBus()
    val commandGateway = DefaultCommandGateway(commandBus)

    val configurer = DefaultConfigurer.defaultConfiguration()
    configurer.registerCommandHandler { _ -> OrderHandler() }

    //var eventStore = EmbeddedEventStore(InMemoryEventStorageEngine())
    //val repository: EventSourcingRepository<Order> = EventSourcingRepository<Order>(Order::class.java, eventStore)

    //val handler = AggregateAnnotationCommandHandler<Order>(Order::class.java, repository)
    //handler.subscribe(commandBus)

    //val command = CreateOrderCommand(user = User(name = "ana"))
    //commandBus.dispatch(asCommandMessage(command), LoggingCallback.INSTANCE)

    commandGateway.send<CreateOrderCommand>(CreateOrderCommand(user = "jhon"))
}
