package com.github.golandec93.camelboy.provingground.spring.routes;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class DirectFoobarRoute extends RouteBuilder {
    private static final Logger logger = LoggerFactory.getLogger(DirectFoobarRoute.class);
    @Override
    public void configure() {
        from("direct:Foobar")
                .log(LoggingLevel.INFO, logger, "Coming to Foobar. Headers: ${in.headers}")
                .log(LoggingLevel.DEBUG, logger, "Coming to Foobar. Body: ${in.body}")
                .setBody(exchange -> exchange.getIn().getBody(String.class) + " foo ")
                .to("direct:Bar");
    }
}
