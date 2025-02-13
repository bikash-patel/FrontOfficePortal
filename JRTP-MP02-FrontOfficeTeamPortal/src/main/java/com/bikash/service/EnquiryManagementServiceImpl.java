package com.bikash.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.bikash.appconst.AppConst;
import com.bikash.dto.AddEnquiryForm;
import com.bikash.dto.DashboardResponse;
import com.bikash.dto.SearchCriteriaForm;
import com.bikash.entity.CourseDetails;
import com.bikash.entity.EnquiryDetails;
import com.bikash.entity.EnquiryStatus;
import com.bikash.entity.UserAccount;
import com.bikash.repository.CourseDetailsRepo;
import com.bikash.repository.EnquiryDetailsRepo;
import com.bikash.repository.EnquiryStatusRepo;
import com.bikash.repository.UserAccountRepo;

import jakarta.servlet.http.HttpSession;

@Service
public class EnquiryManagementServiceImpl implements IEnquiryManagementService {

	@Autowired
	private EnquiryDetailsRepo repo;
	
	@Autowired
	private CourseDetailsRepo courseRepo;	
	
	@Autowired
	private EnquiryStatusRepo statusRepo;
	
	@Autowired
	private UserAccountRepo userRepo;
	
	@Autowired
	private HttpSession session;
	
	@Override
	public DashboardResponse getDashboard() {
		
		Integer id=(Integer) session.getAttribute(AppConst.STR_USERID);
		Optional<UserAccount> opt=userRepo.findById(id);
		List<EnquiryDetails> listEnquiry=null;
		if(opt.isPresent())
		{
			UserAccount account=opt.get();
			listEnquiry=account.getEnquiry();
		}
		Integer totalEnquiry=listEnquiry!=null?listEnquiry.size():0;
		Long enrolledStudent=listEnquiry!=null?listEnquiry.stream().filter(list->list.getEnquiryStatus().equalsIgnoreCase(AppConst.STR_ENROLLED)).count():0;
		Long lostStudent=listEnquiry!=null?listEnquiry.stream().filter(list->list.getEnquiryStatus().equalsIgnoreCase(AppConst.STR_LOST)).count():0;
		DashboardResponse response=new DashboardResponse();
		response.setTotalEnquiry(totalEnquiry);
		response.setEnrollStudent(enrolledStudent);
		response.setLostStudent(lostStudent);
		return response;
	}

	@Override
	public String addEnquiry(AddEnquiryForm addForm) {
		
		//Update logic
		Optional<EnquiryDetails> opt=repo.findById(addForm.getEnquiryId());
		if(opt.isPresent())
		{
			EnquiryDetails details=opt.get();
			BeanUtils.copyProperties(addForm,details);
			repo.save(details);
			return AppConst.STR_ENQ_DTLS_UPDATE;
		}
		
		//New Addition logic
		EnquiryDetails details=new EnquiryDetails();
		BeanUtils.copyProperties(addForm,details);
		//Set Enquiry Date
		details.setEnquiryDate(LocalDate.now());
		
		//Set User details
		Optional<UserAccount> optAcc=userRepo.findById((Integer)session.getAttribute(AppConst.STR_USERID));
		if(optAcc.isPresent())
		{
			UserAccount account=optAcc.get();
			details.setUserAcccount(account);
		}
		
		
		
		//Save the data
		repo.save(details);
		return AppConst.STR_ENQ_DTLS_SAVE;
	}

	@Override
	public List<EnquiryDetails> viewEnquiry(Integer id) {
		Optional<UserAccount> opt=userRepo.findById(id);
		if(opt.isPresent())
		{
			UserAccount account=opt.get();
			return account.getEnquiry();
		}
		return Collections.emptyList();
	}
	
	@Override
	public List<EnquiryDetails> viewEnquiryWithFiltered(Integer id, SearchCriteriaForm searchCriteria) {
		
		EnquiryDetails enquiryDetails=new EnquiryDetails();
		
		if(searchCriteria.getCourseName()!=null && searchCriteria.getCourseName()!="")
		{
			enquiryDetails.setCourseName(searchCriteria.getCourseName());
		}
		if(searchCriteria.getEnquiryStatus()!=null && searchCriteria.getEnquiryStatus()!="")
		{
			enquiryDetails.setEnquiryStatus(searchCriteria.getEnquiryStatus());
		}
		if(searchCriteria.getClassMode()!=null && searchCriteria.getClassMode()!="")
		{
			enquiryDetails.setClassMode(searchCriteria.getClassMode());
		}
		
		Optional<UserAccount> account=userRepo.findById(id);
		if(account.isPresent())
		{
			enquiryDetails.setUserAcccount(account.get());
		}
		
		return repo.findAll(Example.of(enquiryDetails));
	}

	@Override
	public String addCourse(CourseDetails details) {
		int id=courseRepo.save(details).getCourseId();
		return AppConst.STR_CRS_ADDED_WITH_ID+id;
	}
	
	@Override
	public String addStatus(EnquiryStatus status) {
		int id=statusRepo.save(status).getEnquiryId();
		return AppConst.STR_STS_ADDED_WITH_ID+id;
	}

	@Override
	public List<String> getStatus() {
		return statusRepo.getStatus();
	}

	@Override
	public List<String> getCourses() {
		return courseRepo.getCourses();
	}

	@Override
	public EnquiryDetails getEditDetails(Integer id) {
		Optional<EnquiryDetails> opt=repo.findById(id);
		EnquiryDetails enquiryDetails=null;
		if(opt.isPresent())
		{
			enquiryDetails=opt.get();
		}
		return enquiryDetails;
	}

}
