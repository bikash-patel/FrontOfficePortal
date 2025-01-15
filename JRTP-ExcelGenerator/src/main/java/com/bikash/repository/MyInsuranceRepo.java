package com.bikash.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.bikash.entity.Insurance_Citizen;

public interface MyInsuranceRepo extends JpaRepository<Insurance_Citizen,Integer> {
}
