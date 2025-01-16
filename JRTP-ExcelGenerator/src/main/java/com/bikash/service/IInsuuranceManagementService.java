package com.bikash.service;
import jakarta.servlet.http.HttpServletResponse;

public interface IInsuuranceManagementService {
	public void excelCreator(HttpServletResponse response) throws Exception;
	public void pdfCreator(HttpServletResponse response) throws Exception;
}
