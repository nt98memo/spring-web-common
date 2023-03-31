package com.example.common.conf;

import org.springframework.boot.convert.ApplicationConversionService;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.common.converter.StringToOrderDirectionConverter;

@Configuration
public class EnumMappingConfig implements WebMvcConfigurer {
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new StringToOrderDirectionConverter());
        ApplicationConversionService.configure(registry);
    }
}
