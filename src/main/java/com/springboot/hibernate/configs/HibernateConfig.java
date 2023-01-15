package com.springboot.hibernate.configs;

import java.io.IOException;
import java.util.Objects;
import java.util.Properties;
import javax.sql.DataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@Configuration
public class HibernateConfig {
	
	@Autowired
	private Environment env;
	
	@Bean(name = "dataSource")
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(
				Objects.requireNonNull(env.getProperty("spring.datasource.driver-class-name")));
		dataSource.setUrl(env.getProperty("spring.datasource.url"));
		dataSource.setUsername(env.getProperty("spring.datasource.username"));
		dataSource.setPassword(env.getProperty("spring.datasource.password"));
		return dataSource;
	}

	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) throws IOException {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", env.getProperty("spring.jpa.properties.hibernate.dialect"));
		properties.put("hibernate.show_sql", env.getProperty("spring.jpa.show-sql"));
		properties.put("hibernate.hbm2ddl.auto", env.getProperty("spring.jpa.hibernate.ddl-auto"));
		properties.put("current_session_context_class", env.getProperty("spring.jpa.properties.hibernate.current_session_context_class"));
//		properties.put("hibernate.physical_naming_strategy", env.getProperty("spring.jpa.hibernate.naming.physical-strategy"));
//		properties.put("hibernate.implicit_naming_strategy", env.getProperty("spring.jpa.hibernate.naming.implicit-strategy"));
		properties.put("hibernate.globally_quoted_identifiers", env.getProperty("spring.jpa.properties.hibernate.globally_quoted_identifiers"));


//		By default, this property is false. Turning it on means that each access to an associated lazy-loaded entity will be wrapped in a new session running in a new transaction:
//		Using this property to avoid the LazyInitializationException error isn't recommended, since it'll slow down the performance of our application.
//		This is because we'll end up with an n + 1 problem. Simply put, it means one SELECT for the User and N additional SELECTs to fetch the roles of each user
		// properties.put("hibernate.enable_lazy_load_no_trans", env.getProperty("spring.jpa.properties.hibernate.enable_lazy_load_no_trans"));

		properties.put("hibernate.jdbc.batch_size", env.getProperty("spring.jpa.properties.hibernate.jdbc.batch_size"));
		properties.put("hibernate.order_inserts", "true");
		properties.put("hibernate.order_updates", "true");
		properties.put("hibernate.jdbc.batch_versioned_data", "true");

		properties.put("hibernate.cache.use_second_level_cache", "true");
		properties.put("hibernate.cache.region.factory_class", "org.hibernate.cache.ehcache.EhCacheRegionFactory");

		LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
		// Package contain entity classes
		factoryBean.setPackagesToScan("com.springboot.hibernate.entities");
		factoryBean.setDataSource(dataSource);
		factoryBean.setHibernateProperties(properties);
		factoryBean.afterPropertiesSet();
		return factoryBean.getObject();
	}

	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		return new HibernateTransactionManager(sessionFactory);
	}
}
