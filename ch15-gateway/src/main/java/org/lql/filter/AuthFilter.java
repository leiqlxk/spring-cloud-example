package org.lql.filter;

import org.lql.exception.PermissionException;
import org.lql.util.JwtUtil;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.support.ServerWebExchangeUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.Map;

/**
 * Title: AuthFilter <br>
 * ProjectName: spring-cloud-example <br>
 * description: 添加GlobalFilter过滤所有的请求，对JWT token进行解析校验，并转换成系统内部的Token，并把路由的服务名也加入header，送往接下来的服务里，方便鉴权 <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/7/14 14:10 <br>
 */
public class AuthFilter implements GlobalFilter {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        Route gatewayUrl = exchange.getRequiredAttribute(ServerWebExchangeUtils.GATEWAY_ROUTE_ATTR);
        URI uri = gatewayUrl.getUri();
        ServerHttpRequest request = (ServerHttpRequest) exchange.getRequest();
        HttpHeaders httpHeaders = request.getHeaders();
        String token = httpHeaders.getFirst(JwtUtil.HEADER_AUTH);
        Map<String, String> map = JwtUtil.validateToken(token);
        ServerHttpRequest.Builder mutate = request.mutate();
        if (map.get("user").equals("admin") || map.get("user").equals("spring") || map.get("user").equals("cloud")) {
            mutate.header("x-user-id", map.get("id"));
            mutate.header("x-user-name", map.get("user"));
            mutate.header("x-user-serviceName", uri.getHost());
        }else {
            throw new PermissionException("user not exist, please check");
        }

        ServerHttpRequest buildRequest = mutate.build();
        return chain.filter(exchange.mutate().request(buildRequest).build());
    }
}
