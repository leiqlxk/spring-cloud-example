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
 * @since: 2021/7/1 13:44 <br>
 */
@RestController
public class TestController {

    @GetMapping("/add")
    public Integer add(Integer a, Integer b) {
        return a + b;
    }

    @GetMapping("/a/add")
    public Integer aadd(Integer a, Integer b){
        return a + b;
    }

    @GetMapping("/sub")
    public Integer sub(Integer a, Integer b){
        return a - b;
    }

    @GetMapping("/mul")
    public String mul(Integer a, Integer b){
        return "client-a-" + a * b;
    }

    @GetMapping("/div")
    public Integer div(Integer a, Integer b){
        return a / b;
    }
}
