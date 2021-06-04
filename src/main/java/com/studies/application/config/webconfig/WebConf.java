package com.studies.application.config.webconfig;

import com.studies.application.config.listener.CustomListener;
import com.studies.application.servlet.CarListServlet;
import com.studies.application.servlet.FindCarServlet;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.ServletContextListener;

@Configuration
public class WebConf {

    @Bean
    public ServletRegistrationBean findCar() {
        ServletRegistrationBean bean
                = new ServletRegistrationBean(new FindCarServlet(), "/findcar");
        return bean;
    }

    @Bean
    public ServletRegistrationBean carList() {
        ServletRegistrationBean bean
                = new ServletRegistrationBean(new CarListServlet(), "/carlist");
        return bean;
    }

    @Bean
    public ServletListenerRegistrationBean<ServletContextListener> customListenerBean() {
        ServletListenerRegistrationBean<ServletContextListener> bean = new ServletListenerRegistrationBean();
        bean.setListener(new CustomListener());
        return bean;
    }

}
