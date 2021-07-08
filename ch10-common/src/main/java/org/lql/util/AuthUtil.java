package org.lql.util;

import org.apache.commons.lang.StringUtils;
import org.lql.vo.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Title: AuthUtil <br>
 * ProjectName: spring-cloud-example <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/7/8 11:36 <br>
 */
public class AuthUtil {

    public static boolean authUser(User user, HttpServletResponse response) throws Exception {
        if (StringUtils.isEmpty(user.getUserId())) {
            return false;
        }else {
            return true;
        }
    }
}
