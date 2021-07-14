package org.lql.config;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.instrument.async.TraceableExecutorService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Title: ConsumerConfiguration <br>
 * ProjectName: spring-cloud-example <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/7/14 16:23 <br>
 */
@Configuration
public class ConsumerConfiguration {

    @Autowired
    BeanFactory beanFactory;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    // 简单起见，使用固定大小的线程池
    public ExecutorService executorService() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        return new TraceableExecutorService(this.beanFactory, executorService);
    }
}
