package org.lql.feign.fallback;

import org.lql.feign.IUserService;
import org.springframework.stereotype.Component;

/**
 * Title: UserServiceFallback <br>
 * ProjectName: spring-cloud-example <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/6/30 17:21 <br>
 */
@Component
public class UserServiceFallback implements IUserService {

    /**
     * description: 出错则调用该方法返回友好错误 <br>
     *
     * @author: leiql <br>
     * @version: 1.0 <br>
     * @since: 2021/6/30 17:28 <br>
     *
     * @throws
     * @param username
     * @return java.lang.String
     */
    @Override
    public String getUser(String username) {
        return "The user does not exist in this system,please confirm username";
    }
}
