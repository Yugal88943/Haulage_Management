package com.Project.HaulageManagement.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
@Entity
public class HaulageItems {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer Id;
	Integer length;
	Double width;
	Double height;
	Double volumetricWeight;
	Double weight;
	
	@ManyToOne()
	@JoinColumn(name="haulage_id")
	Haulage haulage;
	
	String fragile;//Yes or No
	
	public Integer getLength() {
		return length;
	}
	public void setLength(Integer length) {
		this.length = length;
	}
	public Double getHeight() {
		return height;
	}
	public void setHeight(Double height) {
		this.height = height;
	}
	
	
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public Double getWidth() {
		return width;
	}
	public void setWidth(Double width) {
		this.width = width;
	}
	
	public Double getVolumetricWeight() {
		return volumetricWeight;
	}
	public void setVolumetricWeight(Double volumetricWeight) {
		this.volumetricWeight = volumetricWeight;
	}
	public Double getWeight() {
		return weight;
	}
	public void setWeight(Double weight) {
		this.weight = weight;
	}
	public String getFragile() {
		return fragile;
	}
	public void setFragile(String fragile) {
		this.fragile = fragile;
	}
	public Haulage getHualage() {
		return haulage;
	}
	public void setHualage(Haulage haulage) {
		this.haulage = haulage;
	}
	
}
