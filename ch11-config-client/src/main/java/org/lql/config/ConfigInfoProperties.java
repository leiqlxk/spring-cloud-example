package org.lql.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * Title: ConfigInfoProperties <br>
 * ProjectName: spring-cloud-example <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/7/13 17:41 <br>
 */
@Component
// 此注解修饰的Bean都是延迟加载的，只有在第一次访问时才会被初始化，刷新Bean也是同理
@RefreshScope
@ConfigurationProperties(prefix = "cn.springcloud.book")
public class ConfigInfoProperties {

    private String config;

    public String getConfig() {
        return config;
    }

    public void setConfig(String config) {
        this.config = config;
    }
}
