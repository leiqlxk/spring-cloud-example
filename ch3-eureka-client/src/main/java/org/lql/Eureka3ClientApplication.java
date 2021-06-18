package org.lql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Title: Eureka3ClientApplication <br>
 * ProjectName: spring-cloud-example <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/6/18 13:37 <br>
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Eureka3ClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(Eureka3ClientApplication.class);
    }
}
