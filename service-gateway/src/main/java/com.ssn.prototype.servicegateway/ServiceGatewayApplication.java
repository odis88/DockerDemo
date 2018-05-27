package com.ssn.prototype.servicegateway;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class ServiceGatewayApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(ServiceGatewayApplication.class).run(args);
    }

}
