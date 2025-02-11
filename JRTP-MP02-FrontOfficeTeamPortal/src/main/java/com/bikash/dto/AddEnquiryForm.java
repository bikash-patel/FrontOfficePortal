package com.bikash.dto;

import lombok.Data;

@Data
public class AddEnquiryForm {
	
	private Integer enquiryId;
	
	private String studentName;
	
	private String studentMailId;
	
	private Long studPhoneNumber;
	
	private String classMode;
	
	private String courseName;
	
	private String enquiryStatus;
}
