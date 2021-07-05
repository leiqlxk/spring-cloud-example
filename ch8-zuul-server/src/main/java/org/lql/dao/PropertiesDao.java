package org.lql.dao;

import com.netflix.discovery.util.StringUtil;
import org.apache.commons.lang.StringUtils;
import org.lql.domain.ZuulRouteEntity;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Title: PropertiesDao <br>
 * ProjectName: spring-cloud-example <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/7/5 10:51 <br>
 */
@Repository
public class PropertiesDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final static String SQL = "SELECT * FROM zuul_route WHERE enabled = TRUE";

    public Map<String, ZuulProperties.ZuulRoute> getProperties() {
        Map<String, ZuulProperties.ZuulRoute> routes = new LinkedHashMap<>();

        List<ZuulRouteEntity> list = jdbcTemplate.query(SQL, new BeanPropertyRowMapper<>(ZuulRouteEntity.class));
        list.forEach(entity -> {
            if (StringUtils.isEmpty(entity.getPath())) {
                return;
            }

            ZuulProperties.ZuulRoute route = new ZuulProperties.ZuulRoute();
            BeanUtils.copyProperties(entity, route);

            routes.put(route.getPath(), route);
        });

        return routes;
    }
}
