package com.learningsping.security.config;


import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.logging.Logger;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.learningsping.security")
@PropertySource("classpath:db.properties")
public class DemoAppConfig extends WebMvcConfigurerAdapter {

    //set up variable to hold properties

    @Autowired
    private Environment env;

    private Logger logger = Logger.getLogger(getClass().getName());


    //define bean for view Resolver

    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/view/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/resources/**")
                .addResourceLocations("/resources/");
    }

    @Bean
    public DataSource securityDataSource() {
        try {
            ComboPooledDataSource dataSource = new ComboPooledDataSource();

            dataSource.setDriverClass(env.getProperty("jdbc.driver"));
            logger.info(env.getProperty("jdbc.driver"));
            dataSource.setJdbcUrl(env.getProperty("jdbc.url"));
            logger.info(env.getProperty("jdbc.url"));
            dataSource.setUser(env.getProperty("jdbc.user"));
            logger.info(env.getProperty("jdbc.user"));
            dataSource.setPassword(env.getProperty("jdbc.password"));
            logger.info(env.getProperty("jdbc.password"));

            //set conn pool

            dataSource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
            dataSource.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));
            dataSource.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));
            dataSource.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));
            return dataSource;
        } catch (PropertyVetoException e) {
            throw new RuntimeException(e);
        }
    }

    private int getIntProperty(String name) {
        String propVal = env.getProperty(name);
        return  Integer.parseInt(propVal);
    }
}
