package kotlinddd.web.configuration.injection

import kotlinddd.domain.order.OrderRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import repositories.OrderRepositoryImpl

@Configuration
class Repositories {
    @Bean
    fun getOrderRepository() : OrderRepository {
        return OrderRepositoryImpl()
    }
}
