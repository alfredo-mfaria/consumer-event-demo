package net.leanix.consumer.eventdemo.consumer

import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Service
import java.util.function.Consumer

@Service
class MetricEventConsumer {

    @Bean
    fun metricConsumer(): Consumer<String>? {
        return Consumer<String> { value -> println("Consumer Received : $value") }
    }
}