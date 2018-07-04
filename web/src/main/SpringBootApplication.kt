package kotlinddd.web

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class Application

fun main(args: Array<String>) {
    //kotlinddd.application.registerHandlers()
    SpringApplication.run(Application::class.java, *args)
}