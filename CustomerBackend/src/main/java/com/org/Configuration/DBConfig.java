package com.org.Configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.org.Model.Cart;
import com.org.Model.Category;
import com.org.Model.OrderDetail;
import com.org.Model.Product;
import com.org.Model.Supplier;
import com.org.Model.UserDetail;
@Configuration
@EnableTransactionManagement
/*@ComponentScan("com.org")*/

public class DBConfig 
{
	@Bean(name="dataSource")
	public DataSource getH2DataSource() {
		DriverManagerDataSource  datasource=new DriverManagerDataSource();
		
		datasource.setDriverClassName("org.h2.Driver");
		datasource.setUrl("jdbc:h2:tcp://localhost/~/b210045");
		datasource.setUsername("sa");
		datasource.setPassword("sa");

		System.out.println("===Creating DataSource Bean==");
		return datasource;
		
	}
	//2. Create a SessionFactory object
//	@Bean(name="sessionFactory")
	@Bean
    public SessionFactory getsessionFactory() 
	{
	Properties hibernateproperties=new Properties();
		hibernateproperties.put("hibernate.hbm2ddl.auto","update");
		
		hibernateproperties.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
		hibernateproperties.put("hibernate.show_sql", true);
		hibernateproperties.put("hibernate.format_sql", true);
		LocalSessionFactoryBuilder factory1=new LocalSessionFactoryBuilder(this.getH2DataSource());
		factory1.addProperties(hibernateproperties)	;
		
		factory1.addAnnotatedClass(Category.class);
        factory1.addAnnotatedClass(Supplier.class);
		factory1.addAnnotatedClass(Product.class);
		factory1.addAnnotatedClass(UserDetail.class);
		factory1.addAnnotatedClass(OrderDetail.class);
		factory1.addAnnotatedClass(Cart.class);
		SessionFactory sessionFactory=factory1.buildSessionFactory();
			
		System.out.println("Session is created");
        return sessionFactory;
	
	}
	//3. Create a HibernateTransactionManager 
//	@Bean(name="txManager")
	@Bean
	public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory)
	{
		System.out.println("Creating the TransactionManager Bean");
		return new HibernateTransactionManager(sessionFactory);
		
	}

}
