package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class DBcon {
public DBcon() {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(Exception e) {}
      }

public boolean checkuser(String uname,String upass) {
	try {
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost/August","root","root");
		PreparedStatement ps=con.prepareStatement("select * from aliza where uname=? and upass=?");
		ps.setString(1, uname);
		ps.setString(2, upass);
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
			return true;
		}
		else {
			return false;
		}
	}catch(Exception e) {}
	return false;
  }

public int register(int uid,String uname,String upass,String city,int flag) {
	try {
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost/August","root","root");
		PreparedStatement ps=con.prepareStatement("insert into aliza values(?,?,?,?,?)");
		ps.setInt(1, uid );
		ps.setString(2, uname);
		ps.setString(3, upass);
		ps.setString(4, city);
		ps.setInt(5, flag);
		int i=ps.executeUpdate();
		return i;
	}catch(Exception e) {
		return 0;
		}
}

public static void main(String[] args) {

	DBcon dbcom=new DBcon();
//	System.out.println(dbcon.checkuser("dwwe", "yasir111"));
	int add=dbcom.register(4, "lizaaa","liza111","punee",0);
	System.out.println(add+" user added...");
	System.out.println(dbcom.checkuser("lizaaa", "liza111"));
  }
}