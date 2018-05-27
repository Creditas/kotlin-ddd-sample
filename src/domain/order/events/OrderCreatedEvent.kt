package org.dddsample.domain.order.events

import org.dddsample.domain.order.User

data class OrderCreatedEvent(val orderId: Int, val user: User)