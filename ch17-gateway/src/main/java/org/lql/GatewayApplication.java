package org.lql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.codec.ServerCodecConfigurer;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * Title: GatewayApplication <br>
 * ProjectName: spring-cloud-example <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/7/15 10:28 <br>
 */
@SpringBootApplication
public class GatewayApplication {

    @Bean
    // gateway支持两种方式配置路由信息，此为java流式API自定义RouteLocator的方式自定义gateway的路由信息，也可以在yml文件的方式配置
    public RouteLocator cunstomRouteLocator(RouteLocatorBuilder builder) {
        // 生成比当前时间早一个小时的UTC时间
        ZonedDateTime minusTime = LocalDateTime.now().minusHours(1).atZone(ZoneId.systemDefault());

        // 生成比当前时间迟一个小时的UTC时间
        ZonedDateTime plusTime = LocalDateTime.now().plusHours(1).atZone(ZoneId.systemDefault());
        return builder.routes()
                // basic proxy
                .route(r -> r.path("/jd").uri("http://jd.com:80/").id("jd_route"))
                // After Route Predicate Factory中会取一个UTC时间格式的参数，当请求进来的当前时间在配置的UTC时间之后，则会成功匹配，否则不能成功匹配
//                .route("after_route", r -> r.after(minusTime).uri("http://baidu.com"))
                // Before Route Predicate Factory中会取一个UTC时间格式的参数，当请求进来的当前时间在配置的UTC时间之前，则会成功匹配，否则不能成功匹配
                .route("before_route", r -> r.before(plusTime).uri("http://baidu.com"))
//                .route("between_route", r -> r.between(minusTime, plusTime).uri("http://baidu.com"))
//                .route("cookie_route", r -> r.cookie("chocolate", "ch.p").uri("http://localhost:8071/test/cookie"))
//                .route("header_route", r -> r.header("X-Request-Id", "xujin").uri("http://localhost:8071/test/head"))
//                .route("host_route", r -> r.host("**.baidu.com:8080").uri("http://jd.com"))
//                .route("method_route", r -> r.method("GET").uri("http://jd.com"))
//                .route("query_route", r -> r.query("foo", "baz").uri("http://baidu.com"))
//                .route("remoteaddr_route", r -> r.remoteAddr("127.0.0.1").uri("http://baidu.com"))
                // AddRequestHeader过滤器工厂用于对匹配上的请求加上header
                .route("add_request_header_route", r -> r.path("/test")
                        .filters(f -> f.addRequestHeader("X-Request-Acme", "ValueB"))
                        .uri("http://localhost:8071/test/head"))
                // AddRequestParameter过滤器是对匹配上的请求路由添加请求参数
                .route("add_request_parameter_route", r -> r.path("/addRequestParameter")
                        .filters(f -> f.addRequestParameter("example", "ValueB"))
                        .uri("http://localhost:8071/test/addRequestParameter"))
                // 去除前缀/foo
                .route("rewritepath_rote", r -> r.path("/foo/**")
                        .filters(f -> f.rewritePath("/foo/(?<segment>.*)", "/$\\{segment}"))
                        .uri("http://www.baidu.com"))
                // 在响应头中添加内容
                .route("add_response_header_route", r -> r.path("/test")
                        .filters(f -> f.addResponseHeader("X-Response-Foo", "Bar"))
                        .uri("http://www.baidu.com"))
                // Retry过滤器设置重试次数为2次，当代理服务调用失败时设置状态码为500，即服务器内部错误
                .route("retry_route", r -> r.path("/test/retry")
                        .filters(f -> f.retry(config -> config.setRetries(2).setStatuses(HttpStatus.INTERNAL_SERVER_ERROR)))
                        .uri("http://localhost:8071/retry?key=abc&count=2"))
                .build();
    }

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }
}
