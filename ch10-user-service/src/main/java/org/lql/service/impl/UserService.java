package org.lql.service.impl;

import org.lql.service.IUserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Title: UserService <br>
 * ProjectName: spring-cloud-example <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/7/8 11:20 <br>
 */
@Service
public class UserService implements IUserService {
    @Override
    public String getDefaultUser() {
        return null;
    }

    @Override
    public String getContextUserId() {
        return null;
    }

    @Override
    public List<String> getProviderData() {
        return null;
    }
}
