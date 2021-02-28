package com.github.golandec93.camelboy.provingground.spring.boot.rest;

import org.apache.camel.CamelContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController("restcontroller")
public class SampleRestController {

    @Autowired
    private CamelContext camelContext;

    @RequestMapping(method = {GET, POST, PUT}, path = "echo")
    public String echo(@RequestBody String body) {
        return body;
    }

    @RequestMapping(method = {GET, POST, PUT}, path = "foo", consumes = "*/*")
    public Object foo(final HttpServletRequest request,
                      final @RequestBody String body) {
        var headers = StreamSupport.stream(
                Spliterators.spliteratorUnknownSize(
                        request.getHeaderNames().asIterator(),
                        Spliterator.ORDERED),
                false)
                .collect(Collectors.toMap(
                        headerName -> headerName,
                        headerName -> (Object) Collections.list(request.getHeaders(headerName))));
        return camelContext.createProducerTemplate().requestBodyAndHeaders("direct:Foobar", body, headers);
    }


}
