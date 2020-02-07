package com.StudentRegister;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import com.StudentRegister.DatabaseConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;






import java.sql.*;
import java.io.*;
import java.util.*;

/**
 * Servlet implementation class UpdateDetail
 */
@WebServlet("/UpdateDetail")
public class UpdateDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		PrintWriter out = response.getWriter();
		try {
			
			int id = Integer.parseInt(request.getParameter("id").trim());
			String firstName = request.getParameter("firstName");
			//response.getWriter().print(fname);
			String lastName = request.getParameter("lastName");
			String fatherName = request.getParameter("fatherName");
			String email = request.getParameter("email");
			int classStudent = Integer.parseInt(request.getParameter("class"));
			int age = Integer.parseInt(request.getParameter("age"));
			// Initialize the database 
			Connection con = DatabaseConnection.initializeDatabase();
			
			PreparedStatement ps = con.prepareStatement("UPDATE student SET firstName=?,lastName=?,fatherName=?,email=?,class=?,age=? WHERE studentId="+id);
			System.out.println(ps);
			ps.setString(1, firstName);
			ps.setString(2, lastName);
			ps.setString(3, fatherName);
			ps.setString(4, email);
			ps.setInt(5, classStudent);
			ps.setInt(6, age);
			ps.executeUpdate();
			//System.out.println(ps);
			
			//ps.setInt(7, id);
			
		}
		catch(SQLException sql)
		{
			out.println(sql);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		out.println("<html><body><b>Updated Succesfully !!!"
				+ "</b><br>");
	//To display the successful result
	
		out.println("<a href=index.html> Home  </a></body></html>");


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
