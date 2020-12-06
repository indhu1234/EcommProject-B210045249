package com.org.DAO;

import java.util.List;

import com.org.Model.Category;

public interface CategoryDaoIntf 
{
	public boolean addCategory(Category category);
	public boolean deleteCategory(Category category);
	public boolean updateCategory(Category category);
	public Category getCategory(int categoryId);
	public List<Category> listCategories();

}
