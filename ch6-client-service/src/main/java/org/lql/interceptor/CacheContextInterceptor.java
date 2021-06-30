package org.lql.interceptor;

import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Title: CacheContextInterceptor <br>
 * ProjectName: spring-cloud-example <br>
 * description: Hystrix的缓存在一次请求内有效，这要求请求在一个Hystrix上下文里，不然在使用缓存的时候
 * Hystrix会报一个没有初始化上下围的错误，可以使用filter过滤器或Interceptor拦截器进行初始化<br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/6/30 21:36 <br>
 */
public class CacheContextInterceptor implements HandlerInterceptor {

    private HystrixRequestContext context;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        context = HystrixRequestContext.initializeContext();
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        context.shutdown();
    }
}
