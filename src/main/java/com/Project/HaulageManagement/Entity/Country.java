package com.Project.HaulageManagement.Entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "Country")
public class Country {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "hey, sorry!, please fill this")
	private String countryName;
	
	@OneToMany(mappedBy = "country" , targetEntity = State.class,cascade = CascadeType.ALL)
	List<State> list=new ArrayList<>();
	
	public Long getId() {
		return id;
	}

	public List<State> getList() {
		return list;
	}

	public void setList(List<State> list) {
		this.list = list;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
}


