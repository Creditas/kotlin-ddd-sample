package org.dddsample.domain.order.events

import org.dddsample.domain.order.User
import java.util.UUID

data class OrderCreatedEvent(val orderId: UUID, val user: User)