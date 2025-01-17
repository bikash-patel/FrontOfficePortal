package com.bikash.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bikash.entity.Insurance_Citizen;

public interface MyInsuranceRepo extends JpaRepository<Insurance_Citizen,Integer> {
	
	@Query("select DISTINCT planName from Insurance_Citizen")
	public List<String> getDistinctPlanNames();
	
	@Query("select DISTINCT planStatus from Insurance_Citizen")
	public List<String> getDistinctPlanStatus();
}
