package kotlinddd.domain.order

interface OrderRepository {
    fun findById(id: String) : Order
    fun save(order: Order)
}