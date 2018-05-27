package org.dddsample.tests

import org.axonframework.test.aggregate.AggregateTestFixture
import org.axonframework.test.aggregate.FixtureConfiguration
import org.dddsample.application.order.commands.CreateOrderCommand
import org.dddsample.domain.order.Order
import org.dddsample.domain.order.events.OrderCreatedEvent
import org.junit.Before
import org.junit.Test

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class OrderTest {
    private var fixture: FixtureConfiguration<Order>? = null

    @Before
    @Throws(Exception::class)
    fun setUp() {
        fixture = AggregateTestFixture<Order>(Order::class.java)
    }

    @Test
    fun test1() {
        var a = 1
        assertTrue(a==1)
//        val id = 0;
//        fixture.given()
//                .when(CreateOrderCommand(id))
//                .expectEvents(OrderCreatedEvent(id));
    }

    @Test
    fun test2() {

    }
}