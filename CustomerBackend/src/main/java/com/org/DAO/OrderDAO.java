package com.org.DAO;

import com.org.Model.OrderDetail;

public interface OrderDAO 
{

	public boolean payment(OrderDetail orderDetail);
	public boolean updateCartItemStatus(String username,int orderId);
	
}
