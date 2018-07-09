package kotlinddd.web.configuration.injection

import kotlinddd.infrastructure.PaymentServiceImpl
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class InfrastructureServices() {
    @Bean
    fun getPaymentService(): PaymentServiceImpl {
        return PaymentServiceImpl()
    }
}