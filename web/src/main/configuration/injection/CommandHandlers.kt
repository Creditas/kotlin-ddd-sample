package kotlinddd.web.configuration.injection

import kotlinddd.application.order.OrderHandler
import kotlinddd.domain.order.OrderRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class CommandHandlers {
    @Bean
    fun getOrderHandler(orderRepository: OrderRepository): OrderHandler {
        return OrderHandler(orderRepository)
    }
}