package com.Project.HaulageManagement.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
@Entity
public class HaulageCustomer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	String name;
	String mobileNo;
	String haulageID;
	String AddressLine1;
	String AddressLine2;
	String city;
	String pincode;
	
	private String emailId;
	
	
	  @ManyToOne
	  @JoinColumn(name="district__ID") District district;
	 
	
	 public HaulageCustomer() {
	        // You can initialize default values here if needed
	    }
	
	 //this one
	
	public HaulageCustomer(String name, String mobileNo, String addressLine1, String addressLine2,
			String city, String pincode, String emailId ,District district) {
		super();
		this.name = name;
		this.mobileNo = mobileNo;
		AddressLine1 = addressLine1;
		AddressLine2 = addressLine2;
		this.city = city;
		this.pincode = pincode;
		this.emailId = emailId;
		this.district = district;
		
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getHaulageID() {
		return haulageID;
	}
	public void setHaulageID(String haulageID) {
		this.haulageID = haulageID;
	}
	public String getAddressLine1() {
		return AddressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		AddressLine1 = addressLine1;
	}
	public String getAddressLine2() {
		return AddressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		AddressLine2 = addressLine2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public District getDistrict() {
		return district;
	}
	public void setDistrict(District district) {
		this.district = district;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	
}
