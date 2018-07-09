package kotlinddd.web.configuration.injection

import kotlinddd.domain.order.OrderRepository
import kotlinddd.infrastructure.repositories.OrderRepositoryImpl
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class Repositories {
    @Bean
    fun getOrderRepository() : OrderRepository {
        return OrderRepositoryImpl()
    }
}
