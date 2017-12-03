package com.project.EsportSchedule.additional;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import com.project.EsportSchedule.data.ISportsDAO;
import com.project.EsportSchedule.data.SportsDAO;

@org.springframework.context.annotation.Configuration
@ComponentScan(basePackages="com.project.EsportSchedule")
@EnableWebMvc
public class Configuration extends WebMvcConfigurerAdapter {
	
	@Bean
    public ISportsDAO getDataSourceInstance() {
			return new SportsDAO(getDataSource());
    }
	
    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/EsportSchedule");
        dataSource.setUsername("root");
        //dataSource.setPassword("P@ssw0rd");
        return dataSource;
    }
    
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
          .addResourceHandler("/files/**")
          .addResourceLocations("file:/opt/files/");
     }
}