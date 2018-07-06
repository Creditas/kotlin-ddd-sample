package repositories

import kotlinddd.domain.order.Order
import kotlinddd.domain.order.OrderRepository
import kotlinddd.domain.order.Product
import order.Customer
import org.javamoney.moneta.Money
import java.util.UUID
import javax.money.Monetary

class OrderRepositoryImpl : OrderRepository {
    override fun findById(id: UUID): Order {
        return Order(id = id,
                     customer = Customer(UUID.randomUUID(), "John Doe"))
    }

    override fun findProductById(productId: UUID): Product {
        return Product(id = productId,
                       description = "Keyboard",
                       value = Money.of(19.90, Monetary.getCurrency("USD")))
    }

    override fun findCustomerById(customerId: UUID): Customer {
        return Customer(customerId, "John Doe")
    }

    override fun save(order: Order) {
        //TODO
    }
}
