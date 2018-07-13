package kotlinddd.web.configuration.injection

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.axonframework.amqp.eventhandling.spring.SpringAMQPMessageSource
import com.rabbitmq.client.Channel
import org.axonframework.serialization.Serializer
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.amqp.core.Message
import org.axonframework.config.EventHandlingConfiguration
import org.axonframework.config.DefaultConfigurer
import org.axonframework.config.EventProcessingConfiguration


@Configuration
class AMQP {
    @Autowired
    lateinit var springAMQPMessageSource: SpringAMQPMessageSource

    @Autowired
    fun configure(configurer: DefaultConfigurer, eventProcessingConfiguration: EventProcessingConfiguration, eventHandlingConfiguration: EventHandlingConfiguration, rabbitMessageSource: SpringAMQPMessageSource) {
        //TODO: find a way to make the springAMQPMessageSource the default source for all processors
        eventProcessingConfiguration.registerSubscribingEventProcessor("kotlinddd.application.shipping.eventhandlers") { _ -> springAMQPMessageSource }
    }

    @Bean
    fun myRabbitMessageSource(serializer: Serializer): SpringAMQPMessageSource {
        return object : SpringAMQPMessageSource(serializer) {
            @RabbitListener(queues = ["DomainEvents"])
            @Throws(Exception::class)
            override fun onMessage(message: Message, channel: Channel) {
                super.onMessage(message, channel)
            }
        }
    }
}
