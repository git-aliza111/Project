package com;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterAction extends Action {
@Override
public String execute(HttpServletRequest request, HttpServletResponse response) {
	int uid=Integer.parseInt(request.getParameter("uid"));
	String uname=request.getParameter("uname");
	String upass=request.getParameter("upass");
	String city=request.getParameter("city");
	int flag=Integer.parseInt(request.getParameter("flag"));
	
	DBcon dbcon=new DBcon();
	int add=dbcon.register(uid, uname, upass, city, flag);
	if(add==1) {
		return "register.success";
	}
	else {
	return "register.failure";
	}
}
}
