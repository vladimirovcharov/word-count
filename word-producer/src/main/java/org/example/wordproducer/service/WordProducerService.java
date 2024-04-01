package org.example.wordproducer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class WordProducerService {
    private static final Logger LOGGER = LoggerFactory.getLogger(WordProducerService.class);
    private static final List<String> WORDS = List.of("Hello", "hello world", "this is some text", "word", "word",
            "WORLD", "HelLO", "this is some another text");

    private final KafkaTemplate<String, String> kafkaTemplate;

    public WordProducerService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void produce() throws InterruptedException {
        for (String word : WORDS) {
            kafkaTemplate.send("sentences", word);
            LOGGER.info("Message sent -> {}", word);
            TimeUnit.SECONDS.sleep(1);
        }
    }
}
