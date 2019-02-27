package com.coinceres.uflodemo;

import com.bstek.uflo.console.UfloServlet;
import com.coinceres.uflodemo.filter.TestFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@ImportResource("classpath:context.xml")
public class UfloDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(UfloDemoApplication.class, args);
    }

    @Bean
    public ServletRegistrationBean buildUfloServlet() {
        return new ServletRegistrationBean(new UfloServlet(), "/uflo/*");
    }

    @Bean
    public FilterRegistrationBean buildTestFilter() {
        FilterRegistrationBean frb = new FilterRegistrationBean();
        frb.setFilter(new TestFilter());
        frb.addUrlPatterns("/*");
        return frb;
    }

}
