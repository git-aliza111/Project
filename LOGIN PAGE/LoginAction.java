package com;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginAction extends Action{
@Override
public String execute(HttpServletRequest request, HttpServletResponse response) {
        
	String name=request.getParameter("uname");
	String pass=request.getParameter("upass");
	DBcon dbcon=new DBcon();
	boolean valid=dbcon.checkuser(name, pass);
	if(valid) {
		return "login.success";
	}
	else {
		return "login.register";
	}
	
     }
}
