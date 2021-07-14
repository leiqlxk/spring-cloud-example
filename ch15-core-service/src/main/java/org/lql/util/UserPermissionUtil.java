package org.lql.util;

import org.apache.commons.lang.StringUtils;
import org.lql.vo.User;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Title: UserPermissionUtil <br>
 * ProjectName: spring-cloud-example <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/7/14 14:28 <br>
 */
public class UserPermissionUtil {

    /**
     * 模拟权限校验, 可以根据自己项目需要定制不同的策略,如查询数据库获取具体的菜单url或者角色等等.
     */
    public static boolean verify(User user, HttpServletRequest request) {
        String url = request.getHeader("x-user-serviceName");
        if (StringUtils.isEmpty(url)) {
            return  false;
        }else {
            List<String> str = user.getAllowPermissionService();
            for (String s : str) {
                if (url.equalsIgnoreCase(s)) {
                    return true;
                }
            }
            return false;
        }
    }

    /**
     * 模拟权限赋值, 可以根据自己项目需要定制不同的策略,如查询数据库获取具体的菜单url或者角色等等.
     */
    public static void permission(User user) {
        if (user.getUserName().equals("admin")) {
            List<String> allowPermissionService = new ArrayList();
            allowPermissionService.add("client-service");
            allowPermissionService.add("provider-service");
            user.setAllowPermissionService(allowPermissionService);
        }else if (user.getUserName().equals("spring")){
            List<String> allowPermissionService = new ArrayList();
            allowPermissionService.add("client-service");
            user.setAllowPermissionService(allowPermissionService);
        }else {
            List<String> allowPermissionService = new ArrayList();
            user.setAllowPermissionService(allowPermissionService);
        }
    }
}
