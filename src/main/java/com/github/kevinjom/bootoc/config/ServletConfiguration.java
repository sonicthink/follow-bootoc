package com.github.kevinjom.bootoc.config;

import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ServletComponentScan("com.github.kevinjom.bootoc.servlet")
public class ServletConfiguration {
}
