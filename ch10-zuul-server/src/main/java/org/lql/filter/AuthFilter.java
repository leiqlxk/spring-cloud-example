package org.lql.filter;

import com.alibaba.fastjson.JSONObject;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import org.apache.commons.lang.StringUtils;
import org.lql.ZuulServiceApplication;
import org.lql.exception.BaseException;
import org.lql.exception.BaseExceptionBody;
import org.lql.exception.CommonError;
import org.lql.vo.User;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * Title: AuthFilter <br>
 * ProjectName: spring-cloud-example <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/7/8 23:12 <br>
 */
public class AuthFilter extends ZuulFilter {
    private static final Logger logger = LoggerFactory.getLogger(AuthFilter.class);

    @Override
    public boolean shouldFilter() {
        // 判断是否需要进行处理
        return true;
    }

    @Override
    public Object run() {
        RequestContext rc = RequestContext.getCurrentContext();
        authUser(rc);
        return null;
    }

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    private static Map<String, String> httpRequestToMap(HttpServletRequest request) {
        Enumeration<String> headerNames = request.getHeaderNames();
        Map<String, String> headers = new HashMap<>();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            headers.put(headerName, request.getHeader(headerName));
        }
        return headers;
    }

    /**
     * 将用户信息保存到头部往下传递
     * @param ctx
     */
    public static void authUser(RequestContext ctx) {
        HttpServletRequest request = ctx.getRequest();
        Map<String, String> header = httpRequestToMap(request);
        String userId = header.get(User.CONTEXT_KEY_USERID);
        if(StringUtils.isEmpty(userId)) {
            try {
                BaseException BaseException = new BaseException(CommonError.AUTH_EMPTY_ERROR.getCode(),CommonError.AUTH_EMPTY_ERROR.getCodeEn(),CommonError.AUTH_EMPTY_ERROR.getMessage(),1L);
                BaseExceptionBody errorBody = new BaseExceptionBody(BaseException);
                ctx.setSendZuulResponse(false);
                ctx.setResponseStatusCode(401);
                ctx.setResponseBody(JSONObject.toJSON(errorBody).toString());
            } catch (Exception e) {
                logger.error("println message error",e);
            }
        }else {
            for (Map.Entry<String, String> entry : header.entrySet()) {
                ctx.addZuulRequestHeader(entry.getKey(), entry.getValue());
            }
        }
    }
}
