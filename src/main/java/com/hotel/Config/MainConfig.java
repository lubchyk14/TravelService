package com.hotel.Config;

import com.hotel.Entity.Hotel;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.Properties;

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
    
    @Bean()
    @Autowired
    public SessionFactory getSessionFactory(ComboPooledDataSource dataSource){
        LocalSessionFactoryBean localSessionFactoryBean =
                new LocalSessionFactoryBean();
        localSessionFactoryBean.setDataSource(dataSource);
        localSessionFactoryBean.setPackagesToScan("com.hotel.Entity");
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect","org.hibernate.dialect.MySQLDialect" );
        properties.setProperty("hibernate.show_sql","true");
        localSessionFactoryBean.setHibernateProperties(properties);

        return localSessionFactoryBean.getObject();
    }

//    @Bean
//    @Autowired
//    public HibernateTransactionManager hibernateTransactionManager(LocalSessionFactoryBean localSessionFactoryBean){
//        HibernateTransactionManager manager =
//                new HibernateTransactionManager();
//        manager.setSessionFactory((SessionFactory) localSessionFactoryBean);
//        return manager;
//    }
//    @Bean
//    public PlatformTransactionManager hibernateTransactionManager() {
//        HibernateTransactionManager transactionManager
//                = new HibernateTransactionManager();
//        transactionManager.setSessionFactory(sessionFactory().getObject());
//        return transactionManager;
//    }

}


