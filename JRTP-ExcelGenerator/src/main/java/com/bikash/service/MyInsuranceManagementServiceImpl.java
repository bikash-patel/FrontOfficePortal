package com.bikash.service;

import java.awt.Color;
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
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

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
		//Workbook workbook=new SXSSFWorkbook();
		
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

	@Override
	public void pdfCreator(HttpServletResponse response) throws Exception {
		
		//Step 1: Create document object ..Open docuement
		Document doc=new Document();
		
		//Step 2: Create Pdf writer and attached to the output stream
		PdfWriter pw=PdfWriter.getInstance(doc,response.getOutputStream());
		
		//Step 3: Open the document to write
		doc.open();
		
		//For decoration
		 Font titleFont = new Font(Font.HELVETICA, 20, Font.BOLD, Color.BLUE);
		
		
		//Step 4: Create a paragraph with your header
		Paragraph p=new Paragraph("Insurance Citizen Details",titleFont);
		
		//Set the paragraph to the middle
		p.setAlignment(Element.ALIGN_CENTER);
		
		//Step 5: Create table to insert into pdf document
		PdfPTable table=new PdfPTable(11);  //Here 11 is the number of column
		table.setWidthPercentage(100); // Set table width to 100% of the page
        table.setSpacingBefore(10f); // Space before the table
        table.setSpacingAfter(10f); // Space after the table
		
		//Step 6: Preparing table row header 
		String[] header=new String[] {"Id","Name","Gender","Plan Name","Plan Status",
				"Plan Start Date","Plan End Date","Benifit Ammount",
				"Denial Reason","Terminate Date","Termination Reason"};
			
		//Step 7: Add header
			for(String h: header)
			{
				table.addCell(h);
			}
			
		//Step 8: Get the data
			List<Insurance_Citizen> citizenList=repository.findAll();
			
		//Step 9: Add data into the table
			citizenList.forEach(citizen->{
								table.addCell(String.valueOf(citizen.getId()));
								table.addCell(citizen.getName());  //Converting int to String using String.valueOf method
								table.addCell(citizen.getGender());
							    table.addCell(citizen.getPlanName());
							    table.addCell(citizen.getPlanStatus());
							    table.addCell(citizen.getPlanStartDate()+"");
							    table.addCell(citizen.getPlanEndDate()+"");
							    table.addCell(String.valueOf(citizen.getBenifitAmmount())); //Converting double to String using String.valueOf method
							    table.addCell(citizen.getDenialReason()!=null?citizen.getDenialReason():"N/A");
							    table.addCell(citizen.getTerminatedDate()!=null?citizen.getTerminatedDate()+"":"N/A");
							    table.addCell(citizen.getTerminationReason()!=null?citizen.getTerminationReason():"N/A");
							    
			});
		
		//Step 10: Add the paragraph to the document
		doc.add(p);
		//Step 11: Add the table to the document
		doc.add(table);
		
		doc.close();
	}

}

