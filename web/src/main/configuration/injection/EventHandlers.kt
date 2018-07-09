package kotlinddd.web.configuration.injection

import kotlinddd.application.shipping.eventhandlers.ShipOrderAndNotifyUser
import kotlinddd.domain.order.OrderRepository
import kotlinddd.domain.shipping.ShippingService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class EventHandlers {
    @Autowired
    lateinit var orderRepository: OrderRepository

    @Autowired
    lateinit var shippingService: ShippingService

    @Bean
    fun getShipPaidProductAndNotifyUserEventHandler(): ShipOrderAndNotifyUser {
        return ShipOrderAndNotifyUser(orderRepository, shippingService)
    }
}