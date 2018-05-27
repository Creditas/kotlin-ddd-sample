package org.dddsample.application.order.commands

import org.axonframework.commandhandling.TargetAggregateIdentifier
import org.dddsample.domain.order.Product

data class AddProductCommand(@TargetAggregateIdentifier val orderId: Int,
                             val product: Product,
                             val quantity: Int)