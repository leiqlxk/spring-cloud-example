package org.lql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Title: OkHttpApplication <br>
 * ProjectName: spring-cloud-example <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/6/24 13:53 <br>
 */
@SpringBootApplication
@EnableFeignClients
public class OkHttpApplication {

    public static void main(String[] args) {
        SpringApplication.run(OkHttpApplication.class, args);
    }
}
