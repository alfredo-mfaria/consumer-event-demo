package net.leanix.consumer.eventdemo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ConsumerEventDemoApplication

fun main(args: Array<String>) {
	runApplication<ConsumerEventDemoApplication>(*args)
}
