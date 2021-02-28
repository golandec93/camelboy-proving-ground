package com.github.golandec93.camelboy.provingground.spring.boot.servlet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.AbstractRequestLoggingFilter;

import javax.servlet.http.HttpServletRequest;

@Component
public class LoggingFilter extends AbstractRequestLoggingFilter {
    private static final Logger logger = LogManager.getLogger();

    @Override
    protected void beforeRequest(HttpServletRequest httpServletRequest, String message) {
        logger.debug(message);
    }

    @Override
    protected void afterRequest(HttpServletRequest httpServletRequest, String message) {
        logger.debug(message);
    }
}