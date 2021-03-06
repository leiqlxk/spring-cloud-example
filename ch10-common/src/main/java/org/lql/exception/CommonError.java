package org.lql.exception;

import org.lql.util.ExceptionUtil;

/**
 * Title: CommonError <br>
 * ProjectName: spring-cloud-example <br>
 * description: 通用异常信息 <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/7/8 11:56 <br>
 */
public enum CommonError {

    /**
     * 1001, "用户信息为空"
     */
    AUTH_EMPTY_ERROR(10001, "the user is null, please check");

    private Integer code;
    private String message;

    CommonError(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCodeEn() {
        return ExceptionUtil.errorToCodeEN(this);
    }
}
