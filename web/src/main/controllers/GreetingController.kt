package kotlinddd.web.controllers

import kotlinddd.application.order.commands.CreateOrderCommand
import kotlinddd.web.configuration.Axon
import kotlinddd.web.models.Greeting
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class GreetingController {

    @PostMapping("/order")
    fun createOrder(@RequestParam(value = "name", defaultValue = "World") name: String) =
            Greeting(1, "Hello, $name")

    @GetMapping("/test")
    fun test(@RequestParam(value = "name", defaultValue = "World") name: String) : String {
        //Axon.commandGateway.send<CreateOrderCommand>(CreateOrderCommand(user = "jhon"))
        return "Hellooooooo, $name"
    }
}