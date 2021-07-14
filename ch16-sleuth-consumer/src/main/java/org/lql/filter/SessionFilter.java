package org.lql.filter;

import brave.propagation.ExtraFieldPropagation;
import org.springframework.cloud.sleuth.instrument.web.SleuthWebProperties;
import org.springframework.cloud.sleuth.instrument.web.TraceWebServletAutoConfiguration;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Pattern;

/**
 * Title: SessionFilter <br>
 * ProjectName: spring-cloud-example <br>
 * description: 自定义过滤器
 * 获取当前的sessionId，放入Baggage中
 * 因为不是所有请求都需要往后传递，所以会多一些请求跳过执行<br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/7/14 16:59 <br>
 */
@Component
@Order(TraceWebServletAutoConfiguration.TRACING_FILTER_ORDER + 1)
public class SessionFilter extends GenericFilterBean {
    private Pattern skipPatter = Pattern.compile(SleuthWebProperties.DEFAULT_SKIP_PATTERN);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        if (!(request instanceof HttpServletRequest) || !(response instanceof HttpServletResponse)) {
            throw new ServletException("Filter just supports HTTP requests");
        }

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        boolean skip = skipPatter.matcher(httpServletRequest.getRequestURI()).matches();

        if (!skip) {
            // 将sessionId放到baggage中
            ExtraFieldPropagation.set("SessionId", httpServletRequest.getSession().getId());
        }

        filterChain.doFilter(request, response);
    }
}
