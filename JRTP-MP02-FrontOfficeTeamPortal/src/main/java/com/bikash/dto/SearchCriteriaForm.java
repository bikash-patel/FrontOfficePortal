package com.bikash.dto;

import com.bikash.entity.UserAccount;

import lombok.Data;

@Data
public class SearchCriteriaForm {
	private UserAccount userAccount;
	private String courseName;
	private String enquiryStatus;
	private String classMode;
}
