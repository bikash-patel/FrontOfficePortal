package com.bikash.service;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bikash.entity.Insurance_Citizen;
import com.bikash.repository.MyInsuranceRepo;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class MyInsuranceManagementServiceImpl implements IInsuuranceManagementService {

	@Autowired
	private MyInsuranceRepo repository;
	
	@Override
	public void excelCreator(HttpServletResponse response) throws Exception {
		
		//Create an empty workbook
		Workbook workbook=new HSSFWorkbook();
		
		//Create a sheet in that
		Sheet sheet=workbook.createSheet("Insurance Details");
		
		//Create 1st row in thea sheet
		Row rowHeader=sheet.createRow(0);
		
		String[] header=new String[] {"Id","Name","Gender","Plan Name","Plan Status",
			"Plan Start Date","Plan End Date","Benifit Ammount",
			"Denial Reason","Terminate Date","Termination Reason"};
		
		int cellIndex=0;
		
		for(String h: header)
		{
			rowHeader.createCell(cellIndex).setCellValue(h); //In 1st header setting cell as header
			cellIndex++;
		}
		
		List<Insurance_Citizen> listCitizen=repository.findAll();
		
		int rowIndex=1; //Starting from 1 because 0 already booked for header 
		for(Insurance_Citizen citizen:listCitizen)
		{
			//Create row from 2nd row because already 1st row created for header in the sheet
			Row rowData=sheet.createRow(rowIndex);
			rowData.createCell(0).setCellValue(citizen.getId());
			rowData.createCell(1).setCellValue(citizen.getName());
			rowData.createCell(2).setCellValue(citizen.getGender());
			rowData.createCell(3).setCellValue(citizen.getPlanName());
			rowData.createCell(4).setCellValue(citizen.getPlanStatus());
			rowData.createCell(5).setCellValue(citizen.getPlanStartDate()+"");  //Adding empty string so that dat format data will be format correctly in excel
			rowData.createCell(6).setCellValue(citizen.getPlanEndDate()+"");
			rowData.createCell(7).setCellValue(citizen.getBenifitAmmount());
			rowData.createCell(8).setCellValue(citizen.getDenialReason()!=null?citizen.getDenialReason():"N/A");
			rowData.createCell(9).setCellValue(citizen.getTerminatedDate()!=null?citizen.getTerminatedDate()+"":"N/A");
			rowData.createCell(10).setCellValue(citizen.getTerminationReason()!=null?citizen.getTerminationReason():"N/A");
			
			rowIndex++;
		}
		
		
		//For downloading 
		ServletOutputStream stream=response.getOutputStream();
		workbook.write(stream);
		workbook.close();
		
		
		//For write data to the desktop
		try(FileOutputStream fos=new FileOutputStream(new File("C:\\Users\\bikash patel\\Desktop\\insurance.xls"))){
			workbook.write(fos);
			workbook.close();
			System.out.println("Created");
		} catch (Exception e) {
			e.printStackTrace();
			workbook.close();
			System.out.println("Not Created");
		}
	}

}
