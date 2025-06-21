package com.Project.HaulageManagement.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Project.HaulageManagement.Entity.Haulage;

@Repository
public interface HaulageReposiotry extends JpaRepository<Haulage, Integer>{

	List<Haulage> getHaulageByBookingCode(String bookingCode);

//	void save(HaulageCustomer haulageCustomer);

}
