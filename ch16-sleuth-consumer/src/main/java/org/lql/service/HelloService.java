package org.lql.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.xml.ws.RequestWrapper;

/**
 * Title: HelloService <br>
 * ProjectName: spring-cloud-example <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/7/14 16:29 <br>
 */
@FeignClient(name = "sleuth-provider", url = "localhost:8082")
public interface HelloService {

    @RequestMapping("/sayHello")
    String sayHello(@RequestParam("name") String name);
}
