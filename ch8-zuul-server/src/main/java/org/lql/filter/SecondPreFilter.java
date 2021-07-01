package org.lql.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

/**
 * Title: SecondPreFilter <br>
 * ProjectName: spring-cloud-example <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/7/1 15:30 <br>
 */
public class SecondPreFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 2;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        System.out.println("这是SecondPreFilter！");
        // 从RequestContext中获取上下文
        RequestContext context = RequestContext.getCurrentContext();

        // 从上下文中获取HttpServletRequest
        HttpServletRequest request = context.getRequest();

        // 从request中获取参数a
        String a = request.getParameter("a");

        // 如果a参数值为空则进入此逻辑
        if (a == null) {
            // 对该请求禁止路由，也就是禁止访问下游服务
            context.setSendZuulResponse(false);
            // 设定responseBody供PostFilter使用
            context.setResponseBody("{\"status\":500,\"message\":\"a参数为空!\"}");
            // logic-is-success保存于上下文，作为同类型下游Filter的执行开关
            context.set("logic-is-success", false);
            // 到此结束
            return null;
        }

        // 设置避免报空
        context.set("logic-is-success", true);
        return null;
    }
}
