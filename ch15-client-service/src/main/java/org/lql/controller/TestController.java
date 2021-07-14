package org.lql.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * Title: TestController <br>
 * ProjectName: spring-cloud-example <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/7/14 15:15 <br>
 */
@RestController
public class TestController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/test")
    public String test(HttpServletRequest request) {
        System.out.println("--------------success access test method---------------");
        Enumeration headerNames = request.getHeaderNames();

        while (headerNames.hasMoreElements()) {
            String key = (String) headerNames.nextElement();
            System.out.println(key + ":" + request.getHeaders(key));
        }

        return "success access test method";
    }

    @GetMapping("/accessProvider")
    public String accessProvider(HttpServletRequest request) {
        String result = restTemplate.getForObject("http://provider-service/provider/test", String.class);
        return result;
    }
}
