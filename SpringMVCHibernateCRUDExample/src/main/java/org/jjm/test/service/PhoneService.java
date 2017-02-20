package org.jjm.test.service;

import java.util.List;  
import org.jjm.test.dao.PhoneDAO;  
import org.jjm.test.model.Phone; 
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Service;  
import org.springframework.transaction.annotation.Transactional;  

@Service("phoneService")
public class PhoneService {

	@Autowired
	PhoneDAO phoneDao;
	
	
	@Transactional
	public List<Phone> getAllPhones() {
		return phoneDao.getAllPhones();
	}
	
	@Transactional
	public Phone getPhone(Integer id) {
		return phoneDao.getPhone(id);
	}
	
	@Transactional
	public void addPhone(Phone phone) {
		phoneDao.addPhone(phone);
	}
	
	@Transactional
	public void updatePhone(Phone phone) {
		phoneDao.updatePhone(phone);
	}
	@Transactional
	public void deletePhone(Integer id) {
		phoneDao.deletePhone(id);
		
	}
}
