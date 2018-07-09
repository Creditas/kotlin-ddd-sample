package kotlinddd.infrastructure.services

import kotlinddd.domain.order.Order
import kotlinddd.domain.shipping.DeliveryProviderService
import kotlinddd.domain.shipping.ShippingLabel
import java.util.Date

class FedExDeliveryService : DeliveryProviderService {
    override fun requestFastDelivery(order: Order): ShippingLabel {
        // call FedEx service...

        return ShippingLabel("ABCD-123456", Date())
    }

    override fun requestStandardDelivery(order: Order): ShippingLabel {
        // call FedEx service...

        return ShippingLabel("EFGH-456789", Date())
    }
}