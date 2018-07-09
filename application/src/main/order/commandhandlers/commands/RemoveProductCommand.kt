package kotlinddd.application.order.commandhandlers.commands

import java.util.UUID

data class RemoveProductCommand(val orderId: UUID, val productId: UUID)