package org.lql.intercepter;

import org.lql.context.UserContextHolder;
import org.lql.util.HttpConvertUtil;
import org.lql.vo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Title: UserContextInterceptor <br>
 * ProjectName: spring-cloud-example <br>
 * description: 进入controller控制器时会拦截到请求，从header中解析出用户对象出入上下文中 <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/7/8 11:52 <br>
 */
public class UserContextInterceptor implements HandlerInterceptor {
    private static final Logger log = LoggerFactory.getLogger(UserContextInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        User user = new User(HttpConvertUtil.httpRequestToMap(request));
        if(StringUtils.isEmpty(user.getUserId()) && StringUtils.isEmpty(user.getUserName())) {
            log.error("the user is null, please access from gateway or check user info");
            return false;
        }
        UserContextHolder.set(user);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        UserContextHolder.shutdown();
    }
}
