package kotlinddd.domain.order.customer

import java.util.UUID

data class Customer(val id: UUID, val name: String, val address: Address)
