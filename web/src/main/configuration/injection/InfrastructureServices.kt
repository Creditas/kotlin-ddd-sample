package kotlinddd.web.configuration.injection

import kotlinddd.infrastructure.services.EmailNotificationService
import kotlinddd.infrastructure.services.FedExDeliveryService
import kotlinddd.infrastructure.services.PaymentServiceImpl
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class InfrastructureServices {
    @Bean
    fun getPaymentService(): PaymentServiceImpl {
        return PaymentServiceImpl()
    }

    @Bean
    fun getFedExDeliveryService(): FedExDeliveryService {
        return FedExDeliveryService()
    }

    @Bean
    fun getEmailNotificationService(): EmailNotificationService {
        return EmailNotificationService()
    }
}