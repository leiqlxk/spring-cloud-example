package org.lql.service.fallback;

import org.lql.service.dataservice.DataService;
import org.springframework.stereotype.Component;

/**
 * Title: UserClientFallback <br>
 * ProjectName: spring-cloud-example <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/7/8 22:06 <br>
 */
@Component
public class UserClientFallback implements DataService {
    @Override
    public String getDefaultUser() {
        return new String("getDefaultUser failed");
    }

    @Override
    public String getContextUserId() {
        return new String("getContextUserId failed");
    }
}
