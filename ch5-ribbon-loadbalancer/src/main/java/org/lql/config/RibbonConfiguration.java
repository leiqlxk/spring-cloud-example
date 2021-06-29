package org.lql.config;

import com.netflix.client.IClient;
import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.lql.annotiation.AvoidScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Title: RibbonConfiguration <br>
 * ProjectName: spring-cloud-example <br>
 * description: 针对某一个源服务设置其特有的策略 <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/6/29 16:43 <br>
 */
@Configuration
@AvoidScan
public class RibbonConfiguration {

    @Autowired
    IClientConfig clientConfig;

    @Bean
    public IRule ribbonRule(IClientConfig clientConfig) {
        return new RandomRule();
    }
}
