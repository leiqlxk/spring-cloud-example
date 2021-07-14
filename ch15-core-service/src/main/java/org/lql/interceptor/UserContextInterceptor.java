package org.lql.interceptor;

import com.alibaba.fastjson.JSON;
import org.lql.exception.PermissionException;
import org.lql.util.UserPermissionUtil;
import org.lql.vo.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Title: UserContextInterceptor <br>
 * ProjectName: spring-cloud-example <br>
 * description: 服务拦截器，在进入控制器前进行校验 <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/7/14 14:36 <br>
 */
public class UserContextInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        User user = getUser(request);
        UserPermissionUtil.permission(user);
        if (!UserPermissionUtil.verify(user, request)) {
            response.setHeader("Content-Type",  "application/json");
            String jsonstr = JSON.toJSONString("no permission access service, please check");
            response.getWriter().write(jsonstr);
            response.getWriter().flush();
            response.getWriter().close();
            throw new PermissionException("no permission access service, please check");
        }
        UserContextHolder.set(user);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        UserContextHolder.shutdown();
    }

    private User getUser(HttpServletRequest request) {
        String userId = request.getHeader("x-user-id");
        String userName = request.getHeader("x-user-name");

        User user = new User();
        user.setUserId(userId);
        user.setUserName(userName);
        return user;
    }
}
