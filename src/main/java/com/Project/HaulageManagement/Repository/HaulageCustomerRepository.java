package com.Project.HaulageManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Project.HaulageManagement.Entity.HaulageCustomer;

@Repository
public interface HaulageCustomerRepository extends JpaRepository<HaulageCustomer, Integer>{

}
