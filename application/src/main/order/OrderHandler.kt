package kotlinddd.application.order

import kotlinddd.application.order.commands.AddProductCommand
import kotlinddd.application.order.commands.ChangeProductQuantityCommand
import kotlinddd.application.order.commands.CreateOrderCommand
import kotlinddd.application.order.commands.RemoveProductCommand
import kotlinddd.domain.order.Order
import kotlinddd.domain.order.OrderRepository
import org.axonframework.commandhandling.CommandHandler
import java.util.UUID

open class OrderHandler(val repository: OrderRepository) {
    @CommandHandler
    fun createOrder(command: CreateOrderCommand): UUID {
        val orderId = UUID.randomUUID()
        val customer = repository.findCustomerById(command.customerId)

        val order = Order(orderId, customer)
        repository.save(order)

        return orderId
    }

    @CommandHandler
    fun addProduct(command: AddProductCommand) {
        val order = repository.findById(command.orderId)
        val product = repository.findProductById(command.productId)

        order.addProduct(product, command.quantity)

        repository.save(order)
    }

    @CommandHandler
    fun changeProductQuantity(command: ChangeProductQuantityCommand) {
        val order = repository.findById(command.orderId)
        val product = repository.findProductById(command.productId)

        order.changeProductQuantity(product, command.quantity)

        repository.save(order)
    }

    @CommandHandler
    fun removeProduct(command: RemoveProductCommand) {
        val order = repository.findById(command.orderId)
        val product = repository.findProductById(command.productId)

        order.removeProduct(product)

        repository.save(order)
    }
}

