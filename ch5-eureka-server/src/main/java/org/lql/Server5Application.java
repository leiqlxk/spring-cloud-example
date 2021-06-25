package org.lql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Title: Server5Application <br>
 * ProjectName: spring-cloud-example <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/6/25 10:44 <br>
 */
@SpringBootApplication
@EnableEurekaServer
public class Server5Application {

    public static void main(String[] args) {
        SpringApplication.run(Server5Application.class, args);
    }
}
