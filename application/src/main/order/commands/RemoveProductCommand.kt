package kotlinddd.application.order.commands

import java.util.UUID

data class RemoveProductCommand(val orderId: UUID, val productId: UUID)