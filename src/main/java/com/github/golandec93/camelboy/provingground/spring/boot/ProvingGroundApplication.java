package com.github.golandec93.camelboy.provingground.spring.boot;

import com.github.golandec93.camelboy.provingground.spring.boot.servlet.LoggingFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.github.golandec93.camelboy.provingground.spring")
public class ProvingGroundApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProvingGroundApplication.class, args);
    }

    @Bean
    public FilterRegistrationBean<LoggingFilter> registerLoggingFilter(@Autowired LoggingFilter loggingFilter) {
        loggingFilter.setMaxPayloadLength(4000);
        loggingFilter.setIncludeHeaders(true);
        loggingFilter.setIncludePayload(true);
        loggingFilter.setIncludeQueryString(true);
        loggingFilter.setIncludeClientInfo(true);
        return new FilterRegistrationBean<>(loggingFilter);
    }
}
