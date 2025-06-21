package com.Project.HaulageManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Project.HaulageManagement.Entity.Purchase;


@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Long>  {

}
