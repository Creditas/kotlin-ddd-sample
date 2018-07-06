package kotlinddd.application.order.commands

import order.Customer
import java.util.UUID

data class CreateOrderCommand(val customerId: UUID)