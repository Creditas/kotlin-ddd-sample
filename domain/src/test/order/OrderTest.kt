package kotlinddd.domain.order

import kotlinddd.domain.order.customer.*
import org.amshove.kluent.*
import org.javamoney.moneta.Money
import org.junit.Test
import java.util.*
import javax.money.*

class OrderTest {
    private val address = Address("Foo", 123, "LA", "US")
    private val customer = Customer(UUID.randomUUID(), "Jhon", address)

    @Test
    fun `Must to add a product to an order successfully`() {
        val order = Order(UUID.randomUUID(), customer)
        val product = Product(UUID.randomUUID(), "Book", Money.of(30.50, Monetary.getCurrency("USD")))

        order.addProduct(product, 10)

        order.items().count() shouldBe 1
    }
}