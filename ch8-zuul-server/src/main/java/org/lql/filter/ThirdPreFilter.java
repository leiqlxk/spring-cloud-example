package org.lql.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.sun.org.apache.regexp.internal.RE;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

/**
 * Title: ThirdPreFilter <br>
 * ProjectName: spring-cloud-example <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/7/1 15:31 <br>
 */
public class ThirdPreFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 3;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext context = RequestContext.getCurrentContext();

        return (boolean) context.get("logic-is-success");
    }

    @Override
    public Object run() throws ZuulException {

        System.out.println("这是ThirdPreFilter！");
        RequestContext context = RequestContext.getCurrentContext();

        HttpServletRequest request = context.getRequest();
        String b = request.getParameter("b");

        if (b == null) {
            context.setSendZuulResponse(false);
            context.setResponseBody("{\"status\":500,\"message\":\"b参数为空！\"}");
            context.set("logic-is-success", false);
        }

        context.set("logic-is-success", true);
        return null;
    }
}
