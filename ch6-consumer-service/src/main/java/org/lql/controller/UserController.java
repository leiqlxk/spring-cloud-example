package org.lql.controller;


import org.lql.feign.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Title: UserController <br>
 * ProjectName: spring-cloud-example <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/6/30 17:12 <br>
 */
@RestController
public class UserController {

    @Autowired
    private IUserService userService;


    @GetMapping("/getUser")
    public String getUser(String username) throws Exception {
        return userService.getUser(username);
    }
}
