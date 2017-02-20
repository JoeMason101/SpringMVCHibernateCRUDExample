package org.jjm.test.model;

import javax.persistence.Column;  
import javax.persistence.Entity;  
import javax.persistence.GeneratedValue;  
import javax.persistence.GenerationType;  
import javax.persistence.Id;  
import javax.persistence.Table;  
/* 
 * This is the model class and it corresponds to Phone table in the database 
 */  
@Entity
@Table(name="PHONE")
public class Phone {
	
	 @Id  
	 @Column(name="id")  
	 @GeneratedValue(strategy=GenerationType.IDENTITY)  
	 int id;  
	 
	@Column(name="phoneName")
	String phoneName;
	
	@Column(name="make")
	String make;
	
	@Column(name="price")
	double price;
	
	@Column(name="storage")
	String storage;
	
	@Column(name="camera")
	String camera;

	public Phone() {
		super();
	}

	public Phone(int id, String phoneName, String make, double price, String storage, String camera) {
		super();
		this.id = id;  
		this.phoneName = phoneName;
		this.make = make;
		this.price = price;
		this.storage = storage;
		this.camera = camera;
	}

	public int getId() {
		return id;
	
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPhoneName() {
		return phoneName;
	}

	public void setPhoneName(String phoneName) {
		this.phoneName = phoneName;
	}


	public String getMake() {
		return make;
	}


	public void setMake(String make) {
		this.make = make;
	}

	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public String getStorage() {
		return storage;
	}


	public void setStorage(String storage) {
		this.storage = storage;
	}


	public String getCamera() {
		return camera;
	}


	public void setCamera(String camera) {
		this.camera = camera;
	}
	
}
