package com.hotel.Config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "com.hotel")
@EnableWebMvc
//@PropertySource("classpath:hibernate.cfg.xml")
public class MainConfig {


    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver =
                new InternalResourceViewResolver();
    viewResolver.setPrefix("/WEB-INF/view/");
    viewResolver.setSuffix(".jsp");
    return viewResolver;
    }

    @Bean
    public DataSource getDataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/hotel_project");
        dataSource.setUsername("hotel_user");
        dataSource.setPassword("hotel_user");
        return dataSource;
    }

}
