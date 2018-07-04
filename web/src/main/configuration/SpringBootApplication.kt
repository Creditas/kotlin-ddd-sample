package kotlinddd.web

import kotlinddd.web.configuration.*
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class Application

fun main(args: Array<String>) {
    configureAxon()
    registerHandlers()
    SpringApplication.run(Application::class.java, *args)
}