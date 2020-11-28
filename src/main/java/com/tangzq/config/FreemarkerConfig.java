package com.tangzq.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;
//import org.springframework.ui.


@Configuration
public class FreemarkerConfig {
    @Bean(name = "viewResolver")
public ViewResolver getViewResolver(){
    FreeMarkerViewResolver viewResolver= new FreeMarkerViewResolver();
    viewResolver.setCache(true);
    viewResolver.setPrefix("/freemarker/");
    viewResolver.setSuffix(".ftl");
    viewResolver.setOrder(1);
    viewResolver.setExposePathVariables(true);
    return  viewResolver;
}

@Bean(name = "freemarkerConfig2")
public FreeMarkerConfigurer getFreemarkerConfig(){
    FreeMarkerConfigurer config = new FreeMarkerConfigurer();
    // Folder containing FreeMarker templates.
    // 1 - "/WEB-INF/views/"
    // 2 - "classpath:/templates"
    config.setTemplateLoaderPath("classpath:/templates/");
    return config;

}
}


