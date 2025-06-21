package com.Project.HaulageManagement.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Project.HaulageManagement.Entity.Haulage;
import com.Project.HaulageManagement.Entity.HaulageCustomer;
import com.Project.HaulageManagement.Repository.HaulageCustomerRepository;
import com.Project.HaulageManagement.Repository.HaulageReposiotry;

@Service
public class HaulageService {

	@Autowired
	HaulageReposiotry haulageReposiotry;
	@Autowired
	HaulageCustomerRepository haulageCustomerRepository;
	int count=0;
	public List<Haulage> getAll() {

		return haulageReposiotry.findAll();
	}

	public void saveHaulage(Haulage haulage, Boolean saveReceiver) {
//		String name, String mobileNo, String addressLine1, String addressLine2,
//		String city, String pincode, String emailId
		HaulageCustomer haulageCustomer = new HaulageCustomer(
				haulage.getSenderName(),
				haulage.getSenderMobileNo(),
				haulage.getAddressLine1(),
				haulage.getAddressLine2(),
				haulage.getSenderCity(),
				haulage.getSenderPincode(),
				haulage.getSenderEmailID(),
				haulage.getSenderDistrict()				
				);
		haulageCustomerRepository.save(haulageCustomer);
		haulage.setCustomer(haulageCustomer);
		

		HaulageCustomer receiverHaulageCustomer=null;
	if(saveReceiver) {
		
		 receiverHaulageCustomer = new HaulageCustomer(
				haulage.getReceiverName() , 
				haulage.getReceiverMobileNo(),
				haulage.getReceiverAddressLine1(),
				haulage.getReceiverAddressLine2(),
				haulage.getReceiverCity(),
				haulage.getReceiverPincode(),
				haulage.getReceiverEmailID(),
				haulage.getReceiverDistrict()
				
				 );
		 haulageCustomerRepository.save(receiverHaulageCustomer);
	}
	count++;
	haulage.setHaulage_Status("BOOKED");
	haulage.setSender_Tracking_Code("hlg00"+count);
	haulageReposiotry.save(haulage);
	
	haulageCustomer = haulageCustomerRepository.findById(haulageCustomer.getId()).get();
	
	haulageCustomer.setHaulageID(""+haulage.getId());
	haulageCustomerRepository.save(haulageCustomer);
	
	
//	haulageCustomerRepository.save(haulageCustomer);
	
	if (receiverHaulageCustomer != null) {
		receiverHaulageCustomer = haulageCustomerRepository.findById(receiverHaulageCustomer.getId()).get();
		haulageCustomerRepository.save(receiverHaulageCustomer);
	receiverHaulageCustomer.setHaulageID("" + haulage.getId());
//		
	}
	
	
}
	public List<Haulage> getHaulageByBookingCode(String BookingCode)
	{
		return haulageReposiotry.getHaulageByBookingCode(BookingCode);
		
	}
	public List<Haulage> getHaulageBooking()
	{
		return haulageReposiotry.findAll();
	}

	public void deletehaulage(Integer id) {
			
		haulageReposiotry.deleteById(id);
	}
}
