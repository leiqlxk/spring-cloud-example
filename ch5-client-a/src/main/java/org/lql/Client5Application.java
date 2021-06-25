package org.lql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Title: Client5Application <br>
 * ProjectName: spring-cloud-example <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/6/25 11:12 <br>
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Client5Application {

    public static void main(String[] args) {
        SpringApplication.run(Client5Application.class, args);
    }
}
