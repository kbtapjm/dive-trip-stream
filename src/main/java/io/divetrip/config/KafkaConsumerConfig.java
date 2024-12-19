package io.divetrip.config;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
@RequiredArgsConstructor
public class KafkaConsumerConfig {

    private final Environment environment;

    /**
     * Kafka Consumer 설정
     * @return
     */
    @Bean
    public ConsumerFactory<String, String> consumerFactory() {
        Map<String, Object> properties = new HashMap<>();

        // kafka broker 위치 지정
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, environment.getProperty("spring.kafka.consumer.bootstrap-servers"));

        // Kafka Consumer 그룹의 ID 지정, 같은 그룹 ID를 가진 컨슈머들은 메시지를 공유하여 처리
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, environment.getProperty("spring.kafka.consumer.group-id"));

        // offset 이 없거나 더 이상 없는 경우 어떻게 처리할지 전략 결정
        properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG,environment.getProperty("spring.kafka.consumer.auto-offset-reset"));

        // Kafka 메시지의 키, 값을 어떻게 역직렬화 할지 설정합니다.
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);

        // 위의 설정한 properties 값을 바탕으로 ConsumerFactory를 생성합니다.
        return new DefaultKafkaConsumerFactory<>(properties);
    }

    /**
     * Kafka Listener Containers 생성(해당 토픽의 메시지를 가져옴)
     *
     * @return
     */
    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory = new ConcurrentKafkaListenerContainerFactory<>();
        kafkaListenerContainerFactory.setConsumerFactory(consumerFactory());

        return kafkaListenerContainerFactory;
    }

}
