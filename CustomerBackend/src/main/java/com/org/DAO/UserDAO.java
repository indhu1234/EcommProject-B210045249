package com.org.DAO;

import com.org.Model.UserDetail;

public interface UserDAO {
	public boolean registerUser(UserDetail userDetail);
	public boolean updateUser(UserDetail userDetail);
	public UserDetail getUser(String username);

}
