package org.lql.util;

import org.springframework.util.StringUtils;

/**
 * Title: ExceptionUtil <br>
 * ProjectName: spring-cloud-example <br>
 * description: 异常转换工具类 <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/7/8 11:37 <br>
 */
public class ExceptionUtil {

    /**
     * 异常枚举转类型换为英文code
     * @param error 异常枚举
     * @return 大驼峰编码
     */
    public static String errorToCodeEN(Enum<?> error) {
        String errorName = error.name().toLowerCase();
        String[] sp = errorName.split("_");
        StringBuffer code = new StringBuffer();
        for (String s : sp) {
            code.append(StringUtils.capitalize(s));
        }
        return code.toString();
    }
}
