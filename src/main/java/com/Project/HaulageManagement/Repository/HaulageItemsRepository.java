package com.Project.HaulageManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Project.HaulageManagement.Entity.HaulageItems;

@Repository
public interface HaulageItemsRepository extends JpaRepository<HaulageItems, Integer>{

}
