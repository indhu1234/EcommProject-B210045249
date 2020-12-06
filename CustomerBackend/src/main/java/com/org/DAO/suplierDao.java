package com.org.DAO;

import java.util.List;

import com.org.Model.Supplier;

public interface suplierDao 
{
	public boolean addSupplier(Supplier supplier);
	public boolean deleteSupplier(Supplier supplier);
	public boolean updateSupplier(Supplier supplier);
	public Supplier getSupplier(int supId);
	public List<Supplier> listSupplier();

}
