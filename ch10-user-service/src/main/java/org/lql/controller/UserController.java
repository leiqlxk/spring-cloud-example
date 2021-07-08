package org.lql.controller;

import org.lql.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Title: UserController <br>
 * ProjectName: spring-cloud-example <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/7/8 11:18 <br>
 */
@RestController
public class UserController {

    @Autowired
    private IUserService userService;

    /**
     * 获取配置文件中系统默认用户
     */
    @GetMapping("/getDefaultUser")
    public String getDefaultUser() {
        return userService.getDefaultUser();
    }

    /**
     * 获取上下文用户
     */
    @GetMapping("/getContextUserId")
    public String getContextUserId() {
        return userService.getContextUserId();
    }

    /**
     * 获取供应商数据
     */
    @GetMapping("/getProviderData")
    public List<String> getProviderData() {
        return userService.getProviderData();
    }
}
