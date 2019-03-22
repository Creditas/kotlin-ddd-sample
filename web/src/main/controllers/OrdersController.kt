package kotlinddd.web.controllers

import kotlinddd.application.order.commandhandlers.commands.*
import kotlinddd.domain.BusinessException
import kotlinddd.domain.order.payment.CreditCard
import kotlinddd.infrastructure.queries.OrdersQuery
import kotlinddd.infrastructure.queries.dtos.OrderDTO
import kotlinddd.infrastructure.queries.dtos.OrderPerUsersDTO
import kotlinddd.web.models.*
import kotlinddd.web.models.PayOrderRequest
import org.axonframework.commandhandling.gateway.CommandGateway
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
class OrderController(val commandGateway: CommandGateway) {
    // Commands
    @PostMapping("/orders")
    fun createOrder(@RequestBody request: CreateOrderRequest) : ResponseEntity<UUID> {
        val command = CreateOrderCommand(UUID.fromString(request.customerId))
        val orderId = commandGateway.sendAndWait<UUID>(command)

        return ResponseEntity(orderId, HttpStatus.CREATED)
    }

    @PatchMapping("/orders/{orderId}/products")
    @ResponseStatus(HttpStatus.OK)
    fun addProduct(@PathVariable("orderId") orderId: String, @RequestBody request: AddProductRequest) {
        val command = AddProductCommand(UUID.fromString(orderId),
                                        UUID.fromString(request.productId),
                                        request.quantity)

        commandGateway.sendAndWait<UUID>(command)
    }

    @PatchMapping("/orders/{orderId}/products/{productId}")
    @ResponseStatus(HttpStatus.OK)
    fun changeProductQuantity(@PathVariable("orderId") orderId: String,
                              @PathVariable("productId") productId: String,
                              @RequestBody request: ChangeProductQuantityRequest) {

        val command = ChangeProductQuantityCommand(UUID.fromString(orderId),
                                                   UUID.fromString(productId),
                                                   request.quantity)

        commandGateway.sendAndWait<UUID>(command)
    }

    @DeleteMapping("/orders/{orderId}/products/{productId}")
    @ResponseStatus(HttpStatus.OK)
    fun removeProduct(@PathVariable("orderId") orderId: String,
                      @PathVariable("productId") productId: String) {

        val command = RemoveProductCommand(UUID.fromString(orderId), UUID.fromString(productId))

        commandGateway.sendAndWait<UUID>(command)
    }

    @PatchMapping("/orders/{orderId}")
    @ResponseStatus(HttpStatus.OK)
    fun payOrder(@PathVariable("orderId") orderId: String,
                 @RequestBody request: PayOrderRequest) {

        val card = CreditCard(request.cardName, request.cardNumber, request.expirationDate ?: Date(), request.verificationCode)
        val command = PayOrderCommand(UUID.fromString(orderId), card)

        commandGateway.sendAndWait<UUID>(command)
    }

    // Queries
    @GetMapping("/orders/{orderId}")
    fun findOrderById(@PathVariable("orderId") orderId: String): OrderDTO {
        return OrdersQuery.findOrderById(UUID.fromString(orderId))
    }

    @GetMapping("/orders", params = ["orders_per_users"])
    fun findOrderPerUsers() : List<OrderPerUsersDTO>{
        return OrdersQuery.findOrderPerUsers()
    }

    @GetMapping("/orders", params = ["last_orders"])
    fun findLastOrders() : List<Any> {
        return OrdersQuery.findLastOrders()
    }

//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(BusinessException::class)
//    fun handleException() {
//
//    }
//
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    @ExceptionHandler(Exception::class)
//    fun handleException() {
//
//    } 
}