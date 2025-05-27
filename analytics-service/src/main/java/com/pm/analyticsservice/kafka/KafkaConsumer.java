package com.pm.analyticsservice.kafka;

import com.google.protobuf.InvalidProtocolBufferException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import patient.events.PatientEvent;

@Service
public class KafkaConsumer {
    private static final Logger log = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics = "patient",groupId = "analytics-service")
    public void consumeEvent(byte[] message) {
        try {
            PatientEvent pEvent = PatientEvent.parseFrom(message);
            log.info("Received Patient Event: {}", pEvent);
        } catch (InvalidProtocolBufferException e) {
            log.error("Error parsing Patient Event : {}", e);
        }
    }
}
