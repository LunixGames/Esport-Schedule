package com.project.EsportSchedule.additional;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import com.project.EsportSchedule.data.ISportsDAO;
import com.project.EsportSchedule.data.SportsDAO;

@org.springframework.context.annotation.Configuration
@PropertySource("file:src/main/resources/env.properties")
@ComponentScan(basePackages="com.project.EsportSchedule")
public class Configuration extends WebMvcConfigurerAdapter {	
	@Value("${DATABASE_DB}")
	private String dbName;
	
	@Value("${DATABASE_USER}")
	private String dbUserName;

	@Value("${DATABASE_PASSWORD}")
	private String dbUserPassword;
	
	@Value("${DATABASE_PORT}")
	private String dbPort;
	
	@Value("${DATABASE_HOST}")
	private String dbHost;
	
	@Bean
    public ISportsDAO getDataSourceInstance() {
			return new SportsDAO(getDataSource());
    }

    @Bean
    public DataSource getDataSource() {    	
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName);
        dataSource.setUsername(dbUserName);
        dataSource.setPassword(dbUserPassword);
        return dataSource;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
        	.addResourceHandler("/**")
        	.addResourceLocations("file:src/main/resources/static/frontend/");
     }
}