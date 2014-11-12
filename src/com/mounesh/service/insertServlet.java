package com.mounesh.service;

import java.io.IOException;
import java.sql.*;
import java.io.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class insertServlet
 */
//@WebServlet("/insertServlet")
public class insertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		String fname=request.getParameter("first_name");
		String lname=request.getParameter("last_name");
		String email=request.getParameter("email_id");
		String usrname=request.getParameter("user_name");
		String pswd1=request.getParameter("password1");
		String pswd2=request.getParameter("password2");
		
		session.setAttribute("firstName",fname);
		
		//ResultSet rs;
		 Connection con=null;
	        Statement stmt=null;
	        PrintWriter out=response.getWriter();
	        try
	        {
	              Class.forName("com.mysql.jdbc.Driver");
	              con = DriverManager.getConnection("jdbc:mysql://localhost/test2","root","root123");
	              stmt=con.createStatement();
	           // int i=stmt.executeUpdate("INSERT INTO signup (first_name, last_name, email_id, user_name, password1, password2) VALUES ('fname','lname','email1','usrname','pswd1','pswd2')");
	             /* String sql="INSERT INTO signup (first_name, last_name, email_id, user_name, password1, password2) VALUES ('fname','lname','email','usrname','pswd1','pswd2')";
	              PreparedStatement prep=con.prepareStatement(sql);
	              prep.setString(1,fname);
	              prep.setString(2,lname);
	              prep.setString(3,email);
	              prep.setString(6,usrname);
	              prep.setString(4,pswd1);
	              prep.setString(5,pswd2);
	              int i= stmt.executeUpdate(sql);*/
	              
	              int i = stmt.executeUpdate("INSERT INTO Test2.signup VALUES('"+fname+"','"+lname+"','"+email+"','"+usrname+"','"+pswd1+"','"+pswd2+"')");
	              if(i>0){
	                out.println("Inserted Successfully");
	                RequestDispatcher rd=request.getRequestDispatcher("/Login.jsp");  
	                rd.forward(request, response);  
	                /*String sql1= "SELECT *FROM signup";
	               
	                ResultSet rs = stmt.executeQuery(sql1);
	              while(rs.next()){
	            	   fname=rs.getString("first_name");
	            	   lname=rs.getString("last_name");
	            	   email=rs.getString("email_id");
	            	   usrname=rs.getString("user_name");
	            	 
	            	  
	              }
	              out.println("FN: " + fname + "<br>");
            	  out.println("LN: " + lname+ "<br>");
            	  out.println("EM: " + email + "<br>");
            	  out.println("UN: " + usrname + "<br>");*/
	              }
	              else
	                out.println("Insert Unsuccessful");
	        }
	        catch(Exception e)
	        {
	          out.println(e);       
	        }
	    }
	
	}
				