package com.meetUps.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.meetUps.model.User;




@Transactional
@Repository(value="userDao")
public class UserDaoImpl implements UserDao {

	@Autowired
	SessionFactory sessionFactory;
	public void addUser(User user) {
		  Session session=sessionFactory.getCurrentSession();
		  user.setRole("ROLE_USER");
		  session.save(user);
		 
		  System.out.println("user added successfully");
	}
	public List<User> viewUsers() {
		Session session=sessionFactory.getCurrentSession();
		
		  List<User> list=session.createCriteria(User.class).list();
		
		return list;
	}
	public void update(User user) {
		Session session=sessionFactory.getCurrentSession();
		session.update(user);
		
	}
	public void deleteUser(int id) {
		Session session=sessionFactory.getCurrentSession();
		User user=(User)session.get(User.class,id);
		session.delete(user);;
	
	}
	public User viewUserById(int id) {
		
		Session session=sessionFactory.getCurrentSession();
		User user=(User)session.get(User.class,id);
		return user;
	}
	public int validateUser(String username, String password) {
		int res=0;
		Session session=sessionFactory.getCurrentSession();
		Query result=session.createQuery("from User u where u.userName='"+username+"'");
		  // result.setString("username",username);
		List<User> user=result.list();
		System.out.println("user:"+user);
	if(user.size()==0)
	{
		res=0;
	}
	else
	{
		for(int i=0;i<user.size();i++)
		{
			System.out.println("inside for loop");
			String dbuserName=user.get(i).getUserName();
			String dbpassword=user.get(i).getPassword();
			String dbrole=user.get(i).getRole();
			if(dbuserName.equals(username)&&dbpassword.equals(password)&&dbrole.equals("ROLE_USER"))
			{
				res=1;
				System.out.println("the result is:"+res);
			}
			else
				if(dbuserName.equals(username)&&dbpassword.equals(password)&&dbrole.equals("ROLE_ADMIN"))
			{
				res=2;
				System.out.println("the result  is:"+res);
			}
			}
	}	
	return res;
	}
}
