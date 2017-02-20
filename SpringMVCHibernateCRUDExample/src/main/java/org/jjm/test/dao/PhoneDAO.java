package org.jjm.test.dao;

import java.util.List;  

import org.jjm.test.model.Phone;
import org.hibernate.Hibernate;
import org.hibernate.Session;  
import org.hibernate.SessionFactory;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Repository;  

//This class will execute hibernate statements while interacting with database.
// @Repository is specialised component annotation which is used to create bean at DAO layer. We have use Autowired annotation to inject hibernate SessionFactory into CountryDAO class
@Repository
public class PhoneDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	
	public List<Phone> getAllPhones() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Phone> phoneList = session.createQuery("from Phone").list();
		return phoneList;
	}
	
	public Phone getPhone(int id ) {
		Session session = this.sessionFactory.getCurrentSession();
		Phone phone = (Phone) session.load(Phone.class, new Integer(id));
		Hibernate.initialize(phone);
		return phone;
	}
	
	public Phone addPhone(Phone phone) { 
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(phone);
		return phone;
	}
	
	public void updatePhone(Phone phone) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(phone);
	}
	
	public void deletePhone(int id ) {
		Session session = this.sessionFactory.getCurrentSession();
		Phone p = (Phone) session.load(Phone.class, new Integer(id));
		if (null !=p) {
			session.delete(p);
		}
	}
	


}
