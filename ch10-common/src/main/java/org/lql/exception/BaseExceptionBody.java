package org.lql.exception;

import java.io.Serializable;

/**
 * Title: BaseExceptionBody <br>
 * ProjectName: spring-cloud-example <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/7/8 11:55 <br>
 */
public class BaseExceptionBody implements Serializable {
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -1270478894426234738L;

    /**
     * 相关业务ID
     */
    private Long businessId;

    /**
     * 异常编码：数字
     */
    private Integer code;

    /**
     * 异常编码：英文短语
     */
    private String codeEN;

    /**
     * 异常信息
     */
    private String businessMessage;

    /**
     * 异常类型
     */
    private String exceptionType;



    public Long getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Long businessId) {
        this.businessId = businessId;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getCodeEN() {
        return codeEN;
    }

    public void setCodeEN(String codeEN) {
        this.codeEN = codeEN;
    }

    public String getBusinessMessage() {
        return businessMessage;
    }

    public void setBusinessMessage(String businessMessage) {
        this.businessMessage = businessMessage;
    }

    public String getExceptionType() {
        return exceptionType;
    }

    public void setExceptionType(String exceptionType) {
        this.exceptionType = exceptionType;
    }

    public BaseExceptionBody() {

    }

    public BaseExceptionBody(BaseException exception) {
        this.businessId = exception.getBusinessId();
        this.code = exception.getCode();
        this.codeEN = exception.getCodeEN();
        this.businessMessage = exception.getMessage();
        this.exceptionType = exception.getClass().getName();
    }
}
