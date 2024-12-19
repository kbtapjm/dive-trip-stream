package io.divetrip.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.divetrip.message.model.Notification;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Slf4j
@Service
@RequiredArgsConstructor
public class NotificationConsumer {

    private static final String TOPIC_NAME = "notification-topic";

    private final ObjectMapper objectMapper;

    @KafkaListener(topics = TOPIC_NAME)
    public void notificationListener(String message) throws IOException {
        log.debug("####################################################################################################################");
        log.debug("notificationListener consume message: {}", message);

        if (StringUtils.isNotEmpty(message)) {
            Notification notification = objectMapper.readValue(message, Notification.class);

            log.debug("notification: {}", notification.toString());
        }

        log.debug("####################################################################################################################");

    }
}
