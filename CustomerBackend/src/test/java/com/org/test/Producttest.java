package com.org.test;


import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.junit.Test;

import com.org.DAO.productDao;
import com.org.Model.Product;
public class Producttest
{
    
	static productDao productDAO;
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		//Package
		context.scan("indhu.niit");
		context.refresh();
		
		productDAO=(productDao) context.getBean("productDao");
	}

	@Test
	public void TestProductadd()
	{
		Product product=new Product();
		
		product.setProdName("Samsung");
		product.setProdDesc("All Models");
		product.setStock(10);
		product.setPrice(15000);
		product.setCatid(1);
		
		assertTrue("Transaction Issue", productDAO.addProduct(product));
	}
	
	@Ignore
	
	public void TestProddelete()
	{
		Product prod=productDAO.getProduct(45);
		assertTrue("transaction has completed ",productDAO.deleteProduct(prod));
	}
	
    @Ignore
	public void Testupdateprod()
	{
		Product prod=new Product();
		prod=productDAO.getProduct(45);
		prod.setPrice(30000);
	 assertTrue("Failed",productDAO.updateProduct(prod));
	}

}
