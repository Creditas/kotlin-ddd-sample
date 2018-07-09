package kotlinddd.application.order.commandhandlers.commands

import java.util.UUID

data class ChangeProductQuantityCommand(val orderId: UUID, val productId: UUID, val quantity: Int)