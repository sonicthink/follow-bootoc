package com.github.kevinjom.bootoc;

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
        @Override
        public void onApplicationEvent(ApplicationStartedEvent event) {
            System.out.println("-------------- now let's follow bootoc ----------------");
        }
    }

    public static class ReadyEventListener implements ApplicationListener<ApplicationReadyEvent> {
        @Override
        public void onApplicationEvent(ApplicationReadyEvent event) {
            System.out.println("------- bootoc is ready to serve, its context is "
                    + event.getApplicationContext().getClass().getName());
        }
    }

}

