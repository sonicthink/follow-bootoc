package com.github.kevinjom.bootoc.config;

import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.jetty.JettyEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServletContainerConfiguration {

    @Bean
    public EmbeddedServletContainerFactory servletContainerFactory() {
        JettyEmbeddedServletContainerFactory factory = new JettyEmbeddedServletContainerFactory();
        factory.setPort(8081);

        return factory;
    }

}
