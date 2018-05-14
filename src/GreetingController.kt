package org.dddsample

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong

@RestController
class GreetingController {

    val counter = AtomicLong()

    @GetMapping("/greeting")
    fun greeting(@RequestParam(value = "name", defaultValue = "World") name: String) =
            Greeting(1, "Hello, $name")

    @GetMapping("/test")
    fun test(@RequestParam(value = "name", defaultValue = "World") name: String) =
            "Hello, $name"

}