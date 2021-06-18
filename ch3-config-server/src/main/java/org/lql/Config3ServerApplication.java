package org.lql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Title: Config3ServerApplication <br>
 * ProjectName: spring-cloud-example <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/6/18 14:59 <br>
 */
@SpringBootApplication
@EnableConfigServer
public class Config3ServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(Config3ServerApplication.class, args);
    }
}
