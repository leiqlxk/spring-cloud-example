package org.lql.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.lql.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * Title: UserService <br>
 * ProjectName: spring-cloud-example <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/6/30 16:56 <br>
 */
@Service
public class UserService implements IUserService {

    @Override
    @HystrixCommand(fallbackMethod = "defaultUser")
    public String getUser(String username) throws Exception {
        if (username.equals("spring")) {
            return "this is real user";
        }else {
            throw new Exception();
        }
    }

    /**
     * description: 出错则调用该方法返回预设友好错误 <br>
     *
     * @author: leiql <br>
     * @version: 1.0 <br>
     * @since: 2021/6/30 16:59 <br>
     *
     * @throws
     * @param username
     * @return java.lang.String
     */
    public String defaultUser(String username) {
        return "The user does not exist in this system";
    }
}
