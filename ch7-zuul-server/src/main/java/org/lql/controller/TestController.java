package org.lql.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Title: TestController <br>
 * ProjectName: spring-cloud-example <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/7/1 14:10 <br>
 */
@RestController
public class TestController {

    @GetMapping("/client")
    public String add(Integer a, Integer b) {
        return "本地跳转：" + (a + b);
    }
}
