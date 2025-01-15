package com.bikash.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.bikash.dto.RequestInsuranceMapping;
import com.bikash.entity.Insurance_Citizen;

public interface IInsuuranceManagementService {
	public String insertInBulk(List<Insurance_Citizen> list);
	public List<Insurance_Citizen> getAllCitizen(RequestInsuranceMapping reqMap);
	public Page<Insurance_Citizen> getAllCitizenWithPagination(RequestInsuranceMapping reqMap,Pageable page);
	public List<String> getDistinctPlanNames();
	public List<String> getDistinctPlanStatus();
	public String excelCreator();
	public String pdfCreator();
	public String sentMail(String choice);
}
