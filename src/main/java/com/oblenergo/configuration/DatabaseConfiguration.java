package com.oblenergo.configuration;

import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan
@PropertySource("classpath:datasource.properties")
public class DatabaseConfiguration {

  @Autowired
  private Environment environment;

  @Bean(name = "dataSource")
  BasicDataSource dataSource() {

    BasicDataSource dataSource = new BasicDataSource();
    dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName"));
    dataSource.setUrl(environment.getRequiredProperty("jdbc.url"));
    dataSource.setUsername(environment.getRequiredProperty("jdbc.username"));
    dataSource.setPassword(environment.getRequiredProperty("jdbc.password"));
    return dataSource;
  }

  private Properties hibernateProperties() {

    Properties properties = new Properties();
    properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
    properties.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
    // only for developing
	properties.put("hibernate.show_sql",
	environment.getRequiredProperty("hibernate.show_sql"));
    return properties;
  }

  @Bean(name = "sessionFactory")
  public SessionFactory sessionFactory() {

    LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource());
    builder.scanPackages("com.oblenergo.model").addProperties(hibernateProperties());
    return builder.buildSessionFactory();
  }

  @Bean
  public HibernateTransactionManager transactionManager(SessionFactory s) {

    HibernateTransactionManager txManager = new HibernateTransactionManager();
    txManager.setSessionFactory(s);
    return txManager;
  }

}
