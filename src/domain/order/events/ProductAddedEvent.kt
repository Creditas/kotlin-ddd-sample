package org.dddsample.domain.order.events

import org.dddsample.domain.order.Product
import java.util.UUID

data class ProductAddedEvent(val orderId: UUID, val product: Product)