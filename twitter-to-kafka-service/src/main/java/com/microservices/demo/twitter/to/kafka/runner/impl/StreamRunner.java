package com.microservices.demo.twitter.to.kafka.runner.impl;

import twitter4j.TwitterException;

public interface StreamRunner {
    void start() throws TwitterException;
}