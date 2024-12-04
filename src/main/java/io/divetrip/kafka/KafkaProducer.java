package io.divetrip.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.divetrip.dto.request.ProductCreateDto;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(String topic, ProductCreateDto dto) {
        ObjectMapper mapper = new ObjectMapper();
        String data = StringUtils.EMPTY;
        try {
            data = mapper.writeValueAsString(dto);
        } catch (JsonProcessingException ex) {
            log.error("JsonProcessingException: {}", ex.getMessage(), ex);
        }

        kafkaTemplate.send(topic, data);

        log.info("Kafka Producer sent data from the product micro service " + dto);
    }


}
