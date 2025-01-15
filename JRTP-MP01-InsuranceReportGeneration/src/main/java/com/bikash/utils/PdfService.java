package com.bikash.utils;

import java.io.FileOutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bikash.entity.Insurance_Citizen;
import com.bikash.repository.MyInsuranceRepo;
import com.bikash.service.IInsuuranceManagementService;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

@Component
public class PdfService {
	
	@Autowired
	private MyInsuranceRepo repo;
	
	public String pdfGenerator()
	{
		String path="C:\\Users\\bikash patel\\Desktop\\InsuranceData.pdf";
		try{
			//Create a document instance
			Document doc=new Document();
			
			//Create pdfWriter to write content to the pdf
			PdfWriter.getInstance(doc,new FileOutputStream(path));
			
			//Open the document to write
			doc.open();
			
			//Setting font style for the paragraph
			Font titleFont=new Font(Font.FontFamily.HELVETICA,18,Font.BOLD);
			
			//Setting title of the paragraph
			Paragraph title=new Paragraph("Insurance Citizen Details", titleFont);
			
			//setting paragraph title at middle
			title.setAlignment(Paragraph.ALIGN_CENTER);
			
			//Adding heading 
			doc.add(title);
			
			//Add a new line
			doc.add(new Paragraph("\n"));
			
			//Create table with column 10
			PdfPTable table=new PdfPTable(10);
			//Setting width of the table
			table.setWidthPercentage(100);
			
			// Add headers
            String[] headers = {
                "Id", "Name", "Gender", "Plan Name", "Plan Status",
                "Plan Start Date", "Plan End Date", "Benefit Amount",
                "Denial Reason", "Terminate Date"
            };
			
			
            for (String header : headers) {
                PdfPCell headerCell = new PdfPCell(new Phrase(header));
                headerCell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                table.addCell(headerCell);
            }

            // Fetch data from the repository
            List<Insurance_Citizen> list=repo.findAll();

            // Add rows to the table
            for (Insurance_Citizen details : list) {
                table.addCell(String.valueOf(details.getId()));
                table.addCell(details.getName());
                table.addCell(details.getGender());
                table.addCell(details.getPlanName());
                table.addCell(details.getPlanStatus());
                table.addCell(details.getPlanStartDate().toString());
                table.addCell(details.getPlanEndDate().toString());
                table.addCell(String.valueOf(details.getBenifitAmmount()));
                table.addCell(details.getDenialReason());
                table.addCell(details.getTerminatedDate().toString());
            }

            // Add the table to the document
            doc.add(table);

            // Close the document
            doc.close();
			
			
		} catch (Exception e) {
			return e.getMessage();
		}
		return "Pdf generated";
	}
}
