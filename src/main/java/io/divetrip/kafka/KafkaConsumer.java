package io.divetrip.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaConsumer {

    @KafkaListener(topics = "dev-topic")
    public void devTopicListener(String kafkaMessage) {
        log.debug("Kafka Message : -> " + kafkaMessage);
    }
}
