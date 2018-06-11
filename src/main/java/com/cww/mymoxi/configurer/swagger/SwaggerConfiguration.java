package com.cww.mymoxi.configurer.swagger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.ApiSelectorBuilder;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @author the_one
 * @time 2018/6/10
 * desciption: swagger 配置类
 */

@Configuration
@ComponentScan(basePackages = "com.cww.mymoxi.configurer.swagger")
public class SwaggerConfiguration {

    @Autowired
    SwaggerInfo swaggerInfo;

    @Bean
    public Docket controllerApi() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .groupName(swaggerInfo.getGroupName())
                .apiInfo(apiInfo());
        ApiSelectorBuilder builder = docket.select();
        if (!StringUtils.isEmpty(swaggerInfo.getBasePackage())) {
            builder = builder.apis(RequestHandlerSelectors.basePackage(swaggerInfo.getBasePackage()));
        }
        if (!StringUtils.isEmpty(swaggerInfo.getAntPath())) {
            builder = builder.paths(PathSelectors.ant(swaggerInfo.getAntPath()));
        }

        return builder.build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(swaggerInfo.getTitle())
                .description(swaggerInfo.getDescription())
                .termsOfServiceUrl("http://springfox.io")
                .contact("cww")
                .license(swaggerInfo.getLicense())
                .licenseUrl("https://github.com/springfox/springfox/blob/master/LICENSE")
                .version("2.0")
                .build();
    }



}
