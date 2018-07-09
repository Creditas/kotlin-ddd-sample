package kotlinddd.infrastructure.services

import kotlinddd.domain.order.customer.Customer
import kotlinddd.domain.shipping.NotificationService
import kotlinddd.domain.shipping.ShippingLabel
import java.util.*

class EmailNotificationService : NotificationService {
    override fun notifyCustomerOrderShipped(customer: Customer, id: UUID, shippingLabel: ShippingLabel) {
        // populate and send mail ...
    }
}