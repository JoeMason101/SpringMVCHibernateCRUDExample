package org.jjm.test.controller;

import java.util.List;  

import org.jjm.test.model.Phone;
import org.jjm.test.service.PhoneService;

import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Controller;  
import org.springframework.ui.Model;  
import org.springframework.web.bind.annotation.ModelAttribute;  
import org.springframework.web.bind.annotation.PathVariable;  
import org.springframework.web.bind.annotation.RequestBody;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;  


@Controller
public class PhoneController {
	
	@Autowired
	PhoneService phoneService;
	
	@RequestMapping(value = "/getAllPhones", method = RequestMethod.GET, headers = "Accept=application/json")
	public String getPhones(Model model) {
		List<Phone> listOfPhones = phoneService.getAllPhones();
		model.addAttribute("phone", new Phone());
		model.addAttribute("listOfPhones", listOfPhones);
		return "phoneDetails";
	}
	
	@RequestMapping(value = "/getPhone{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Phone getPhoneByID(@PathVariable int id) { 
		return phoneService.getPhone(id);
	}
	
	@RequestMapping(value = "/addPhone", method = RequestMethod.POST, headers = "Accept=application/json")
	public String addPhone(@ModelAttribute("phone")Phone phone) { 
		if(phone.getId()==0)
		{
			phoneService.addPhone(phone);
		} else
		{
			phoneService.updatePhone(phone);
		}
		
		return "redirect:/getAllPhones";
		
	}
	
	@RequestMapping(value = "/updatePhone/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String updatePhone(@PathVariable("id") int id, Model model) {
		model.addAttribute("phone", this.phoneService.getPhone(id));
		model.addAttribute("listOfPhones", this.phoneService.getAllPhones());
		return "phoneDetails";
		
	}
	
	@RequestMapping(value = "/deletePhone/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String deletePhone(@PathVariable("id") int id) {
		phoneService.deletePhone(id);
		return "redirect:/getAllPhones";
	}
	
	

}
