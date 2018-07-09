package kotlinddd.domain.shipping

import kotlinddd.domain.order.customer.Customer
import java.util.UUID

interface NotificationService {
    fun notifyCustomerOrderShipped(customer: Customer, id: UUID, shippingLabel: ShippingLabel)
}