package kotlinddd.application.order.commandhandlers.commands

import kotlinddd.domain.order.payment.CreditCard
import java.util.UUID

data class PayOrderCommand(val orderId: UUID, val creditCard: CreditCard)