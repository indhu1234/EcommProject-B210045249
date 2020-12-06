package com.org.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.org.Model.Category;
import com.org.Model.Supplier;

@Transactional
public class supplierDaoImpl implements suplierDao
{
	@Autowired
	SessionFactory sessionFactory; 


	public boolean addSupplier(Supplier supplier)
	{
		try
		{
		sessionFactory.getCurrentSession().saveOrUpdate(supplier);
		return true;	
		}
		catch(Exception e)
		{
		return false;
		}
	
	}

	public boolean deleteSupplier(Supplier supplier) 
	{
		try
		{
		sessionFactory.getCurrentSession().delete(supplier);
		return true;	
		}
		catch(Exception e)
		{
		return false;
		}
	}

	public boolean updateSupplier(Supplier supplier) 
	{
	
		try
		{
		sessionFactory.getCurrentSession().update(supplier);
		return true;	
		}
		catch(Exception e)
		{
		return false;
		}


	}

	public Supplier getSupplier(int supId) 
	{
	
		Session session=sessionFactory.openSession();
		Supplier supplier=(Supplier)session.get(Supplier.class,supId);
		session.close();
		return supplier;

	}

	public List<Supplier> listSupplier()
	{
		Session session=sessionFactory.openSession();
		List<Supplier> listSuppliers=(List<Supplier>)session.createQuery("from Supplier").list();
		session.close();
		return listSuppliers;
	
		
	}

}
