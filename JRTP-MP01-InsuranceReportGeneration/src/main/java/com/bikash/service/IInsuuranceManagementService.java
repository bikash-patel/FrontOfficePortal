package com.bikash.service;

import java.io.File;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.bikash.dto.RequestInsuranceMapping;
import com.bikash.entity.Insurance_Citizen;

import jakarta.servlet.http.HttpServletResponse;

public interface IInsuuranceManagementService {
	public String insertInBulk(List<Insurance_Citizen> list);
	public List<Insurance_Citizen> getAllCitizen(RequestInsuranceMapping reqMap);
	public Page<Insurance_Citizen> getAllCitizenWithPagination(RequestInsuranceMapping reqMap,Pageable page);
	public List<String> getDistinctPlanNames();
	public List<String> getDistinctPlanStatus();
	public String excelCreator(HttpServletResponse response,File file) throws Exception;
	public String pdfCreator(HttpServletResponse response,File file) throws Exception;
	public String sentMail(String choice,File file);
}
