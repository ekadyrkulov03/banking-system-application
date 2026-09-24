package com.pro.commons.events.publisher;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class EventPublisher {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void publish(String topic, String key, Object event) {
        kafkaTemplate.send(topic, key, event)
                .whenComplete((recordMetadata, e) -> {
                    if (e != null) {
                        log.error("Error publishing event: {}", e.getMessage());
                    } else {
                        log.info("Event published successfully - partition: {}, offset: {}",
                                recordMetadata.getRecordMetadata().partition(),
                                recordMetadata.getRecordMetadata().offset()
                        );
                    }
                });
    }

}
