package com.bikash.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bikash.appconst.AppConst;
import com.bikash.dto.AddEnquiryForm;
import com.bikash.dto.DashboardResponse;
import com.bikash.dto.SearchCriteriaForm;
import com.bikash.entity.EnquiryDetails;
import com.bikash.service.IEnquiryManagementService;

import jakarta.servlet.http.HttpSession;

@Controller
public class EnquiryManagementController {
	
	@Autowired
	private IEnquiryManagementService enquiryService;
	
	@Autowired
	private HttpSession session;
	
	@GetMapping("/dashboard")
	public String dashboardPage(Map<String,Object> map,@ModelAttribute("dashboard") DashboardResponse response)
	{
		DashboardResponse result=enquiryService.getDashboard();
		BeanUtils.copyProperties(result,response);
		map.put(AppConst.STR_RESP_KEY,result);
		return "dashboard";
	}
	
	@GetMapping("/addenquiry")
	public String addEnquiryPage(@ModelAttribute("enquiry") AddEnquiryForm enquiryForm,Map<String,Object> map)
	{
		loadSelectData(map);
		return "addenquiry";
	}
	
	@PostMapping("/addenquiry")
	public String addEnquiryData(@ModelAttribute("enquiry") AddEnquiryForm enquiryForm,RedirectAttributes red)
	{
		String successMsg=enquiryService.addEnquiry(enquiryForm);
		red.addFlashAttribute(AppConst.STR_SUCC_KEY,successMsg);
		return "redirect:/addenquiry";
	}
	
	@GetMapping("/editenquiry")
	public String editEnquiryPage(@RequestParam Integer enquiryId,@ModelAttribute("enquiry") AddEnquiryForm enquiryForm,Map<String,Object> map)
	{
		EnquiryDetails enquiryDetails=enquiryService.getEditDetails(enquiryId);
		BeanUtils.copyProperties(enquiryDetails,enquiryForm);
		
		//To load drop down data
		loadSelectData(map);
		
		return "editenquiry";
	}
	
	@GetMapping("/viewenquiry")
	public String viewEnquiryPage(Map<String,Object> map)
	{
		int id=(int) session.getAttribute(AppConst.STR_USERID);
		//Get enquiry details with given id
		List<EnquiryDetails> details=enquiryService.viewEnquiry(id);
		
		//To load drop down data
		loadSelectData(map);
		
		//set enquiry data
		map.put(AppConst.STR_ENQ_DATA_KEY,details);
		return "viewenquiry";
	}
	
	@GetMapping("/viewenquiry-filter")
	public String viewEnquiryPageWithFilter(Map<String,Object> map,@ModelAttribute SearchCriteriaForm searchForm)
	{
		int id=(int) session.getAttribute(AppConst.STR_USERID);
		//Get enquiry details with given id
		List<EnquiryDetails> details=enquiryService.viewEnquiryWithFiltered(id, searchForm);
		
		//To load drop down data
		loadSelectData(map);
				
		//set enquiry data
		map.put(AppConst.STR_ENQ_DATA_KEY,details);
		
		return "viewenquiryfilter";
	}
	public void loadSelectData(Map<String,Object> map)
	{
		        //get courses
				List<String> courses=enquiryService.getCourses();
				//get status
				List<String> status=enquiryService.getStatus();
				//Set courses to shared memory
				map.put(AppConst.STR_COURS_KEY,courses);
				//Set status to shared memory
				map.put(AppConst.STR_STATUS_KEY,status);
	}
	
}
