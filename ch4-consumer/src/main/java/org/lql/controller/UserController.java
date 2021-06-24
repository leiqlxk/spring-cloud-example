package org.lql.controller;

import io.swagger.annotations.ApiParam;
import org.lql.domain.User;
import org.lql.service.UserFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Title: UserController <br>
 * ProjectName: spring-cloud-example <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/6/24 14:38 <br>
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserFeignService userFeignService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addUser(@RequestBody @ApiParam(name = "用户", value = "传入json格式", required = true) User user){
        return userFeignService.addUser(user);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateUser(@RequestBody @ApiParam(name = "用户", value = "传入json格式", required = true) User user) {
        return userFeignService.updateUser(user);
    }
}
