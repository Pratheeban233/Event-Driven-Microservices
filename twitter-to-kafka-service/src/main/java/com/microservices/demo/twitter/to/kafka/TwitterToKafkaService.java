package com.microservices.demo.twitter.to.kafka;

import com.microservices.demo.twitter.to.kafka.config.TwitterToKafkaServiceConfigData;
import com.microservices.demo.twitter.to.kafka.runner.impl.StreamRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.Arrays;

@SpringBootApplication
@ComponentScan("com.microservices.demo")
public class TwitterToKafkaService implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(TwitterToKafkaService.class);

    private TwitterToKafkaServiceConfigData twitterToKafkaServiceConfigData;

    private final StreamRunner streamRunner;

    public TwitterToKafkaService(TwitterToKafkaServiceConfigData configData, StreamRunner runner) {
        this.twitterToKafkaServiceConfigData = configData;
        this.streamRunner = runner;
    }

    public static void main(String[] args) {
        SpringApplication.run(TwitterToKafkaService.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        LOGGER.info("App Starts...");
        LOGGER.info(Arrays.toString(twitterToKafkaServiceConfigData.getTwitterKeywords().toArray()));
        streamRunner.start();
    }
}
