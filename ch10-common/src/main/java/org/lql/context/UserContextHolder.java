package org.lql.context;

import org.lql.vo.User;

/**
 * Title: UserContextHolder <br>
 * ProjectName: spring-cloud-example <br>
 * description: 用户上下文 <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/7/8 11:48 <br>
 */
public class UserContextHolder {

    public static ThreadLocal<User> context = new ThreadLocal<User>();

    public static User currentUser() {
        return context.get();
    }

    public static void set(User user) {
        context.set(user);
    }

    public static void shutdown() {
        context.remove();
    }
}
