package kotlinddd.web.configuration.injection

import kotlinddd.application.order.OrderCommandHandlers
import kotlinddd.domain.order.OrderRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class CommandHandlers {
    @Autowired
    lateinit var orderRepository: OrderRepository

    @Bean
    fun getOrderHandler(): OrderCommandHandlers {
        return OrderCommandHandlers(orderRepository)
    }
}