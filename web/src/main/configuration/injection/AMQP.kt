package kotlinddd.web.configuration.injection

import org.axonframework.amqp.eventhandling.spring.SpringAMQPPublisher
import org.axonframework.eventhandling.EventBus
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.axonframework.amqp.eventhandling.spring.SpringAMQPMessageSource
import com.rabbitmq.client.Channel
import org.axonframework.serialization.Serializer
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.amqp.core.Message
import org.axonframework.config.EventHandlingConfiguration
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory
import org.springframework.amqp.rabbit.connection.ConnectionFactory
import org.springframework.beans.factory.annotation.Value

@Configuration
class AMQPReader {
    @Autowired
    lateinit var eventBus: EventBus

    @Value("\${spring.rabbitmq.host}")
    private lateinit var rabbitHost: String

    @Value("\${spring.rabbitmq.port}")
    private var rabbitPort: Int = 0

    @Value("\${spring.rabbitmq.username}")
    private lateinit var rabbitUserName: String

    @Value("\${spring.rabbitmq.password}")
    private lateinit var rabbitPassword: String

    @Autowired
    fun configure(ehConfig: EventHandlingConfiguration, rabbitMessageSource: SpringAMQPMessageSource) {
        ehConfig.registerSubscribingEventProcessor("rabbitSubscriberProcessor") { _ -> rabbitMessageSource }
    }

    @Bean
    fun getSpringAMQPPublisher() : SpringAMQPPublisher {
        return SpringAMQPPublisher(eventBus)
    }

    @Bean
    fun getConnectionFactory(): ConnectionFactory {
        val connectionFactory = CachingConnectionFactory(rabbitHost, rabbitPort)
        connectionFactory.setUsername(rabbitUserName)
        connectionFactory.setPassword(rabbitPassword)
        return connectionFactory
    }

    @Bean
    fun rabbitMessageSource(serializer: Serializer): SpringAMQPMessageSource {
        return object : SpringAMQPMessageSource(serializer) {
            @RabbitListener(queues = ["DomainEvents"])
            @Throws(Exception::class)
            override fun onMessage(message: Message, channel: Channel) {
                super.onMessage(message, channel)
            }
        }
    }
}
