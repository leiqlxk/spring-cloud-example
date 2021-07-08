package org.lql.service;

import java.util.List;

/**
 * Title: IUserService <br>
 * ProjectName: spring-cloud-example <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/7/8 11:20 <br>
 */
public interface IUserService {

    String getDefaultUser();

    String getContextUserId();

    List<String> getProviderData();
}
