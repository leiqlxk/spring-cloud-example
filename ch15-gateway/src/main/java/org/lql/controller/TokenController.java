package org.lql.controller;

import org.lql.util.JwtUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Title: TokenController <br>
 * ProjectName: spring-cloud-example <br>
 * description: 模拟客户获取到token的国产 <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/7/14 15:32 <br>
 */
@RestController
public class TokenController {

    @GetMapping("/getToken/{name}")
    public String get(@PathVariable("name") String name) {
        return JwtUtil.generateToken(name);
    }
}
