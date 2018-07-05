package kotlinddd.web.controllers

import kotlinddd.application.order.commands.CreateOrderCommand
import kotlinddd.web.models.Greeting
import org.axonframework.commandhandling.gateway.CommandGateway
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class GreetingController(val commandGateway: CommandGateway) {

    @PostMapping("/order")
    fun createOrder(@RequestParam(value = "name", defaultValue = "World") name: String) =
            Greeting(1, "Hello, $name")

    @GetMapping("/test")
    fun test(@RequestParam(value = "name", defaultValue = "World") name: String) : String {
        val command = CreateOrderCommand(user = name)

        return commandGateway.send<String>(command)
                             .handle(fun(str: String, ex: Throwable): String { return str + ex.message })
                             .get()
    }
}