package kotlinddd.application.shipping.eventhandlers

import kotlinddd.domain.order.OrderPaid
import kotlinddd.domain.order.OrderRepository
import kotlinddd.domain.shipping.ShippingService
import org.axonframework.eventhandling.EventHandler

open class ShipOrderAndNotifyUser(private val orderRepository: OrderRepository,
                                  private val shippingService: ShippingService) {
    @EventHandler
    fun handle(event: OrderPaid) {
        val order = orderRepository.findById(event.orderId)
        shippingService.shipOrder(order)
    }
}

