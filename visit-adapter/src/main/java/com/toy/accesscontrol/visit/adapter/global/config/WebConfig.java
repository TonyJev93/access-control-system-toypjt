package com.toy.accesscontrol.visit.adapter.global.config;

import com.toy.accesscontrol.visit.adapter.global.converter.StringToVisitIdVoConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new StringToVisitIdVoConverter());
    }
}
