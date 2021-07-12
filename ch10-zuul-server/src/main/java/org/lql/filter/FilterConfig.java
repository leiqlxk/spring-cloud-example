package org.lql.filter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.logging.Filter;

/**
 * Title: FilterConfig <br>
 * ProjectName: spring-cloud-example <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/7/12 16:29 <br>
 */
@Configuration
public class FilterConfig {

    @Bean
    public AuthFilter getAuthFilter() {
        return new AuthFilter();
    }
}
