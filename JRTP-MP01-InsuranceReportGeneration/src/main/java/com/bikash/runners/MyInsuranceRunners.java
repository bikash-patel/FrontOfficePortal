package com.bikash.runners;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.bikash.entity.Insurance_Citizen;
import com.bikash.service.IInsuuranceManagementService;

@Component
public class MyInsuranceRunners implements CommandLineRunner {

	@Autowired
	private IInsuuranceManagementService service;
	@Override
	public void run(String... args) throws Exception {
		
		try {
			/*
			 * Insurance_Citizen citizen11 = new Insurance_Citizen(); citizen11.setId(null);
			 * citizen11.setName("Aryan Raj"); citizen11.setGender("Male");
			 * citizen11.setPlanName("Accident Cover Plan");
			 * citizen11.setPlanStatus("Active");
			 * citizen11.setPlanStartDate(LocalDate.of(2023, 6, 1));
			 * citizen11.setPlanEndDate(LocalDate.of(2025, 6, 1));
			 * citizen11.setBenifitAmmount(300000.0); citizen11.setDenialReason(null);
			 * citizen11.setTerminatedDate(null); citizen11.setTerminationReason(null);
			 * 
			 * Insurance_Citizen citizen12 = new Insurance_Citizen(); citizen12.setId(null);
			 * citizen12.setName("Ishika Sharma"); citizen12.setGender("Female");
			 * citizen12.setPlanName("Maternity Care Plan");
			 * citizen12.setPlanStatus("Denied");
			 * citizen12.setPlanStartDate(LocalDate.of(2023, 7, 1));
			 * citizen12.setPlanEndDate(LocalDate.of(2024, 7, 1));
			 * citizen12.setBenifitAmmount(0.0);
			 * citizen12.setDenialReason("Eligibility Criteria Not Met");
			 * citizen12.setTerminatedDate(null); citizen12.setTerminationReason(null);
			 * 
			 * Insurance_Citizen citizen13 = new Insurance_Citizen(); citizen13.setId(null);
			 * citizen13.setName("Rahul Patel"); citizen13.setGender("Male");
			 * citizen13.setPlanName("Senior Citizen Health Plan");
			 * citizen13.setPlanStatus("Terminated");
			 * citizen13.setPlanStartDate(LocalDate.of(2022, 1, 1));
			 * citizen13.setPlanEndDate(LocalDate.of(2023, 1, 1));
			 * citizen13.setBenifitAmmount(200000.0); citizen13.setDenialReason(null);
			 * citizen13.setTerminatedDate(LocalDate.of(2022, 12, 1));
			 * citizen13.setTerminationReason("Claim Limit Exhausted");
			 * 
			 * Insurance_Citizen citizen14 = new Insurance_Citizen(); citizen14.setId(null);
			 * citizen14.setName("Simran Kaur"); citizen14.setGender("Female");
			 * citizen14.setPlanName("Child Secure Plan");
			 * citizen14.setPlanStatus("Active");
			 * citizen14.setPlanStartDate(LocalDate.of(2021, 3, 1));
			 * citizen14.setPlanEndDate(LocalDate.of(2031, 3, 1));
			 * citizen14.setBenifitAmmount(1500000.0); citizen14.setDenialReason(null);
			 * citizen14.setTerminatedDate(null); citizen14.setTerminationReason(null);
			 * 
			 * Insurance_Citizen citizen15 = new Insurance_Citizen(); citizen15.setId(null);
			 * citizen15.setName("Ravi Mehta"); citizen15.setGender("Male");
			 * citizen15.setPlanName("Travel Insurance Plan");
			 * citizen15.setPlanStatus("Denied");
			 * citizen15.setPlanStartDate(LocalDate.of(2023, 10, 1));
			 * citizen15.setPlanEndDate(LocalDate.of(2024, 10, 1));
			 * citizen15.setBenifitAmmount(0.0);
			 * citizen15.setDenialReason("Incomplete Documentation");
			 * citizen15.setTerminatedDate(null); citizen15.setTerminationReason(null);
			 * 
			 * Insurance_Citizen citizen16 = new Insurance_Citizen(); citizen16.setId(null);
			 * citizen16.setName("Neha Tiwari"); citizen16.setGender("Female");
			 * citizen16.setPlanName("Life Secure Plan");
			 * citizen16.setPlanStatus("Terminated");
			 * citizen16.setPlanStartDate(LocalDate.of(2021, 5, 1));
			 * citizen16.setPlanEndDate(LocalDate.of(2023, 5, 1));
			 * citizen16.setBenifitAmmount(500000.0); citizen16.setDenialReason(null);
			 * citizen16.setTerminatedDate(LocalDate.of(2022, 8, 15));
			 * citizen16.setTerminationReason("Premium Payment Default");
			 * 
			 * Insurance_Citizen citizen17 = new Insurance_Citizen(); citizen17.setId(null);
			 * citizen17.setName("Arjun Nair"); citizen17.setGender("Male");
			 * citizen17.setPlanName("Corporate Health Plan");
			 * citizen17.setPlanStatus("Active");
			 * citizen17.setPlanStartDate(LocalDate.of(2023, 9, 1));
			 * citizen17.setPlanEndDate(LocalDate.of(2024, 9, 1));
			 * citizen17.setBenifitAmmount(600000.0); citizen17.setDenialReason(null);
			 * citizen17.setTerminatedDate(null); citizen17.setTerminationReason(null);
			 * 
			 * Insurance_Citizen citizen18 = new Insurance_Citizen(); citizen18.setId(null);
			 * citizen18.setName("Tanya Gupta"); citizen18.setGender("Female");
			 * citizen18.setPlanName("Education Savings Plan");
			 * citizen18.setPlanStatus("Active");
			 * citizen18.setPlanStartDate(LocalDate.of(2020, 4, 1));
			 * citizen18.setPlanEndDate(LocalDate.of(2030, 4, 1));
			 * citizen18.setBenifitAmmount(1200000.0); citizen18.setDenialReason(null);
			 * citizen18.setTerminatedDate(null); citizen18.setTerminationReason(null);
			 * 
			 * Insurance_Citizen citizen19 = new Insurance_Citizen(); citizen19.setId(null);
			 * citizen19.setName("Vikram Sharma"); citizen19.setGender("Male");
			 * citizen19.setPlanName("Accidental Cover Plan");
			 * citizen19.setPlanStatus("Denied");
			 * citizen19.setPlanStartDate(LocalDate.of(2023, 2, 1));
			 * citizen19.setPlanEndDate(LocalDate.of(2024, 2, 1));
			 * citizen19.setBenifitAmmount(0.0);
			 * citizen19.setDenialReason("Age Restriction");
			 * citizen19.setTerminatedDate(null); citizen19.setTerminationReason(null);
			 * 
			 * Insurance_Citizen citizen20 = new Insurance_Citizen(); citizen20.setId(null);
			 * citizen20.setName("Kiran Shetty"); citizen20.setGender("Female");
			 * citizen20.setPlanName("Health Plus Family Plan");
			 * citizen20.setPlanStatus("Active");
			 * citizen20.setPlanStartDate(LocalDate.of(2023, 8, 1));
			 * citizen20.setPlanEndDate(LocalDate.of(2025, 8, 1));
			 * citizen20.setBenifitAmmount(800000.0); citizen20.setDenialReason(null);
			 * citizen20.setTerminatedDate(null); citizen20.setTerminationReason(null);
			 * 
			 * List<Insurance_Citizen> citizens = List.of( citizen11, citizen12, citizen13,
			 * citizen14, citizen15, citizen16, citizen17, citizen18, citizen19, citizen20
			 * ); String msg=service.insertInBulk(citizens); System.out.println(msg);
			 */
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
