package kotlinddd.web.configuration

import kotlinddd.application.order.OrderHandler

fun registerHandlers() {
    Axon.configurer.registerCommandHandler { _ -> OrderHandler() }
}
