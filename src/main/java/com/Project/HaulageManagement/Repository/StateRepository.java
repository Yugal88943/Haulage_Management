package com.Project.HaulageManagement.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Project.HaulageManagement.Entity.State;

@Repository
public interface StateRepository extends JpaRepository<State, Long>{

	List<State> getStateBycountry_id(Long id);
}
