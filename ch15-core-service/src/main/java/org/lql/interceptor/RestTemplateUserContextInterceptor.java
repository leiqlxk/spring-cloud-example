package org.lql.interceptor;

import org.lql.vo.User;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

/**
 * Title: RestTemplateUserContextInterceptor <br>
 * ProjectName: spring-cloud-example <br>
 * description: restTemplate拦截器用于调用时传递用户信息 <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/7/14 14:49 <br>
 */
public class RestTemplateUserContextInterceptor implements ClientHttpRequestInterceptor {


    @Override
    public ClientHttpResponse intercept(HttpRequest httpRequest, byte[] bytes, ClientHttpRequestExecution clientHttpRequestExecution) throws IOException {
        User user = UserContextHolder.currentUser();
        httpRequest.getHeaders().add("x-user-id",user.getUserId());
        httpRequest.getHeaders().add("x-user-name",user.getUserName());
        httpRequest.getHeaders().add("x-user-serviceName",httpRequest.getURI().getHost());
        return clientHttpRequestExecution.execute(httpRequest, bytes);
    }
}
