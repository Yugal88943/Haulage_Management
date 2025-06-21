package com.Project.HaulageManagement.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Project.HaulageManagement.Entity.District;

@Repository
public interface DistrictRepository extends JpaRepository<District, Long>{

	public List<District> getDistrictByStateId(Long id);
	
}
	