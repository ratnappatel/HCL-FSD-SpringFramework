package com.gl.dao;

import java.util.HashMap;

import org.springframework.stereotype.Repository;

import com.gl.pojo.User;

@Repository
public class UserDAOImpl implements UserDAO{

	HashMap<String,User> users=new HashMap<String,User>();
	public UserDAOImpl() {
		users.put("ratnabpatel", new User("ratnabpatel","Ratna Patel","ratna@123#"));
		users.put("drpinakinp", new User("drpinakinp","Pinakin Patel","silverKitten@123"));
	}
	
	@Override
	public User getUser(String id,String password) {
		User u=null;
		if(users.containsKey(id))
		{
			u=users.get(id);
			System.out.println(u);
			if(u.getPassword().equals(password))
				return u;
		}
		return u;
	}

}
