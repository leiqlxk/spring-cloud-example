package org.lql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Title: Provider4Application <br>
 * ProjectName: spring-cloud-example <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/6/24 15:01 <br>
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Provider4Application {

    public static void main(String[] args) {
        SpringApplication.run(Provider4Application.class, args);
    }
}
