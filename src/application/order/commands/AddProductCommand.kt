package org.dddsample.application.order.commands

import org.axonframework.commandhandling.TargetAggregateIdentifier
import org.dddsample.domain.order.Product
import java.util.UUID

data class AddProductCommand(@TargetAggregateIdentifier val orderId: UUID,
                             val product: Product,
                             val quantity: Int)