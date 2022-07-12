package net.leanix.consumer.eventdemo.consumer

import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.Producer
import org.apache.kafka.clients.producer.ProducerRecord
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.kafka.test.EmbeddedKafkaBroker
import org.springframework.kafka.test.context.EmbeddedKafka
import org.springframework.kafka.test.utils.KafkaTestUtils
import org.springframework.test.annotation.DirtiesContext

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@EmbeddedKafka(
    partitions = 1,
    brokerProperties = ["listeners=PLAINTEXT://localhost:9092", "port=9092", "spring.cloud.stream.kafka.binder.brokers"],
    topics = ["metric-items"]
)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class MetricEventConsumerTest {

    val metric: String = "test metric"

    @Autowired
    lateinit var embeddedKafkaBroker: EmbeddedKafkaBroker

    lateinit var producer: Producer<String, String>

    @BeforeEach
    fun setUp() {
        val configs: Map<String, Any> = HashMap(KafkaTestUtils.producerProps(embeddedKafkaBroker))
        producer = KafkaProducer(configs)
        val message: ProducerRecord<String?, String> = ProducerRecord("metric-items", null, metric)
        producer.send(message)
    }

    @Test
    fun `There is no logic to test here`() {
        // to implement
        assertTrue(true)
    }
}