package org.lql.controller;

import brave.servlet.TracingFilter;
import org.lql.service.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/**
 * Title: ComsumerController <br>
 * ProjectName: spring-cloud-example <br>
 * description: 分别使用feign、restTemplate、新线程的方式请求服务端，使用logger打印出sleuth的信息
 * 2021-07-14 16:48:37.131  INFO [sleuth-consumer,de452d5925a2de6e,de452d5925a2de6e,false] 9040 --- [nio-8081-exec-1] org.lql.controller.ComsumerController    : client sent. Feign方式，参数：curry
 * 2021-07-14 16:48:37.220  INFO [sleuth-consumer,de452d5925a2de6e,de452d5925a2de6e,false] 9040 --- [nio-8081-exec-1] org.lql.controller.ComsumerController    : client received. Feign方式，结果：hello, curry
 * 2021-07-14 16:49:58.530  INFO [sleuth-consumer,36e928e4e7798148,36e928e4e7798148,false] 9040 --- [nio-8081-exec-4] org.lql.controller.ComsumerController    : client sent. Feign方式，参数：curry
 * 2021-07-14 16:49:58.541  INFO [sleuth-consumer,36e928e4e7798148,36e928e4e7798148,false] 9040 --- [nio-8081-exec-4] org.lql.controller.ComsumerController    : client received. Feign方式，结果：hello, curry
 * 2021-07-14 16:50:19.885  INFO [sleuth-consumer,5956512688f6f7bf,5956512688f6f7bf,false] 9040 --- [nio-8081-exec-6] org.lql.controller.ComsumerController    : client sent. RestTemplate方式，参数：curry
 * 2021-07-14 16:50:19.911  INFO [sleuth-consumer,5956512688f6f7bf,5956512688f6f7bf,false] 9040 --- [nio-8081-exec-6] org.lql.controller.ComsumerController    : client received. RestTemplate方式，结果：hello, curry
 * 2021-07-14 16:50:29.003  INFO [sleuth-consumer,0d2c58aa3024d85a,0d2c58aa3024d85a,false] 9040 --- [nio-8081-exec-7] org.lql.controller.ComsumerController    : client sent. RestTemplate方式，参数：curry
 * 2021-07-14 16:50:29.009  INFO [sleuth-consumer,0d2c58aa3024d85a,0d2c58aa3024d85a,false] 9040 --- [nio-8081-exec-7] org.lql.controller.ComsumerController    : client received. RestTemplate方式，结果：hello, curry
 * 2021-07-14 16:50:41.962  INFO [sleuth-consumer,47e18b5955ef4d47,47e18b5955ef4d47,false] 9040 --- [nio-8081-exec-9] org.lql.controller.ComsumerController    : client sent. NewThread方式，参数：curry
 * 2021-07-14 16:50:41.970  INFO [sleuth-consumer,47e18b5955ef4d47,cd39666d97ae08c0,false] 9040 --- [pool-1-thread-1] org.lql.controller.ComsumerController    : client sent. 进入子线程，参数：curry
 * 2021-07-14 16:50:41.975  INFO [sleuth-consumer,47e18b5955ef4d47,47e18b5955ef4d47,false] 9040 --- [nio-8081-exec-9] org.lql.controller.ComsumerController    : client received. 返回主线程，结果：hello, curry
 * 2021-07-14 16:50:52.177  INFO [sleuth-consumer,9ad148d200ad72a6,9ad148d200ad72a6,false] 9040 --- [io-8081-exec-10] org.lql.controller.ComsumerController    : client sent. NewThread方式，参数：curry
 * 2021-07-14 16:50:52.177  INFO [sleuth-consumer,9ad148d200ad72a6,2005c583d4eefbe7,false] 9040 --- [pool-1-thread-2] org.lql.controller.ComsumerController    : client sent. 进入子线程，参数：curry
 * 2021-07-14 16:50:52.181  INFO [sleuth-consumer,9ad148d200ad72a6,9ad148d200ad72a6,false] 9040 --- [io-8081-exec-10] org.lql.controller.ComsumerController    : client received. 返回主线程，结果：hello, curry<br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/7/14 16:27 <br>
 */
@RestController
public class ComsumerController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ComsumerController.class);

    @Autowired
    private HelloService helloService;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ExecutorService executorService;

    @GetMapping("/helloByFeign")
    public String helloByFeign(String name) {
        LOGGER.info("client sent. Feign方式，参数：{}", name);

        String result = helloService.sayHello(name);

        LOGGER.info("client received. Feign方式，结果：{}", result);
        return result;
    }

    @GetMapping("/helloByRestTemplate")
    public String helloByRestTemplate(String name) {
        LOGGER.info("client sent. RestTemplate方式，参数：{}", name);

        String url = "http://localhost:8082/sayHello?name=" + name;
        String result = restTemplate.getForObject(url, String.class);

        LOGGER.info("client received. RestTemplate方式，结果：{}", result);
        return result;
    }

    @GetMapping("/helloByNewThread")
    public String helloByNewThread(String name) throws ExecutionException, InterruptedException {
        LOGGER.info("client sent. NewThread方式，参数：{}", name);

        Future future = executorService.submit(() -> {
            LOGGER.info("client sent. 进入子线程，参数：{}", name);
            String result = helloService.sayHello(name);
            return result;
        });

        String result = (String) future.get();
        LOGGER.info("client received. 返回主线程，结果：{}", result);

        return result;
    }
}
