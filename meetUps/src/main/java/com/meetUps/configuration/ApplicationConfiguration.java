package com.meetUps.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.meetUps.model.MeetUps;
import com.meetUps.model.MeetUpsRegistration;
import com.meetUps.model.User;



	@Configuration
	@ComponentScan("com")
	@EnableTransactionManagement
	public class ApplicationConfiguration {
		
		@Autowired
		@Bean(name="dataSource")
		public DataSource getDataSource()
		{
			System.out.println("get datasource method called");
			DriverManagerDataSource dataSource=new DriverManagerDataSource();
			dataSource.setDriverClassName("com.mysql.jdbc.Driver");
			dataSource.setUsername("root");
			dataSource.setPassword("root");
			dataSource.setUrl("jdbc:mysql://localhost:3306/meetups");
			return dataSource;
		}
		private  Properties getHibernateProperties()
		 {
			  Properties properties=new Properties();
			  properties.setProperty("hibernate.show_sql", "true");
				properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
				properties.setProperty("hibernate.hbm2ddl.auto", "update");
				return properties;
					  
		 }
		@Autowired
		@Bean(name="SessionFactory")
		public SessionFactory getSessionFactory(DataSource dataSource)
		{
			LocalSessionFactoryBuilder localSessionFactoryBuilder=new LocalSessionFactoryBuilder(dataSource);
			localSessionFactoryBuilder.addProperties(getHibernateProperties());
			localSessionFactoryBuilder.addAnnotatedClass(User.class);
			localSessionFactoryBuilder.addAnnotatedClass(MeetUps.class);
			localSessionFactoryBuilder.addAnnotatedClass(MeetUpsRegistration.class);
			return localSessionFactoryBuilder.buildSessionFactory();
		}
		@Autowired
		@Bean(name="transactionManager")
		public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
		{
			HibernateTransactionManager hibernateTransactionManager=new HibernateTransactionManager(sessionFactory);
			return hibernateTransactionManager;
			
		}

}
