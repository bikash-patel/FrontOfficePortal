package com.bikash.controller;

import java.io.File;
import java.time.LocalDate;
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
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bikash.dto.RequestInsuranceMapping;
import com.bikash.entity.Insurance_Citizen;
import com.bikash.service.IInsuuranceManagementService;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class MyInsuranceManagementController {
	@Autowired
	private IInsuuranceManagementService service;
	Page<Insurance_Citizen> pageList;
	
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
			return "report";
			
		} catch (Exception e) {
			map.put("errorMsg",e.getMessage());
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
	public String insuranceSearchPage(@PageableDefault(page =0, size = 5,direction = Direction.ASC) Pageable pageable,
									Map<String,Object> map,
									@ModelAttribute("ic") RequestInsuranceMapping mapping)
	{
		try {
			//List<Insurance_Citizen> list=service.getAllCitizen(mapping);
			pageList=service.getAllCitizenWithPagination(mapping,pageable);
			
			//Can not iterate page directly so we need to get it content using get 
			//content method which return the list
			map.put("citizenList",pageList.getContent()); 
			
			
			map.put("page",pageList);
			
			
			map.put("name",mapping.getPlanName());
			map.put("status",mapping.getPlanStatus());
			map.put("gender",mapping.getGender());
			map.put("startdate",mapping.getPlanStartDate());
			map.put("enddate",mapping.getPlanEndDate());
			
			if(pageList.isEmpty())
				map.put("result","No Record Found");
	
			
			init(map); 
			//init(map): Updates shared memory with distinct plan names and statuses 
			//for dropdowns (to ensure dropdown options remain intact after form submission).
	
			
			return "report";
			
		} catch (Exception e) {
			map.put("errorMsg",e.getMessage());
		    return e.getMessage();
		}
	}
	
	@GetMapping("/search")
	public String insuranceSearchPageWithPagination(@PageableDefault(page =0, size = 5,direction = Direction.ASC) Pageable pageable,
													Map<String,Object> map,
												
													@ModelAttribute("ic") RequestInsuranceMapping mapping)
	{
		try {
			pageList=service.getAllCitizenWithPagination(mapping,pageable);
			map.put("citizenList",pageList.getContent()); 
			//Can not iterate page directly so we need to get it content using get 
			//content method which return the list
			
			map.put("page",pageList);
			
			map.put("name",mapping.getPlanName());
			map.put("status",mapping.getPlanStatus());
			map.put("gender",mapping.getGender());
			map.put("startdate",mapping.getPlanStartDate());
			map.put("enddate",mapping.getPlanEndDate());
			
			if(pageList.isEmpty())
				map.put("result","No Record Found");
				
			init(map); 
			
			return "report";
		} catch (Exception e) {
			map.put("errorMsg",e.getMessage());
		    return e.getMessage();
		}
	}
	
	
	/**
	 * This method is used to generate excel file and send excel data to the mail id
	 * @param map1
	 * @return String
	 */
	
	@GetMapping("/excel")
	public void toExcelConverter(Map<String,Object> map1,HttpServletResponse response)
	{
		try {
			//If we want to provide download activity then below two line is important
			response.setContentType("application/octet-stream");
			response.setHeader("Content-Disposition","attachment; filename=insurance-citizen-report.xls");
			
			File file=new File("C:\\Users\\bikash patel\\Desktop\\insurance.xls");
			service.excelCreator(response,file);
			String msg=service.sentMail("excel",file);
			file.delete(); //Once mail send we don't want to keep in our system 
			map1.put("result", msg);
			System.out.println(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This method is used to generate pdf file and send pdf data to the mail id
	 * @param map1
	 * @return String
	 */
	
	@GetMapping("/pdf")
	public void toPdfConverter(Map<String,Object> map1,HttpServletResponse response)
	{
		try {
			
			response.setContentType("application/pdf");
			response.setHeader("Content-Disposition","attachment; filename=insurance-citizen-report.pdf");
			
			File file=new File("C:\\Users\\bikash patel\\Desktop\\InsuranceData.pdf");
			service.pdfCreator(response,file);
			String msg=service.sentMail("pdf",file);
			file.delete(); //Once mail send we don't want to keep in our system
			map1.put("result", msg);
			System.out.println(msg);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

