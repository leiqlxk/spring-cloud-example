package org.lql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Title: SleuthComsumerApplication <br>
 * ProjectName: spring-cloud-example <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/7/14 16:41 <br>
 */
@SpringBootApplication
@EnableFeignClients
public class SleuthComsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SleuthComsumerApplication.class, args);
    }
}
