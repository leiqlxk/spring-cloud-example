package org.lql.controller;

import org.lql.config.ConfigInfoProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Title: ConfigClientController <br>
 * ProjectName: spring-cloud-example <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/7/13 17:42 <br>
 */
@RestController
public class ConfigClientController {

    @Autowired
    private ConfigInfoProperties configInfoProperties;

    @GetMapping("/getConfigInfo")
    public String getConfigInfo() {
        return configInfoProperties.getConfig();
    }
}
