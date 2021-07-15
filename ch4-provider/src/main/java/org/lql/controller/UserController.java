package org.lql.controller;


import org.lql.domain.User;
import org.springframework.web.bind.annotation.*;

import java.nio.channels.ClosedSelectorException;

/**
 * Title: UserController <br>
 * ProjectName: spring-cloud-example <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/6/24 14:57 <br>
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addUser(User user) {
        return "hello, " + user.getName();
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateUser(@RequestBody User user) {
        return  "hello, " + user.getName();
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(@RequestParam String name) {
        return "hello, " + name;
    }
}
