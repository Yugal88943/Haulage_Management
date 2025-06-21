package com.Project.HaulageManagement.Entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Haulage {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	String bookingCode;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	LocalDate bookingDate;
	String weightUnit;
	String lengthUnit;
	String distanceUnit;
	String volumeUnit;
	String courierMode;
	String ewayBillNo;
	String hazardous;
	String explaination;
	String consignmentType;
	Integer noofpieces;
	String courierCenter;
	String description;
	Double distance;
	Double totalWeight;
	String courierService;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	LocalDate expectedDelieveryDate;
	Double charges;
	Double FinalCharges;
	String taxType;
	Double taxPercentage;
	String discountType;//% or amount
	Double discountInAmt;
	Double discountInPer;
	String paymentMode;
	Double amount;
	
	//Sender Information
	String senderName;
	String senderMobileNo;
	String senderEmailID;
	String AddressLine1;
	String AddressLine2;
	String senderCity;
	String senderPincode;
	String senderLandmark;
	String sender_Tracking_Code;
	String haulage_Status;
	
	@ManyToOne()
	@JoinColumn(name = "sender_district_id")
	District senderDistrict;
	
	

	
	//Receiver Information
	String receiverName;
	String receiverMobileNo;
	String receiverEmailID;
	String receiverAddressLine1;
	String receiverAddressLine2;
	String receiverCity;
	String receiverPincode;
	String receiverLandmark;
	@ManyToOne()
	@JoinColumn(name = "receiver_district_id")
	District receiverDistrict;
	
	
	@ManyToOne
	@JoinColumn(name ="country_id") 
	Country country;
	@ManyToOne
	State state;
	
	@OneToMany(mappedBy = "haulage", cascade = CascadeType.ALL)
	List<HaulageItems> haulageItems = new ArrayList<HaulageItems>();
	
	@ManyToOne
	@JoinColumn(name = "customer_id")
	HaulageCustomer customer;
	
	public String getSender_Tracking_Code() {
		return sender_Tracking_Code;
	}

	public void setSender_Tracking_Code(String sender_Tracking_Code) {
		this.sender_Tracking_Code = sender_Tracking_Code;
	}

	public String getHaulage_Status() {
		return haulage_Status;
	}

	public void setHaulage_Status(String haulage_Status) {
		this.haulage_Status = haulage_Status;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	
	

	public District getSenderDistrict() {
		return senderDistrict;
	}

	public void setSenderDistrict(District senderDistrict) {
		this.senderDistrict = senderDistrict;
	}

	public District getReceiverDistrict() {
		return receiverDistrict;
	}

	public void setReceiverDistrict(District receiverDistrict) {
		this.receiverDistrict = receiverDistrict;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	public String getVolumeUnit() {
		return volumeUnit;
	}

	public void setVolumeUnit(String volumeUnit) {
		this.volumeUnit = volumeUnit;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBookingCode() {
		return bookingCode;
	}

	public void setBookingCode(String bookingCode) {
		this.bookingCode = bookingCode;
	}

	public LocalDate getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}

	public String getWeightUnit() {
		return weightUnit;
	}

	public void setWeightUnit(String weightUnit) {
		this.weightUnit = weightUnit;
	}

	public String getLengthUnit() {
		return lengthUnit;
	}

	public void setLengthUnit(String lengthUnit) {
		this.lengthUnit = lengthUnit;
	}

	public String getDistanceUnit() {
		return distanceUnit;
	}

	public void setDistanceUnit(String distanceUnit) {
		this.distanceUnit = distanceUnit;
	}

	public String getCourierMode() {
		return courierMode;
	}

	public void setCourierMode(String courierMode) {
		this.courierMode = courierMode;
	}

	public String getEwayBillNo() {
		return ewayBillNo;
	}

	public void setEwayBillNo(String ewayBillNo) {
		this.ewayBillNo = ewayBillNo;
	}

	public String getHazardous() {
		return hazardous;
	}

	public void setHazardous(String hazardous) {
		this.hazardous = hazardous;
	}

	public String getExplaination() {
		return explaination;
	}

	public void setExplaination(String explaination) {
		this.explaination = explaination;
	}

	public String getConsignmentType() {
		return consignmentType;
	}

	public void setConsignmentType(String consignmentType) {
		this.consignmentType = consignmentType;
	}

	public Integer getNoofpieces() {
		return noofpieces;
	}

	public void setNoofpieces(Integer noofpieces) {
		this.noofpieces = noofpieces;
	}

	public String getCourierCenter() {
		return courierCenter;
	}

	public void setCourierCenter(String courierCenter) {
		this.courierCenter = courierCenter;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}

	public Double getTotalWeight() {
		return totalWeight;
	}

	public void setTotalWeight(Double totalWeight) {
		this.totalWeight = totalWeight;
	}

	public String getCourierService() {
		return courierService;
	}

	public void setCourierService(String courierService) {
		this.courierService = courierService;
	}

	public LocalDate getExpectedDelieveryDate() {
		return expectedDelieveryDate;
	}

	public void setExpectedDelieveryDate(LocalDate expectedDelieveryDate) {
		this.expectedDelieveryDate = expectedDelieveryDate;
	}

	public Double getCharges() {
		return charges;
	}

	public void setCharges(Double charges) {
		this.charges = charges;
	}

	public Double getFinalCharges() {
		return FinalCharges;
	}

	public void setFinalCharges(Double finalCharges) {
		FinalCharges = finalCharges;
	}

	public String getTaxType() {
		return taxType;
	}

	public void setTaxType(String taxType) {
		this.taxType = taxType;
	}

	public Double getTaxPercentage() {
		return taxPercentage;
	}

	public void setTaxPercentage(Double taxPercentage) {
		this.taxPercentage = taxPercentage;
	}

	public String getDiscountType() {
		return discountType;
	}

	public void setDiscountType(String discountType) {
		this.discountType = discountType;
	}

	public Double getDiscountInAmt() {
		return discountInAmt;
	}

	public void setDiscountInAmt(Double discountInAmt) {
		this.discountInAmt = discountInAmt;
	}

	public Double getDiscountInPer() {
		return discountInPer;
	}

	public void setDiscountInPer(Double discountInPer) {
		this.discountInPer = discountInPer;
	}

	public List<HaulageItems> getHaulageItems() {
		return haulageItems;
	}

	public void setHaulageItems(List<HaulageItems> haulageItems) {
		this.haulageItems = haulageItems;
	}

	public HaulageCustomer getCustomer() {
		return customer;
	}

	public void setCustomer(HaulageCustomer customer) {
		this.customer = customer;
	}

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public String getSenderMobileNo() {
		return senderMobileNo;
	}

	public void setSenderMobileNo(String senderMobileNo) {
		this.senderMobileNo = senderMobileNo;
	}

	public String getSenderEmailID() {
		return senderEmailID;
	}

	public void setSenderEmailID(String senderEmailID) {
		this.senderEmailID = senderEmailID;
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

	public String getSenderCity() {
		return senderCity;
	}

	public void setSenderCity(String senderCity) {
		this.senderCity = senderCity;
	}

	public String getSenderPincode() {
		return senderPincode;
	}

	public void setSenderPincode(String senderPincode) {
		this.senderPincode = senderPincode;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public String getReceiverMobileNo() {
		return receiverMobileNo;
	}

	public void setReceiverMobileNo(String receiverMobileNo) {
		this.receiverMobileNo = receiverMobileNo;
	}

	public String getReceiverEmailID() {
		return receiverEmailID;
	}

	public void setReceiverEmailID(String receiverEmailID) {
		this.receiverEmailID = receiverEmailID;
	}

	public String getReceiverAddressLine1() {
		return receiverAddressLine1;
	}

	public void setReceiverAddressLine1(String receiverAddressLine1) {
		this.receiverAddressLine1 = receiverAddressLine1;
	}

	public String getReceiverAddressLine2() {
		return receiverAddressLine2;
	}

	public void setReceiverAddressLine2(String receiverAddressLine2) {
		this.receiverAddressLine2 = receiverAddressLine2;
	}

	public String getReceiverCity() {
		return receiverCity;
	}

	public void setReceiverCity(String receiverCity) {
		this.receiverCity = receiverCity;
	}

	public String getReceiverPincode() {
		return receiverPincode;
	}

	public void setReceiverPincode(String receiverPincode) {
		this.receiverPincode = receiverPincode;
	}

	public String getSenderLandmark() {
		return senderLandmark;
	}

	public void setSenderLandmark(String senderLandmark) {
		this.senderLandmark = senderLandmark;
	}

	public String getReceiverLandmark() {
		return receiverLandmark;
	}

	public void setReceiverLandmark(String receiverLandmark) {
		this.receiverLandmark = receiverLandmark;
	}
	
	



}