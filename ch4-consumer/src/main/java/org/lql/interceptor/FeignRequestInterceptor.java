package org.lql.interceptor;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.*;

/**
 * Title: FeignRequestInterceptor <br>
 * ProjectName: spring-cloud-example <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/6/24 14:18 <br>
 */
@Component
public class FeignRequestInterceptor implements RequestInterceptor {
    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void apply(RequestTemplate requestTemplate) {
        // 在web开发中spring mvc是支持GET方法直接绑定POJO的，但是Feign的实现并未覆盖所有Spring MVC的功能，常见的解决方案：
        // 1.把POJO拆散成一个个单独的属性放在方法参数里
        // 2.把方法参数变成Map传递
        // 3.使用GET传递@RequestBody，但此违反Restful规范
        // 此处通过Feign拦截器方式处理， feign不支持GET方法传POJO，json body转query
        if (requestTemplate.method().equals("GET") && requestTemplate.body() != null) {
            try {
                JsonNode jsonNode = objectMapper.readTree(requestTemplate.body());
                requestTemplate.body(null);

                Map<String, Collection<String>> queries = new HashMap<>();
                buildQuery(jsonNode, "", queries);
                requestTemplate.queries(queries);
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void buildQuery(JsonNode jsonNode, String path, Map<String, Collection<String>> queries) {
        if (!jsonNode.isContainerNode()) {   // 叶子节点
            if (jsonNode.isNull()) {
                return;
            }
            Collection<String> values = queries.get(path);
            if (null == values) {
                values = new ArrayList<>();
                queries.put(path, values);
            }
            values.add(jsonNode.asText());
            return;
        }
        if (jsonNode.isArray()) {   // 数组节点
            Iterator<JsonNode> it = jsonNode.elements();
            while (it.hasNext()) {
                buildQuery(it.next(), path, queries);
            }
        } else {
            Iterator<Map.Entry<String, JsonNode>> it = jsonNode.fields();
            while (it.hasNext()) {
                Map.Entry<String, JsonNode> entry = it.next();
                if (StringUtils.hasText(path)) {
                    buildQuery(entry.getValue(), path + "." + entry.getKey(), queries);
                } else {  // 根节点
                    buildQuery(entry.getValue(), entry.getKey(), queries);
                }
            }
        }
    }
}
