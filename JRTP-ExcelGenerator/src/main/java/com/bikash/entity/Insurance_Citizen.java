package com.bikash.entity;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@Table(name = "Citizen_Plan_Info")
@AllArgsConstructor
@NoArgsConstructor
public class Insurance_Citizen {
	
	@Id
	@SequenceGenerator(name = "seq1",sequenceName = "insu_cit",initialValue = 1000,allocationSize = 1)
	@GeneratedValue(generator = "seq1",strategy = GenerationType.SEQUENCE)
	private Integer id;
	
	@Column(length = 30)
	private String name;
	
	@Column(length = 10)
	private String gender;
	
	@Column(length = 30)
	private String planName;
	
	@Column(length = 30)
	private String planStatus;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate planStartDate;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate planEndDate;
	
	private Double benifitAmmount;
	
	@Column(length = 30)
	private String denialReason;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate terminatedDate;
	
	@Column(length = 30)
	private String terminationReason;
}
