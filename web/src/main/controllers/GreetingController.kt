package kotlinddd.web.controllers

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
    fun test(@RequestParam(value = "name", defaultValue = "World") name: String) =
            "Hello, $name"
}