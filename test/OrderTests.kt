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

class OrderTests {
    private lateinit var fixture: FixtureConfiguration<Order>

    @Before
    @Throws(Exception::class)
    fun setUp() {
        fixture = AggregateTestFixture<Order>(Order::class.java)
    }

    @Test
    fun `create a new order`() {
        val user = User(name = "ana")
        fixture.given()
                .`when`(CreateOrderCommand(user))
                .expectEvents(OrderCreatedEvent(0, user))
    }

    @Test
    fun `add product to order`() {
        val product = Product(name = "keyboard")
        fixture.given()
                .`when`(AddProductCommand(product = product, orderId = 1, quantity = 10))
                .expectEvents(ProductAddedEvent(1, product))
    }
}