package org.lql.config;

import com.netflix.discovery.EurekaClientConfig;
import com.netflix.eureka.EurekaServerConfig;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cloud.netflix.eureka.EurekaClientConfigBean;
import org.springframework.cloud.netflix.eureka.server.EurekaServerAutoConfiguration;
import org.springframework.cloud.netflix.eureka.server.EurekaServerConfigBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

/**
 * Title: RegionConfig <br>
 * ProjectName: spring-cloud-example <br>
 * description: 使用多region时使用，因为getRemoteRegionAppWhitelist(regionName)会直接调用remoteRegionAppWhitelist，其默认为null，因此如果不设置会报空指针 <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/6/21 13:46 <br>
 */
@Configuration
@AutoConfigureBefore(EurekaServerAutoConfiguration.class)
public class RegionConfig {

    @Bean
    @ConditionalOnMissingBean
    public EurekaServerConfig eurekaServerConfig(EurekaClientConfig clientConfig) {
        EurekaServerConfigBean serverConfig = new EurekaServerConfigBean();

        if (clientConfig.shouldRegisterWithEureka()) {
            serverConfig.setRegistrySyncRetries(5);
        }

        serverConfig.setRemoteRegionAppWhitelist(new HashMap<>());
        return serverConfig;
    }
}
