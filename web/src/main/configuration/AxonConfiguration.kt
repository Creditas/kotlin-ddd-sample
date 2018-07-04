package kotlinddd.web.configuration

import kotlinddd.application.order.OrderHandler
import org.axonframework.commandhandling.SimpleCommandBus
import org.axonframework.commandhandling.gateway.DefaultCommandGateway
import org.axonframework.config.Configurer
import org.axonframework.config.DefaultConfigurer

object Axon { //TODO: Replace this static object by spring auto injection into controllers
    lateinit var commandGateway : DefaultCommandGateway
    lateinit var configurer: Configurer
}

fun configureAxon() {
    val commandBus = SimpleCommandBus()
    val commandGateway = DefaultCommandGateway(commandBus)

    val configurer = DefaultConfigurer.defaultConfiguration()
    configurer.configureCommandBus { _ -> commandBus }

    Axon.commandGateway = commandGateway
    Axon.configurer = configurer
    Axon.configurer.registerCommandHandler { _ -> OrderHandler() }

    configurer.start()
}
