package com.github.kevinjom.bootoc;

import org.springframework.boot.Banner;
import org.springframework.boot.ResourceBanner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.core.io.ClassPathResource;

@SpringBootApplication
public class FollowBootocApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(FollowBootocApplication.class)
                .bannerMode(Banner.Mode.CONSOLE)
                .banner(new ResourceBanner(new ClassPathResource("banner.txt")))
                .listeners(new BootocAppStartedListener())
                .run(args);
    }
}
