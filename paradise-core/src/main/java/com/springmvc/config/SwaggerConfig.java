package com.springmvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
@EnableWebMvc
//@ComponentScan(basePackages = "com.weir")
public class SwaggerConfig extends WebMvcConfigurationSupport {

	@Bean
    public Docket apiConfig(){
        return new Docket(DocumentationType.SWAGGER_2)
        		.apiInfo(new ApiInfoBuilder().title("接口文档…………………………………^-^")
                        .version("版本号:1.0")
                        .build())
                .select()//创建ApiSelectorBuilder对象
                .apis(RequestHandlerSelectors.any())
                //.apis(RequestHandlerSelectors.basePackage("com.springmvc.web.controller"))
                .paths(PathSelectors.ant("/department/**")).build()//过滤的接口
                .groupName("分组1") //定义分组
               // .apiInfo(apiInfo())// 调用apiInfo方法,创建一个ApiInfo实例,里面是展示在文档页面信息内容
                .useDefaultResponseMessages(false)//关闭默认返回值
                ;
    }

    @Bean
    public Docket wap_api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.ant("/user/**")).build()//选定api的路径
                .groupName("interfer").pathMapping("/user")//创建第二个分组
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("BookStore Platform API")//大标题
                .contact(new Contact("姓名", "地址", "邮箱"))//联系人信息
                .description("This is a Demo")//详细描述
                .version("2.0")//版本
                .license("The Apache License, Version 2.0")//许可证信息
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")//许可证地址
                .build();
    }
}
