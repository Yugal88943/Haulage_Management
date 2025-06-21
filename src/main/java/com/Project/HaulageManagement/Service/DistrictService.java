package com.Project.HaulageManagement.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Project.HaulageManagement.Entity.District;
import com.Project.HaulageManagement.Repository.DistrictRepository;

@Service
public class DistrictService {

	@Autowired
	private DistrictRepository districtRepository;

	public List<District> getAll() {

		return districtRepository.findAll();
	}

	public void saveDistrict(District district) {

		districtRepository.save(district);

	}

	public District update(Long id) {

		return districtRepository.findById(id).get();
	}

	public void delete(Long id) {

		districtRepository.deleteById(id);
	}

	public List<District> getDistrictByStateId(Long id) {

		return districtRepository.getDistrictByStateId(id);
	}

}
