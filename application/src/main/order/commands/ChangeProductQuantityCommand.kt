package kotlinddd.application.order.commands

import java.util.UUID

data class ChangeProductQuantityCommand(val orderId: UUID, val productId: UUID, val quantity: Int)