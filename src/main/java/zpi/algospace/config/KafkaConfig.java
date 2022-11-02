package zpi.algospace.config;

import lombok.Getter;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.*;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.requestreply.ReplyingKafkaTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;

@Configuration
@EnableKafka
@Getter
public class KafkaConfig {
    @Value("${spring.kafka.bootstrap-servers}")
    private String kafkaServer;

    @Bean
    public ConsumerFactory<String, String> consumerFactory() {
        Map<String, Object> config = new HashMap<>();
        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, getKafkaServer());
        return new DefaultKafkaConsumerFactory<>(config, new StringDeserializer(), new StringDeserializer());
    }

    @Bean
    public ProducerFactory<String, String> producerFactory() {
        Map<String, Object> config = new HashMap<>();
        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, getKafkaServer());
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        return new DefaultKafkaProducerFactory<>(config);
    }

    @Bean
    public KafkaTemplate<String, String> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }

    @Bean
    public ReplyingKafkaTemplate<String, String, String> solutionResultTemplate(
        ProducerFactory<String, String> producerFactory,
        ConcurrentKafkaListenerContainerFactory<String, String> listenerFactory
    ) {
        ConcurrentMessageListenerContainer<String, String> replyContainer =
                listenerFactory.createContainer("replies");
        replyContainer.getContainerProperties().setGroupId(UUID.randomUUID().toString());
        Properties props = new Properties();
        props.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        replyContainer.getContainerProperties().setKafkaConsumerProperties(props);

        ReplyingKafkaTemplate<String, String, String> template = new ReplyingKafkaTemplate<>(producerFactory, replyContainer);
        template.setSharedReplyTopic(true);
        template.setDefaultTopic("request");

        return template;
    }

    @Bean
    public NewTopic requestsTopic() {
        return new NewTopic("request", 10, (short) 1);
    }

    @Bean
    public NewTopic resultsTopic() {
        return new NewTopic("result", 10, (short) 1);
    }
}
