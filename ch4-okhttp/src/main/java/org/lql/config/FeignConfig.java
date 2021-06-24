package org.lql.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Title: FeignConfig <br>
 * ProjectName: spring-cloud-example <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/6/24 13:52 <br>
 */
@Configuration
public class FeignConfig {

    @Bean
    Logger.Level feignLoggerLevlel() {
        return Logger.Level.FULL;
    }
}
