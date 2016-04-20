package com.github.kevinjom.bootoc;

import org.springframework.boot.Banner;
import org.springframework.boot.ResourceBanner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.core.io.ClassPathResource;

import static com.github.kevinjom.bootoc.BootocAppEventListeners.readyEventListener;
import static com.github.kevinjom.bootoc.BootocAppEventListeners.startedEventListener;

@SpringBootApplication
public class FollowBootocApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(FollowBootocApplication.class)
                .web(true)
                .bannerMode(Banner.Mode.CONSOLE)
                .banner(new ResourceBanner(new ClassPathResource("banner.txt")))
                .listeners(startedEventListener(), readyEventListener())
                .run(args);
    }
}
