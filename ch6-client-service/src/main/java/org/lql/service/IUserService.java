package org.lql.service;

/**
 * Title: IUserService <br>
 * ProjectName: spring-cloud-example <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/6/30 16:55 <br>
 */
public interface IUserService {

    String getUser(String username) throws Exception;
}
