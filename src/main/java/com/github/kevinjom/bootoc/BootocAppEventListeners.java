package com.github.kevinjom.bootoc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;

public final class BootocAppEventListeners {

    public static StartedEventListener startedEventListener() {
        return new StartedEventListener();
    }

    public static ReadyEventListener readyEventListener() {
        return new ReadyEventListener();
    }

    public static class StartedEventListener implements ApplicationListener<ApplicationStartedEvent> {

        public static final Logger logger = LoggerFactory.getLogger(StartedEventListener.class);

        @Override
        public void onApplicationEvent(ApplicationStartedEvent event) {
            logger.info("-------------- now let's follow bootoc ----------------");
        }
    }

    public static class ReadyEventListener implements ApplicationListener<ApplicationReadyEvent> {

        public static final Logger logger = LoggerFactory.getLogger(StartedEventListener.class);

        @Override
        public void onApplicationEvent(ApplicationReadyEvent event) {
            logger.info("------- bootoc is ready to serve, its context is {}", event.getApplicationContext().getClass());
        }
    }

}

