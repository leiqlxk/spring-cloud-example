package org.lql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Title: HttpclientApplication <br>
 * ProjectName: spring-cloud-example <br>
 * description: 使用http client替换默认客户端 <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/6/24 11:10 <br>
 */
@SpringBootApplication
@EnableFeignClients
public class HttpclientApplication {

    public static void main(String[] args) {
        SpringApplication.run(HttpclientApplication.class, args);
    }
}
