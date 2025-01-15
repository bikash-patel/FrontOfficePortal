package com.bikash.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.bikash.dto.RequestInsuranceMapping;
import com.bikash.entity.Insurance_Citizen;
import com.bikash.repository.MyInsuranceRepo;
import com.bikash.utils.ExcelService;
import com.bikash.utils.MailService;
import com.bikash.utils.PdfService;

@Service
public class MyInsuranceManagementServiceImpl implements IInsuuranceManagementService {

	@Autowired
	private MyInsuranceRepo repo;
	@Autowired
	private ExcelService excelService;
	@Autowired
	private PdfService pdfService;
	@Autowired
	private MailService mailService;
	
	@Override
	public String insertInBulk(List<Insurance_Citizen> list) {
		
		List<Integer> idList=repo.saveAll(list).stream().map(ls->ls.getId()).collect(Collectors.toList());
		return "Inserted with id : "+idList;
	}

	@Override
	public List<Insurance_Citizen> getAllCitizen(RequestInsuranceMapping reqMap) {
		
		Insurance_Citizen citizen=new Insurance_Citizen();
		
		//BeanUtils.copyProperties(reqMap,citizen);
		/*
		   Here we can not directly mapped because in reqMap some data contain null
		   value and some data is "" which means at the time of query it will try to
		   search data with "" which is not available in the database
		 */
		
		if(!reqMap.getPlanName().equals(null) && !reqMap.getPlanName().equals(""))
		{
			citizen.setPlanName(reqMap.getPlanName());
		}
		if(!reqMap.getPlanStatus().equals(null) && !reqMap.getPlanStatus().equals(""))
		{
			citizen.setPlanStatus(reqMap.getPlanStatus());
		}
		if(!reqMap.getGender().equals(null) && !reqMap.getGender().equals(""))
		{
			citizen.setGender(reqMap.getGender());
		}
		if(null!=reqMap.getPlanStartDate())
		{
			citizen.setPlanStartDate(reqMap.getPlanStartDate());
		}
		if(null!=reqMap.getPlanEndDate())
		{
			citizen.setPlanEndDate(reqMap.getPlanEndDate());
		}
		
		/*if(null!=reqMap.getPlanName() && ""!=reqMap.getPlanName())
		{
			citizen.setPlanName(reqMap.getPlanName());
		}
		if(null!=reqMap.getPlanStatus() && ""!=reqMap.getPlanStatus())
		{
			citizen.setPlanStatus(reqMap.getPlanStatus());
		}
		if(null!=reqMap.getGender() && ""!=reqMap.getGender())
		{
			citizen.setGender(reqMap.getGender());
		}
		if(null!=reqMap.getPlanStartDate())
		{
			citizen.setPlanStartDate(reqMap.getPlanStartDate());
		}
		if(null!=reqMap.getPlanEndDate())
		{
			citizen.setPlanEndDate(reqMap.getPlanEndDate());
		}*/
		List<Insurance_Citizen> list=repo.findAll(Example.of(citizen));
		//Example.of : It provides a flexible way to create queries without writing SQL or JPQL.
		
		return list;
	}

	@Override
	public List<String> getDistinctPlanNames() {
		List<String> planNames=repo.getDistinctPlanNames();
		return planNames;
	}
	
	@Override
	public List<String> getDistinctPlanStatus() {
		List<String> planStatus=repo.getDistinctPlanStatus();
		return planStatus;
	}

	@Override
	public String excelCreator() {
		String msg=excelService.writeDataToCsv();
		return msg;
	}

	@Override
	public String pdfCreator() {
		String msg=pdfService.pdfGenerator();
		return msg;
	}
	
	@Override
	public String sentMail(String choice) {
		String msg=mailService.sendMail(choice);
		return msg;
	}
	
	@Override
	public Page<Insurance_Citizen> getAllCitizenWithPagination(RequestInsuranceMapping reqMap, Pageable page) {

		Insurance_Citizen citizen=new Insurance_Citizen();
		
		if(!reqMap.getPlanName().equals(null) && !reqMap.getPlanName().equals(""))
		{
			citizen.setPlanName(reqMap.getPlanName());
		}
		if(!reqMap.getPlanStatus().equals(null) && !reqMap.getPlanStatus().equals(""))
		{
			citizen.setPlanStatus(reqMap.getPlanStatus());
		}
		if(!reqMap.getGender().equals(null) && !reqMap.getGender().equals(""))
		{
			citizen.setGender(reqMap.getGender());
		}
		if(null!=reqMap.getPlanStartDate())
		{
			citizen.setPlanStartDate(reqMap.getPlanStartDate());
		}
		if(null!=reqMap.getPlanEndDate())
		{
			citizen.setPlanEndDate(reqMap.getPlanEndDate());
		}
		
		Example<Insurance_Citizen> example=Example.of(citizen);
		Page<Insurance_Citizen> page1=repo.findAll(example,page);
		//Example.of : It provides a flexible way to create queries without writing SQL or JPQL.
		
		return page1;
	}

}
