package com.hotel.Config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.Properties;

@Configuration
@ComponentScan(basePackages = "com.hotel")
@EnableWebMvc
@EnableTransactionManagement
@PropertySource("classpath:persistence.security.properties")
public class MainConfig {

    //will be autowired from PropertySource file (persistence.security.properties)
    //read all properties and allocate them inside Environment variable(as bean) <----springframework.core.env
    @Autowired
    private Environment environment;

    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver =
                new InternalResourceViewResolver();
    viewResolver.setPrefix("/WEB-INF/view/");
    viewResolver.setSuffix(".jsp");
    return viewResolver;
    }

    @Bean("simpleDataSource")
    public DataSource getDataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/hotel_project");
        dataSource.setUsername("hotel_user");
        dataSource.setPassword("hotel_user");
//        dataSource.getConnection().prepareStatement("").execute();
        return dataSource;
    }
    @Bean(name = "myDataSource")
    public ComboPooledDataSource getComboDataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/hotel_project");
        dataSource.setUser("hotel_user");
        dataSource.setPassword("hotel_user");
        dataSource.setMinPoolSize(5);
        dataSource.setMaxPoolSize(20);
        dataSource.setMaxIdleTime(30000);
        return dataSource;
    }

    @Bean(name = "sessionFactory")
    @Autowired
    public LocalSessionFactoryBean getSessionFactory(@Qualifier("myDataSource") ComboPooledDataSource dataSource){
        LocalSessionFactoryBean localSessionFactoryBean =
                new LocalSessionFactoryBean();
        localSessionFactoryBean.setDataSource(dataSource);
        localSessionFactoryBean.setPackagesToScan("com.hotel.Entity");
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect","org.hibernate.dialect.MySQLDialect" );
        properties.setProperty("hibernate.show_sql","true");
        localSessionFactoryBean.setHibernateProperties(properties);
        return localSessionFactoryBean;
    }

    @Bean
    @Autowired
    public HibernateTransactionManager hibernateTransactionManager(LocalSessionFactoryBean localSessionFactoryBean){
        HibernateTransactionManager manager =
                new HibernateTransactionManager();
        manager.setSessionFactory( localSessionFactoryBean.getObject());
        return manager;
    }

    @Bean
    public DataSource securityDataSource(){
        //create connection pool
        ComboPooledDataSource securityDataSource =
                new ComboPooledDataSource();
        //set the jdbc driver
        try {
            securityDataSource.setDriverClass(environment.getProperty("jdbc.driver"));
        } catch (PropertyVetoException e) {
            throw  new RuntimeException();
        }

        //set database connection properties
        securityDataSource.setJdbcUrl(environment.getProperty("jdbc.url"));
        securityDataSource.setUser(environment.getProperty("jdbc.user"));
        securityDataSource.setPassword(environment.getProperty("jdbc.password"));

        //set connection pool properties
        securityDataSource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
        return securityDataSource;
    }

    private int getIntProperty(String property){
        String prop = environment.getProperty(property);
        return Integer.parseInt(prop);
    }


}


