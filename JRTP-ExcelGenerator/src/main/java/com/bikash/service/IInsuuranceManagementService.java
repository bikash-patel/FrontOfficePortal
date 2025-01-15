package com.bikash.service;
import jakarta.servlet.http.HttpServletResponse;

public interface IInsuuranceManagementService {
	public String excelCreator(HttpServletResponse response) throws Exception;
}
