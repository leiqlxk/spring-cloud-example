package org.lql.config;

import org.lql.dao.PropertiesDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Title: DynamicZuulConfig <br>
 * ProjectName: spring-cloud-example <br>
 * description: 动态路由配置类 <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/7/5 11:33 <br>
 */
@Configuration
public class DynamicZuulConfig {

    @Autowired
    private ZuulProperties zuulProperties;

    @Autowired
    private ServerProperties serverProperties;

    @Bean
    public DynamicZuulRouteLocator routeLocator() {
        DynamicZuulRouteLocator routeLocator = new DynamicZuulRouteLocator(serverProperties.getServlet().getServletPrefix(), zuulProperties);

        return routeLocator;
    }
}
