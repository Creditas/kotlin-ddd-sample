package kotlinddd.application.order.commands

import java.util.UUID

data class AddProductCommand(val orderId: UUID, val productId: UUID, val quantity: Int)