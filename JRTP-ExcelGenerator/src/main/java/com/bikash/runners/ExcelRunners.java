package com.bikash.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import com.bikash.service.IInsuuranceManagementService;

public class ExcelRunners implements CommandLineRunner {

	@Autowired
	private IInsuuranceManagementService service;
	
	@Override
	public void run(String... args) throws Exception {
		try {
			service.excelCreator(null);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
