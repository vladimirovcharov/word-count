package org.example.wordconsumer.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class WordConsumerService {
    private static final Logger LOGGER = LoggerFactory.getLogger(WordConsumerService.class);

    @KafkaListener(topics = "word-count", groupId = "word-group-id")
    public void consume(ConsumerRecord<String, Long> record) {
        LOGGER.info("Received Message -> {} : {}", record.key(), record.value());
    }
}
