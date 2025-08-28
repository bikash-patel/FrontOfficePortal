package com.bikash.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Entity
@Table(name = "FO_User_Account_Details")
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class UserAccount {
	@Id
	@SequenceGenerator(name = "seq1", sequenceName = "FO_UA_SEQ1", initialValue = 1001, allocationSize = 1)
	@GeneratedValue(generator = "seq1", strategy = GenerationType.SEQUENCE)
	private Integer userId;
	@Column(length = 30)
	private String userName;
	@Column(length = 40)
	private String mailId;

	private Long phoneNumber;
	@Column(length = 30)
	private String password;
	@Column(length = 30)
	private String accountStatus;
	@OneToMany(targetEntity = EnquiryDetails.class, cascade = {
			CascadeType.ALL }, mappedBy = "userAcccount", orphanRemoval = true, fetch = FetchType.EAGER)
	List<EnquiryDetails> enquiry;

}
