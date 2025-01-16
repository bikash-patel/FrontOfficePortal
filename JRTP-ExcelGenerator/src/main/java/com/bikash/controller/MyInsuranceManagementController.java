package com.bikash.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.bikash.service.IInsuuranceManagementService;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class MyInsuranceManagementController {
	
	@Autowired
	private IInsuuranceManagementService service;
	
	/**
	 * Welcome page 
	 * @return
	 */
	@GetMapping("/")
	public String welcome()
	{		
		return "welcome";
	}
	
	
	/**
	 * Excel generator page
	 * @param response
	 * @throws Exception
	 */
	@GetMapping("/excel")
	public void toExcelConverter(HttpServletResponse response) throws Exception
	{		
		response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition","attachment ; filename=insurance-data.xls");
		service.excelCreator(response);
	}
	
	/**
	 * Pdf generator page
	 * @param response
	 * @throws Exception
	 */
	@GetMapping("/pdf")
	public void toPdfConverter(HttpServletResponse response) throws Exception
	{		
		response.setContentType("application/pdf");
		response.setHeader("Content-Disposition","attachment ; filename=insurance-data.pdf");
		service.pdfCreator(response);
	}
}