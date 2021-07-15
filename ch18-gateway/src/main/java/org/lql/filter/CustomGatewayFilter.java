package org.lql.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.core.Ordered;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * Title: CustomGatewayFilter <br>
 * ProjectName: spring-cloud-example <br>
 * description: 自定义GatewayFilter统计某个或者某种路由的网关处理时长
 * GatewayFilter用于处理某个或某组路由
 * GlobalFilter会被引用到所有的路由上<br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/7/15 14:36 <br>
 */
public class CustomGatewayFilter implements GatewayFilter, Ordered {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomGatewayFilter.class);
    private static final String COUNT_START_TIME = "countStartTime";

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        exchange.getAttributes().put(CustomGatewayFilter.COUNT_START_TIME, System.currentTimeMillis());
        return chain.filter(exchange).then(
                Mono.fromRunnable(() -> {
                    Long startTime = exchange.getAttribute(CustomGatewayFilter.COUNT_START_TIME);
                    Long endTime = (System.currentTimeMillis() - startTime);
                    if (startTime != null) {
                        LOGGER.info(exchange.getRequest().getURI().getRawPath() + ":" + endTime + "ms");
                    }
                })
        );
    }

    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE;
    }
}
