package com.bikash.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.bikash.entity.Insurance_Citizen;
import com.bikash.repository.MyInsuranceRepo;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class ExcelService {
	
	@Autowired
	private MyInsuranceRepo repo;
	
	public String writeDataToCsv(HttpServletResponse response,File file) throws Exception {
		
		//Create workbook / empty document
		Workbook book=new HSSFWorkbook();
		
		//Create sheet
		Sheet sheet=book.createSheet("Insurance-Citizen-Details");
		
		//Create 1st row in the sheet for header
		Row rowHeader=sheet.createRow(0);
		
		//Header of the excel
		String[] headerNames=new String[] {"Id","Name","Gender","Plan Name","Plan Status",
			"Plan Start Date","Plan End Date","Benifit Ammount",
			"Denial Reason","Terminate Date","Termination Reason"};
			
		int headerIndex=0;
		
		//Setting header data
		for(String h:headerNames)
		{
			rowHeader.createCell(headerIndex).setCellValue(h);
			headerIndex++;
		}
		
		List<Insurance_Citizen> list=repo.findAll();
		
		int rowIndex=1;
		for(Insurance_Citizen citizen:list)
		{
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
		
		//Write data to excel and save it to the desktop
		FileOutputStream fileStream=new FileOutputStream(new File("C:\\Users\\bikash patel\\Desktop\\insurance.xls"));
		book.write(fileStream);
		fileStream.close();
		
		//Write data to excel and show it to the browser , when will click it will download
		
		ServletOutputStream sos=response.getOutputStream();
		book.write(sos);
		book.close();
		
		return "Excel fil created ";
		
		//++++++++++++++++Either Above or Below ++++++++++++++++//
		
		/*try(CSVWriter writer=new CSVWriter(new FileWriter("C:\\Users\\bikash patel\\Desktop\\InsuranceData.csv"))){
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
		*/
	}
}
