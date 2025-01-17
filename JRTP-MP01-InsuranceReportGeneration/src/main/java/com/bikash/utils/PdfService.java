package com.bikash.utils;

import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bikash.entity.Insurance_Citizen;
import com.bikash.repository.MyInsuranceRepo;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import jakarta.servlet.http.HttpServletResponse;

@Component
public class PdfService {
	
	@Autowired
	private MyInsuranceRepo repo;
	
	public String pdfGenerator(HttpServletResponse response,File file)
	{
		try{
			//Create a document instance
			Document doc=new Document();
			
			//Create pdfWriter to write content to the PDF
			PdfWriter writer=PdfWriter.getInstance(doc,new FileOutputStream(file));
			
			//Create pdfWriter to write content to the browser
			PdfWriter writeToBrowser=PdfWriter.getInstance(doc,response.getOutputStream());
			
			//Open the document to write
			doc.open();
			
			//Setting font style for the paragraph
			//Font titleFont=new Font(Font.FontFamily.HELVETICA,18,Font.BOLD);
			Font titleFont=new Font(Font.HELVETICA,18,Font.BOLD,Color.CYAN);
			
			//Setting title of the paragraph
			Paragraph title=new Paragraph("Insurance Citizen Details", titleFont);
			
			//setting paragraph title at middle
			title.setAlignment(Paragraph.ALIGN_CENTER);
			
			//Create table with column 10
			PdfPTable table=new PdfPTable(11);
			//Setting width of the table
			table.setWidthPercentage(100);
	        table.setSpacingBefore(10f); // Space before the table
	        table.setSpacingAfter(10f); // Space after the table
						
			// Add headers
	        String[] header=new String[] {"Id","Name","Gender","Plan Name","Plan Status",
					"Plan Start Date","Plan End Date","Benifit Ammount",
					"Denial Reason","Terminate Date","Termination Reason"};
			
			
            for (String h : header) {
                table.addCell(h);
            }

            // Fetch data from the repository
            List<Insurance_Citizen> citizenList=repo.findAll();

            // Add rows to the table
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
            // Add the title to the document
			doc.add(title);
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
