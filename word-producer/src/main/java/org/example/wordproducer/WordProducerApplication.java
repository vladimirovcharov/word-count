package org.example.wordproducer;

import org.example.wordproducer.service.WordProducerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WordProducerApplication implements CommandLineRunner {
    private final WordProducerService wordProducerService;

    public WordProducerApplication(WordProducerService wordProducerService) {
        this.wordProducerService = wordProducerService;
    }

    public static void main(String[] args) {
        SpringApplication.run(WordProducerApplication.class, args);
    }

    @Override
    public void run(String... args) throws InterruptedException {
        wordProducerService.produce();
    }
}
