package com.bikash.dto;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import lombok.Data;
import lombok.NonNull;

@Data
@Component
public class RequestInsuranceMapping {
	
	
	@Column(length = 30)
	private String planName;
	
	@Column(length = 30)
	private String planStatus;
	
	@Column(length = 10)
	private String gender;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate planStartDate;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate planEndDate;
	
}
