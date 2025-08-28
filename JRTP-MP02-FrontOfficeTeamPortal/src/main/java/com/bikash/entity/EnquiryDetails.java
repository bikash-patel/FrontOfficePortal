package com.bikash.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "FO_Enquiry_Details")
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class EnquiryDetails {
	@Id
	@SequenceGenerator(name = "enq_seq1", sequenceName = "FO_ENQUIRY_SEQ1", initialValue = 10000, allocationSize = 1)
	@GeneratedValue(generator = "enq_seq1", strategy = GenerationType.SEQUENCE)
	private Integer enquiryId;
	@Column(length = 30)
	private String studentName;
	@Column(length = 40)
	private String studentMailId;
	private Long studPhoneNumber;
	@Column(length = 30)
	private String classMode;
	@Column(length = 30)
	private String courseName;
	private LocalDate enquiryDate;
	@Column(length = 30)
	private String enquiryStatus;
	@ManyToOne(targetEntity = UserAccount.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "USER_ID", referencedColumnName = "userId")
	private UserAccount userAcccount;

}
