package br.com.felipe.demo.user.event;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserEventProducer {
    private final KafkaTemplate<String, UserEvent> kafkaTemplate;
    private static final String TOPIC = "user-events";

    public void publishUserEvent(UserEvent event) {
        final String eventKey = TOPIC + "-" + event.getUserId().toString();
        kafkaTemplate.send(eventKey, event);
    }
}
