package kotlinddd.domain.shipping

import kotlinddd.domain.order.Order

interface DeliveryProviderService {
    fun requestFastDelivery(order: Order) : ShippingLabel
    fun requestStandardDelivery(order: Order) : ShippingLabel
}