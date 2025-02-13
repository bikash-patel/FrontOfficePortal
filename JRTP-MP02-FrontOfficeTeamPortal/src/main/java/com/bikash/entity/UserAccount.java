package com.bikash.entity;

import java.util.List;

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
import lombok.Data;

@Entity
@Data
@Table(name = "FO_User_Account_Details")
public class UserAccount {
	
	@Id
	@SequenceGenerator(name = "seq1", sequenceName = "FO_UA_SEQ1", initialValue = 1001, allocationSize = 1)
	@GeneratedValue(generator = "seq1",strategy = GenerationType.SEQUENCE)
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
	
	@OneToMany(targetEntity = EnquiryDetails.class,cascade = CascadeType.ALL, mappedBy = "userAcccount" ,orphanRemoval = true,fetch = FetchType.EAGER)
	List<EnquiryDetails> enquiry;

	
	
	//Custom toString()
	
	@Override
	public String toString() {
		return "UserAccount [userId=" + userId + ", userName=" + userName + ", mailId=" + mailId + ", phoneNumber="
				+ phoneNumber + ", password=" + password + ", accountStatus=" + accountStatus + "]";
	}
	
	
	
}
