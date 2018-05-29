package org.dddsample.tests

import org.axonframework.test.aggregate.AggregateTestFixture
import org.axonframework.test.aggregate.FixtureConfiguration
import org.dddsample.application.order.commands.AddProductCommand
import org.dddsample.application.order.commands.CreateOrderCommand
import org.dddsample.domain.order.Order
import org.dddsample.domain.order.Product
import org.dddsample.domain.order.User
import org.dddsample.domain.order.events.OrderCreatedEvent
import org.dddsample.domain.order.events.ProductAddedEvent
import org.junit.Before
import org.junit.Test
import java.util.*

@Suppress("UNUSED_VARIABLE")
class OrderTests {
    private lateinit var fixture: FixtureConfiguration<Order>

    @Before
    @Throws(Exception::class)
    fun setUp() {
        fixture = AggregateTestFixture(Order::class.java)
    }

    @Test
    fun `create a new order`() {
        val user = User(name = "ana")
        fixture.givenNoPriorActivity()
                .`when`(CreateOrderCommand(user))
                .expectEvents(OrderCreatedEvent(UUID.randomUUID(), user))
    }

    @Test
    fun `add product to order`() {
        val user = User(name = "ana")
        val product = Product(name = "keyboard")
        val id = UUID.randomUUID()
        fixture.given(OrderCreatedEvent(id, user))
                .`when`(AddProductCommand(id, product, 10))
                .expectEvents(ProductAddedEvent(id, product))
    }
}