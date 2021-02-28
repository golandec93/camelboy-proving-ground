package com.github.golandec93.camelboy.provingground.spring.routes;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
public class DirectBarRoute extends RouteBuilder {
    private static final Logger logger = LoggerFactory.getLogger(DirectBarRoute.class);

    @Override
    public void configure() {
        from("direct:Bar")
                .log(LoggingLevel.INFO, logger, "Coming to bar. Headers: ${in.headers}")
                .log(LoggingLevel.DEBUG, logger, "Coming to bar. Body: ${in.body}")
                .setBody(exchange -> exchange.getIn().getBody() + " bar ");
    }
}
