package kotlinddd.infrastructure.queries

import kotlinddd.infrastructure.queries.dtos.ItemDTO
import kotlinddd.infrastructure.queries.dtos.OrderDTO
import kotlinddd.infrastructure.queries.dtos.OrderPerUsersDTO
import java.util.*

class OrdersQuery {
    companion object {
        fun findOrderById(id: UUID): OrderDTO {
            return OrderDTO(id, listOf(ItemDTO("abc", 1, 2.0)))
        }

        fun findOrderPerUsers(): List<OrderPerUsersDTO> {
            return listOf(OrderPerUsersDTO("john", 10),
                    OrderPerUsersDTO("ana", 11),
                    OrderPerUsersDTO("asd", 12),
                    OrderPerUsersDTO("aba", 13),
                    OrderPerUsersDTO("bla", 14))
        }

        fun findLastOrders(): List<Any> {
            // Example returning a list of anonymous classes (to avoid the creation of a DTO class)
            return listOf(object {
                val id = UUID.randomUUID()
                val customer = "jhon"
            })
        }
    }
}