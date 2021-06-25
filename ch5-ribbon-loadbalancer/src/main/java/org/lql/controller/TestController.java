package org.lql.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Title: TestController <br>
 * ProjectName: spring-cloud-example <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/6/25 11:42 <br>
 */
@RestController
public class TestController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("add")
    public String add(Integer a, Integer b) {
        String result = restTemplate.getForObject("http://CLIENT-A/add?a=" + a + "&b=" + b, String.class);

        System.out.println(result);
        return result;
    }
}
