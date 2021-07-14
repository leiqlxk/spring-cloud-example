package org.lql.controller;

import brave.propagation.ExtraFieldPropagation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Title: ProviderController <br>
 * ProjectName: spring-cloud-example <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/7/14 16:46 <br>
 */
@RestController
public class ProviderController {

    private static final Logger log = LoggerFactory.getLogger(ProviderController.class);

    @GetMapping("/sayHello")
    public String hello(String name){
        log.info("server received. 参数: {}",name);
        String result = "hello, "+name + ", SessionId is " + ExtraFieldPropagation.get("SessionId");
        log.info("server sent. 结果: {}",result);
        return result;
    }
}
