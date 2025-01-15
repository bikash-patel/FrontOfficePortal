package com.bikash.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bikash.dto.RequestInsuranceMapping;
import com.bikash.entity.Insurance_Citizen;
import com.bikash.service.IInsuuranceManagementService;

@Controller
public class MyInsuranceManagementController {
	
	@Autowired
	private IInsuuranceManagementService service;
	
	/**
	 * This method is responsible for open the form/index page with drop down option  
	 * @param map
	 * @param citizen
	 * @return String
	 */
	
	@GetMapping("/")
	public String insuranceReportPage(Map<String,Object> map,@ModelAttribute("ic") Insurance_Citizen citizen)
	{
		try {
			
			//List<Insurance_Citizen> list=service.getAllCitizen();
			//List<String> planList=list.stream().map(ls->ls.getPlanName()).distinct().collect(Collectors.toList());
			//List<String> planStatus=list.stream().map(ls->ls.getPlanStatus()).distinct().collect(Collectors.toList());
			//Above code and below code is also fine for extracting disting property
			
			init(map); //Insted of adding to shared memory here i am passing to init method
			           //for same operation
			System.out.println(citizen);
			return "report";
			
		} catch (Exception e) {
			 return e.getMessage();
		}
	}
	
	/**
	 * This method is used to generate report based of dynamic search
	 * @param page
	 * @param map
	 * @param mapping
	 * @return String
	 */
	@PostMapping("/report")
	public String insuranceSearchPage(@PageableDefault(page =0, size = 5, sort ="name", direction = Direction.ASC) Pageable pageable,Map<String,Object> map,@ModelAttribute("ic") RequestInsuranceMapping mapping)
	{
		try {
			//List<Insurance_Citizen> list=service.getAllCitizen(mapping);
			Page<Insurance_Citizen> pageList=service.getAllCitizenWithPagination(mapping,pageable);
			
			map.put("citizenList",pageList.getContent()); 
			//Can not iterate page directly so we need to get it content using get 
			//content method which return the list
			
			map.put("page",pageList);
			
			System.out.println(pageList.getTotalPages());
			System.out.println(pageList.getNumber());
			
			if(pageList.isEmpty())
				map.put("result","No Record Found");
				
			
			init(map); 

			//init(map): Updates shared memory with distinct plan names and statuses 
			//for dropdowns (to ensure dropdown options remain intact after form submission).

			
			return "report";
		} catch (Exception e) {
		    return e.getMessage();
		}
	}
	
	@GetMapping("/search")
	public String insuranceSearchPageWithPagination(@PageableDefault(page =0, size = 5, sort ="name", direction = Direction.ASC) Pageable pageable,Map<String,Object> map,@ModelAttribute("ic") RequestInsuranceMapping mapping)
	{
		try {
			//List<Insurance_Citizen> list=service.getAllCitizen(mapping);
			Page<Insurance_Citizen> pageList=service.getAllCitizenWithPagination(mapping,pageable);
			
			map.put("citizenList",pageList.getContent()); 
			//Can not iterate page directly so we need to get it content using get 
			//content method which return the list
			
			map.put("page",pageList);
			
			
			if(pageList.isEmpty())
				map.put("result","No Record Found");
				
			
			init(map); 
	
			
			return "report";
		} catch (Exception e) {
		    return e.getMessage();
		}
	}
	
	/**
	 * This method is used to generate excel file and send excel data to the mail id
	 * @param map1
	 * @return String
	 */
	
	@GetMapping("/excel")
	public String toExcelConverter(Map<String,Object> map1)
	{
		service.excelCreator();
		String msg=service.sentMail("excel");
		map1.put("result", msg);
		System.out.println(msg);
		return "forward:/";
	}
	
	/**
	 * This method is used to generate pdf file and send pdf data to the mail id
	 * @param map1
	 * @return String
	 */
	
	@GetMapping("/pdf")
	public String toPdfConverter(Map<String,Object> map1)
	{
		service.pdfCreator();
		String msg=service.sentMail("pdf");
		map1.put("result", msg);
		System.out.println(msg);
		return "forward:/";
	}
	
	/**
	 * This is method is to set plan name and plan status data into the drop down
	 * @param map
	 */
	private void init(Map<String,Object> map)
	{
		List<String> planList=service.getDistinctPlanNames();
		List<String> planStatus=service.getDistinctPlanStatus();
		map.put("planName",planList);
		map.put("planStatus",planStatus);
		System.out.println(planList);
		System.out.println(planStatus);
	}
}

