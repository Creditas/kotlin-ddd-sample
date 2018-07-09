package kotlinddd.web.configuration.injection

import kotlinddd.application.order.OrderEventHandlers
import kotlinddd.domain.order.OrderRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class EventHandlers {
    @Autowired
    lateinit var orderRepository: OrderRepository

    @Bean
    fun getOrderEventHandlers(): OrderEventHandlers {
        return OrderEventHandlers(orderRepository)
    }
}