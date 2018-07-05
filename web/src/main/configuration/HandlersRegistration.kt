package kotlinddd.web.configuration

import kotlinddd.application.order.OrderHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class HandlersRegistration {
    @Bean
    fun getOrderHandler(): OrderHandler {
        return OrderHandler()
    }
}