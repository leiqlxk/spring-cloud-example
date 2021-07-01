package org.lql.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.POST_TYPE;

/**
 * Title: FirstPostFilter <br>
 * ProjectName: spring-cloud-example <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/7/1 15:44 <br>
 */
public class FirstPostFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return POST_TYPE;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        System.out.println("这是FirstPostFilter！");
        RequestContext context = RequestContext.getCurrentContext();
        // 处理返回中文乱码
        context.getResponse().setCharacterEncoding("UTF-8");
        // 获取ResponseBody
        String responseBody = context.getResponseBody();
        // 如果responseBody不为空，则说明流程有异常发生
        if (responseBody != null) {
            // 设定返回状态码
            context.setResponseStatusCode(500);
            // 替换响应报文
            context.setResponseBody(responseBody);
        }
        return null;
    }
}
