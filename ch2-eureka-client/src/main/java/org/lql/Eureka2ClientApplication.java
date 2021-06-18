package org.lql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Title: Eureka2ClientApplication <br>
 * ProjectName: spring-cloud-example <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/6/18 11:24 <br>
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Eureka2ClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(Eureka2ClientApplication.class);
    }
}
