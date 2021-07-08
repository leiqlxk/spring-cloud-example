package org.lql.context;

/**
 * Title: HystrixThreadLocal <br>
 * ProjectName: spring-cloud-example <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/7/8 21:39 <br>
 */
public class HystrixThreadLocal {

    public static ThreadLocal<String> threadLocal = new ThreadLocal<>();
}
