package com.sriram.spring.configuration;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.List;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = {"com.sriram.spring.controller"})
@Component
@Setter(onMethod_ = {@Autowired})
public class WebConfig implements WebMvcConfigurer {
    private HttpMessageConverter jsonConverter;
    private HttpMessageConverter xmlConverter;

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(jsonConverter);
        converters.add(xmlConverter);
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.viewResolver(new InternalResourceViewResolver("/WEB-INF/views/", ".jsp"));
    }
}
