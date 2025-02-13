package com.bikash.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "FO_Enquiry_Status")
public class EnquiryStatus {
	
	@Id
	@SequenceGenerator(name = "seq1", sequenceName = "FO_ENQUIRYSTS_SEQ1", initialValue = 1, allocationSize = 1)
	@GeneratedValue(generator = "seq1",strategy = GenerationType.SEQUENCE)
	private Integer enquiryId;
	
	@Column(length = 30)
	private String status;
	}
