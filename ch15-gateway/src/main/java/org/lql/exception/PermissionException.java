package org.lql.exception;

/**
 * Title: PermissionException <br>
 * ProjectName: spring-cloud-example <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/7/14 14:08 <br>
 */
public class PermissionException extends RuntimeException{

    public PermissionException(String message) {
        super(message);
    }
}
