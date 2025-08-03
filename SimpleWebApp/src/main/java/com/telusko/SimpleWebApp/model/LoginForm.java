package com.telusko.SimpleWebApp.model;

import org.hibernate.annotations.processing.Pattern;

public class LoginForm {
	
	
	private String FName;
	private String LName;
	@Email
	@Pattern(value="@")
	private String Email;
	
	private Long TelNo;

}
