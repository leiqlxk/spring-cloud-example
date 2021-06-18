package org.lql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * Title: Zuul3GatewayApplication <br>
 * ProjectName: spring-cloud-example <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/6/18 16:45 <br>
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class Zuul3GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(Zuul3GatewayApplication.class, args);
    }
}
