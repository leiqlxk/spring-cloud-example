package org.lql.config;

import com.netflix.discovery.util.StringUtil;
import org.lql.dao.PropertiesDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.RefreshableRouteLocator;
import org.springframework.cloud.netflix.zuul.filters.SimpleRouteLocator;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.util.StringUtils;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Title: DynamicZuulRouteLocator <br>
 * ProjectName: spring-cloud-example <br>
 * description: 动态路由核心类 <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/7/5 11:24 <br>
 */
public class DynamicZuulRouteLocator extends SimpleRouteLocator implements RefreshableRouteLocator {

    @Autowired
    private ZuulProperties zuulProperties;

    @Autowired
    private PropertiesDao propertiesDao;

    public DynamicZuulRouteLocator(String servletPath, ZuulProperties properties) {
        super(servletPath, properties);

        this.zuulProperties = properties;
    }


    @Override
    public void refresh() {
        doRefresh();
    }

    @Override
    protected Map<String, ZuulProperties.ZuulRoute> locateRoutes() {
        LinkedHashMap<String, ZuulProperties.ZuulRoute> routesMap = new LinkedHashMap<>();
        routesMap.putAll(super.locateRoutes());
        routesMap.putAll(propertiesDao.getProperties());

        LinkedHashMap<String, ZuulProperties.ZuulRoute> values = new LinkedHashMap<>();
        routesMap.forEach((key, value) -> {
            String path = key;
            if (!path.startsWith("/")) {
                path = "/" + path;
            }

            if (StringUtils.hasText(this.zuulProperties.getPrefix())) {
                path = this.zuulProperties.getPrefix() + path;
                if (!path.startsWith("/")) {
                    path = "/" + path;
                }
            }

            values.put(path, value);
        });

        return values;
    }
}
