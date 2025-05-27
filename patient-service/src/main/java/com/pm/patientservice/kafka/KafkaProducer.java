package com.pm.patientservice.kafka;

import com.pm.patientservice.model.Patient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import patient.events.PatientEvent;

@Service
public class KafkaProducer {
    private static final Logger log = LoggerFactory.getLogger(KafkaProducer.class);
    private final KafkaTemplate<String, byte[]> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, byte[]> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendEvent(Patient patient) {
        PatientEvent e = new PatientEvent().newBuilderForType()
                .setName(patient.getName())
                .setEmail(patient.getEmail())
                .setPatientId(patient.getId().toString())
                .setEventType("PATIENT_CREATED")
                .build();

        try{
            kafkaTemplate.send("patient",e.toByteArray());
        } catch (Exception ex) {
            log.error("Error sending event : {}",ex.getMessage());
            throw new RuntimeException(ex);
        }



    }
}
