package io.divetrip.controller;

import io.divetrip.dto.request.ProductCreateDto;
import io.divetrip.kafka.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
@RequiredArgsConstructor
public class KafkaProducerController {

    private final KafkaProducer kafkaProducer;

    @PostMapping("/send")
    public ResponseEntity<?> send(@RequestBody ProductCreateDto dto) {
        kafkaProducer.send("dev-topic", dto);
        return ResponseEntity.ok("ok");
    }


}
