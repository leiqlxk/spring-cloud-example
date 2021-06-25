package org.lql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Title: Ribbon5Application <br>
 * ProjectName: spring-cloud-example <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/6/25 11:34 <br>
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Ribbon5Application {

    public static void main(String[] args) {
        SpringApplication.run(Ribbon5Application.class, args);
    }

    /**
     * description: 注入RestTemplate的Bean，并且添加@LoadBalanced声明该RestTemplate用于负载均衡
     * ribbon默认采用轮询方式，并且其对服务实例节点的增减也能动态感知<br>
     *
     * @author: leiql <br>
     * @version: 1.0 <br>
     * @since: 2021/6/25 11:36 <br>
     * 
     * @throws
     * @param 
     * @return org.springframework.web.client.RestTemplate
     */ 
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
