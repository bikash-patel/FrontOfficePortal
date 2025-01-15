package com.bikash.utils;

import java.io.FileWriter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.bikash.entity.Insurance_Citizen;
import com.bikash.repository.MyInsuranceRepo;
import com.opencsv.CSVWriter;

@Controller
public class ExcelService {
	
	@Autowired
	private MyInsuranceRepo repo;
	
	public String writeDataToCsv() {
		
		try(CSVWriter writer=new CSVWriter(new FileWriter("C:\\Users\\bikash patel\\Desktop\\InsuranceData.csv"))){
			List<Insurance_Citizen> list=repo.findAll();
			writer.writeNext(new String[] {"Id","Name","Gender","Plan Name","Plan Status",
									"Plan Start Date","Plan End Date","Benifit Ammount",
									"Denial Reason","Terminate Date","Termination Reason"});
			for(Insurance_Citizen details:list)
			{
				writer.writeNext(new String[] {
										String.valueOf(details.getId()),
										details.getName(),
										details.getGender(),
										details.getPlanName(),
										details.getPlanStatus(),
										details.getPlanStartDate().toString(),
										details.getPlanEndDate().toString(),
										String.valueOf(details.getBenifitAmmount()),
										details.getDenialReason(),
										details.getTerminatedDate().toString(),
										details.getTerminationReason()
				});
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "CSV File Created";
	}
}
