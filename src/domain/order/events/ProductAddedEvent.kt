package org.dddsample.domain.order.events

import org.dddsample.domain.order.Product

data class ProductAddedEvent(val orderId: Int, val product: Product)