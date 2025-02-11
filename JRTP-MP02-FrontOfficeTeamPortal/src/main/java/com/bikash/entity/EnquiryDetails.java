package com.bikash.entity;

import java.time.LocalDate;

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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "FO_Enquiry_Details")
@AllArgsConstructor
@NoArgsConstructor
public class EnquiryDetails {
	
	@Id
	@SequenceGenerator(name = "enq_seq1", sequenceName = "FO_ENQUIRY_SEQ1", initialValue = 10000, allocationSize = 1)
	@GeneratedValue(generator = "enq_seq1",strategy = GenerationType.SEQUENCE)
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
	
	@ManyToOne(targetEntity = UserAccount.class,cascade = CascadeType.ALL)
	@JoinColumn(name ="USER_ID" ,referencedColumnName = "userId")
	private UserAccount userAcccount;

	
	//Custom toString()
	
	@Override
	public String toString() {
		return "EnquiryDetails [enquiryId=" + enquiryId + ", studentName=" + studentName + ", studentMailId="
				+ studentMailId + ", studPhoneNumber=" + studPhoneNumber + ", classMode=" + classMode + ", courseName="
				+ courseName + ", enquiryStatus=" + enquiryStatus + "]";
	}
	
	
	

}
