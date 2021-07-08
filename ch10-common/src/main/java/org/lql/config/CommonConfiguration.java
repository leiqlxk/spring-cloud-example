package org.lql.config;

import feign.Feign;
import org.lql.context.SpringCloudHystrixConcurrencyStrategy;
import org.lql.intercepter.FeignUserContextInterceptor;
import org.lql.intercepter.RestTemplateUserContextInterceptor;
import org.lql.intercepter.UserContextInterceptor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Title: CommonConfiguration <br>
 * ProjectName: spring-cloud-example <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/7/8 21:59 <br>
 */
@Configuration
@EnableWebMvc
public class CommonConfiguration extends WebMvcConfigurerAdapter {
    /**
     * 请求拦截器
	 */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new UserContextInterceptor());
    }

    /**
     * 创建Feign请求拦截器，在发送请求前设置认证的用户上下文信息
     */
    @Bean
    @ConditionalOnClass(Feign.class)
    public FeignUserContextInterceptor feignTokenInterceptor() {
        return new FeignUserContextInterceptor();
    }

    /**
     * RestTemplate拦截器
     * @return
     */
    @LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getInterceptors().add(new RestTemplateUserContextInterceptor());
        return restTemplate;
    }

    @Bean
    public SpringCloudHystrixConcurrencyStrategy springCloudHystrixConcurrencyStrategy() {
        return new SpringCloudHystrixConcurrencyStrategy();
    }
}
