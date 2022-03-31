package com.acme.boot;

import java.util.stream.Stream;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("com.acme")
@EntityScan("com.acme.jpa")
@Configuration
public class TicketSpringBootApplication {

	@Bean
	@ConfigurationProperties(prefix = "datasource")
	public DataSource createDataSource() {
		return new DriverManagerDataSource();
	}

	public static void main(String[] args) {
		SpringApplication.run(TicketSpringBootApplication.class, args);
	}
}
