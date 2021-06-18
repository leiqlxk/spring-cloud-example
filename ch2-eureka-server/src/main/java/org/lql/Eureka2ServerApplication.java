package org.lql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Title: org.lql.Eureka2ServerApplication <br>
 * ProjectName: spring-cloud-example <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/6/18 11:15 <br>
 */
@SpringBootApplication
@EnableEurekaServer
public class Eureka2ServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(Eureka2ServerApplication.class);
    }
}
