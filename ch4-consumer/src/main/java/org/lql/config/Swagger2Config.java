package org.lql.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Title: Swagger2Config <br>
 * ProjectName: spring-cloud-example <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/6/24 14:47 <br>
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiinfo()).select()
                .apis(RequestHandlerSelectors.basePackage("org.lql.controller"))
                .paths(PathSelectors.any()).build();
    }

    private ApiInfo apiinfo() {
        return new ApiInfoBuilder().title("Feign多参数传递问题").description("Feign多参数传递问题")
                .contact("lql@qq.com").version("1.0").build();
    }
}
