package com.hukuuu.restapi.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class PersistenceConfig {

	@Value("${db.url}")
	private String DB_URL;

	@Value("${db.username}")
	private String DB_USERNAME;

	@Value("${db.password}")
	private String DB_PASSWORD;

	@Value("${db.driver}")
	private String DB_DRIVER;

	@Value("${hibernate.hbm2ddl.auto}")
	private String HBM2DDL_AUTO;

	@Value("${hibernate.dialect}")
	private String DIALECT;

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource());
		em.setPackagesToScan(new String[] { "com.hukuuu.restapi" });
		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		em.setJpaProperties(additionalProperties());
		return em;
	}

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(DB_DRIVER);
		dataSource.setUrl(DB_URL);
		dataSource.setUsername(DB_USERNAME);
		dataSource.setPassword(DB_PASSWORD);
		return dataSource;
	}

	@Bean
	public PlatformTransactionManager transactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactoryBean()
				.getObject());
		return transactionManager;
	}

	// @Bean
	// public PersistenceExceptionTranslationPostProcessor
	// exceptionTranslation() {
	// return new PersistenceExceptionTranslationPostProcessor();
	// }

	private Properties additionalProperties() {
		return new Properties() {
			{
				// Hibernate Specific:
				setProperty("hibernate.hbm2ddl.auto", HBM2DDL_AUTO);
				setProperty("hibernate.dialect", DIALECT);
			}
		};
	}

}
