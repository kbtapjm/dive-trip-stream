package io.divetrip.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.divetrip.dto.request.ProductCreateDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaConsumer {

    private final ObjectMapper mapper;

    @KafkaListener(topics = "dev-topic")
    public void devTopicListener(String kafkaMessage) {
        log.debug("Kafka Message : -> " + kafkaMessage);

        try {
            ProductCreateDto productCreateDto = mapper.readValue(kafkaMessage, ProductCreateDto.class);
            log.debug("===> getDiverId: {}", productCreateDto.getDiverId());
            log.debug("===> getTripLodgingId: {}", productCreateDto.getTripLodgingId());
        } catch (JsonProcessingException e) {
            log.error("JsonProcessingException: {}", e.getMessage(), e);
        }


    }
}
