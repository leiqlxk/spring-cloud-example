package org.lql.vo;

import java.io.Serializable;
import java.util.List;

/**
 * Title: User <br>
 * ProjectName: spring-cloud-example <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/7/14 14:26 <br>
 */
public class User implements Serializable {

    private static final long serialVersionUID = -4083327605430665846L;

    public final static String CONTEXT_KEY_USERID = "x-user-id";

    private String userId;

    private String userName;

    private List<String> allowPermissionService;


    public List<String> getAllowPermissionService() {
        return allowPermissionService;
    }

    public void setAllowPermissionService(List<String> allowPermissionService) {
        this.allowPermissionService = allowPermissionService;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public User() {
    }
}
