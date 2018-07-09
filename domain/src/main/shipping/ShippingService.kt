package kotlinddd.domain.shipping

import kotlinddd.domain.order.Order

class ShippingService(private val notificationService: NotificationService,
                      private val deliveryProviderService: DeliveryProviderService) {

    fun shipOrder(order: Order) {
        val shippingLabel = if (availableForUltraFastShipping(order))
                                deliveryProviderService.requestFastDelivery(order)
                            else
                                deliveryProviderService.requestStandardDelivery(order)

        notificationService.notifyCustomerOrderShipped(order.customer, order.id, shippingLabel)
    }

    private fun availableForUltraFastShipping(order: Order) : Boolean {
        val availableStates = listOf("EU", "JP", "BR", "FR")

        return availableStates.contains(order.customer.address.state)
    }
}