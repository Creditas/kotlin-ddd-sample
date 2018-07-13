package kotlinddd.web.configuration.injection

import kotlinddd.domain.shipping.ShippingService
import kotlinddd.infrastructure.services.EmailNotificationService
import kotlinddd.infrastructure.services.FedExDeliveryService
import kotlinddd.infrastructure.services.PaymentServiceImpl
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class Services {
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

    @Bean
    fun getShippingService(): ShippingService {
        return ShippingService(getEmailNotificationService(), getFedExDeliveryService())
    }
}