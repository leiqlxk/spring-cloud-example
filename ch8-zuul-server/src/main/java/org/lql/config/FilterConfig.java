package org.lql.config;

import org.lql.filter.FirstPostFilter;
import org.lql.filter.FirstPreFilter;
import org.lql.filter.SecondPreFilter;
import org.lql.filter.ThirdPreFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Title: FilterConfig <br>
 * ProjectName: spring-cloud-example <br>
 * description: 过滤器配置类 <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/7/1 15:21 <br>
 */
@Configuration
public class FilterConfig {
/*
    @Bean
    public FirstPreFilter firstPreFilter() {
        return new FirstPreFilter();
    }

    @Bean
    public SecondPreFilter secondPreFilter() {
        return new SecondPreFilter();
    }

    @Bean
    public ThirdPreFilter thirdPreFilter() {
        return new ThirdPreFilter();
    }

    @Bean
    public FirstPostFilter firstPostFilter() {
        return new FirstPostFilter();
    }*/
}
