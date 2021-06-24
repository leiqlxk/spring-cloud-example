package org.lql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Title: Consumer4SpringApplication <br>
 * ProjectName: spring-cloud-example <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/6/24 14:16 <br>
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class Consumer4SpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(Consumer4SpringApplication.class, args);
    }
}
