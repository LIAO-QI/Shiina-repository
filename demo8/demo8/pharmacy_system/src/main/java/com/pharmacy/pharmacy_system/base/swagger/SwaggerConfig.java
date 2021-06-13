package com.pharmacy.pharmacy_system.base.swagger;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * 是否开启swagger，正式环境一般是需要关闭的，可根据springboot的多环境配置进行设置
 */
@EnableSwagger2
@Configuration
public class SwaggerConfig {
    /**
     * 通过 createRestApi函数来构建一个DocketBean
     * 函数名,可以随意命名,喜欢什么命名就什么命名
     */
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
            // 是否启用
            .enable(true)
            // 调用apiInfo方法,创建一个ApiInfo实例,里面是展示在文档页面信息内容
            .apiInfo(apiInfo())
            .select()
            // 扫描包的路径。如果某个接口不想暴露,可以使用@ApiIgnore 这样,该接口就不会暴露在 swagger2 的页面下
            .apis(RequestHandlerSelectors.basePackage("com.pharmacy.normal_pharmacy"))
            .paths(PathSelectors.any())
            .build()
            .globalOperationParameters(setHeaderToken());
    }

    /**
     * 构建 api文档的详细信息函数
     * @return ApiInfo
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
            // 页面标题
            .title("接口l列表")
            // 描述
            .description("API 描述")
            // 创建人
            .contact(new Contact("glw","https://www.baidu.com/","110@qq.com"))
            // 版本号
            .version("1.0")
            .build();
    }

    /**
     * 配置token
     * @return List<Parameter>
     */
    private List<Parameter> setHeaderToken() {
        ParameterBuilder tokenPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<>();
        tokenPar.name("Authorization").description("token").modelRef(new ModelRef("string")).parameterType("header").required(false).build();
        pars.add(tokenPar.build());
        return pars;
    }
}
