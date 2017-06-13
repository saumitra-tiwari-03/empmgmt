package com.dbi.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@ComponentScan(basePackages = "com.dbi")
@EnableJpaRepositories("com.dbi.jpa")
@EnableTransactionManagement
@EnableWebMvc
@PropertySource("classpath:persistence.properties")
public class AppConfig extends WebMvcConfigurerAdapter{
	
	@Autowired
	private Environment env;
	
	@Autowired
	private DataSource dataSource;
	
	private LocalContainerEntityManagerFactoryBean em;
	
	@Bean(name="dataSource")
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getProperty("driverClass"));
		dataSource.setUrl(env.getProperty("url"));
		dataSource.setUsername(env.getProperty("db.user"));
		dataSource.setPassword(env.getProperty("db.password"));

		return dataSource;
	}
	
	@Bean(name="entityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		if (em == null) {
			em = new LocalContainerEntityManagerFactoryBean();
			em.setDataSource(dataSource);
			em.setPackagesToScan(new String[] { "com.dbi.jpa" });

			JpaVendorAdapter vendorAdapter = jpaVendorAdapter();
			em.setJpaVendorAdapter(vendorAdapter);

			Properties properties = new Properties();
			properties.put("hibernate.validator.apply_to_ddl",
				env.getProperty("hibernate.validator.apply_to_ddl"));
			properties.put("hibernate.validator.autoregister_listeners",
				env.getProperty("hibernate.validator.autoregister_listeners"));
			properties.put("hibernate.dialect",
				env.getProperty("hibernate.dialect"));
			properties.put("hibernate.show_sql",
				env.getProperty("hibernate.show_sql"));
			properties.put("hibernate.format_sql",
				env.getProperty("hibernate.format_sql"));
			properties.put("hibernate.hbm2ddl.auto",
				env.getProperty("hibernate.hbm2ddl.auto"));
			properties.put("hibernate.generate_statistics",
				env.getProperty("hibernate.generate_statistics"));

			em.setJpaProperties(properties);
		}

		return em;
	}
	
	@Bean(name="jpaVendorAdapter")
	public JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter vendorAdapter =
			new HibernateJpaVendorAdapter();

		return vendorAdapter;
	}
	
	@Bean(name="transactionManager")
	public PlatformTransactionManager annotationDrivenTransactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(em.getObject());

		return transactionManager;
	}
	
	@Bean(name="viewResolver")
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");

		return viewResolver;
	}
	
	/*@Override
	public void configureContentNegotiation(
	ContentNegotiationConfigurer configurer) {
	configurer.defaultContentType(MediaType.APPLICATION_JSON);
	}
	
	@Bean
	public ViewResolver cnViewResolver(ContentNegotiationManager cnm) {
	ContentNegotiatingViewResolver cnvr =
	new ContentNegotiatingViewResolver();
	cnvr.setContentNegotiationManager(cnm);
	return cnvr;
	}*/
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
		registry.addResourceHandler("/js/**").addResourceLocations("/js/");
	}


}
