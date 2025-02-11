package com.bikash.service;

import java.util.List;

import com.bikash.dto.AddEnquiryForm;
import com.bikash.dto.DashboardResponse;
import com.bikash.dto.SearchCriteriaForm;
import com.bikash.entity.CourseDetails;
import com.bikash.entity.EnquiryDetails;
import com.bikash.entity.EnquiryStatus;

public interface IEnquiryManagementService {
	
	public DashboardResponse getDashboard();
	
	public String addEnquiry(AddEnquiryForm addForm);
	
	public List<EnquiryDetails> viewEnquiry(Integer id);
	
	public List<EnquiryDetails> viewEnquiryWithFiltered(Integer id,SearchCriteriaForm searchCriteria);
	
	
	public String addStatus(EnquiryStatus status);
	
	public String addCourse(CourseDetails details);
	
	public List<String> getStatus();
	
	public List<String> getCourses();
	
	public EnquiryDetails getEditDetails(Integer id);
}


