package com.Project.HaulageManagement.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Project.HaulageManagement.Entity.Country;
import com.Project.HaulageManagement.Repository.CountryRepository;

@Service
public class CountryService {

	@Autowired
	CountryRepository countryRepository;

	public List<Country> getAll() {

		return countryRepository.findAll();
	}

	public void saveCountry(Country country) {
		countryRepository.save(country);

	}

	@SuppressWarnings("deprecation")
	public Country udpate(Long id) {

		return countryRepository.getOne(id);
	}

	@SuppressWarnings("deprecation")
	public Country getOneObject(Long id) {
		
		return countryRepository.getById(id);
	}	
	public void delete(Long id) {
		Country country= getOneObject(id);
		countryRepository.delete(country);

	}

	public boolean existCountry( Country country) {

		boolean b = false;
		if (countryRepository.existCountry(country.getCountryName()) != null) {

			b = true;
		}
		return b;
	}
}
