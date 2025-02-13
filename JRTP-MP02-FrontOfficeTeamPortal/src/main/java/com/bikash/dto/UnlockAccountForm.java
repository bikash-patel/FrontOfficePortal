package com.bikash.dto;

import lombok.Data;

@Data
public class UnlockAccountForm {
	private String mailId;
	private String temporaryPassword;
	private String newPassword;
	private String confirmPassword;
}
