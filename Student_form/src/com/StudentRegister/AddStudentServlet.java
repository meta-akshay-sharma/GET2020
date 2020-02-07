package com.StudentRegister;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import com.StudentRegister.DatabaseConnection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.ResultSet;



/**
 * Servlet implementation class AddStudentServlet
 */
@WebServlet("/AddStudentServlet")
public class AddStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddStudentServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		try {
			String firstName = request.getParameter("firstName");
			//response.getWriter().print(fname);
			String lastName = request.getParameter("lastName");
			String fatherName = request.getParameter("fatherName");
			String email = request.getParameter("studentEmail");
			int classStudent = Integer.parseInt(request.getParameter("class"));
			int age = Integer.parseInt(request.getParameter("age"));
			Connection con = DatabaseConnection.initializeDatabase(); //Initialized the DB
			
			Statement st1=con.createStatement();
			String strQuery = "SELECT COUNT(*) FROM student where email='"+email+"'";
			ResultSet rs = (ResultSet) st1.executeQuery(strQuery);
			rs.next();
			String countrow = rs.getString(1);
			PreparedStatement st = null;
			if(countrow.equals("0"))
			{

				st = con.prepareStatement("insert into student(firstName,lastName,fatherName,email,class,age) values( ?, ?, ?, ?, ?, ?)");
				st.setString(1, firstName);
				st.setString(2, lastName);
				st.setString(3, fatherName);
				st.setString(4, email);
				st.setInt(5, classStudent);
				st.setInt(6, age);
				out.println("<html><body><b>Successfully Entered The Details !!!</b><br>");
				//out.println("Successfully Inserted");
				
		
			}
			else
			{
				//out.println("Email already exists !");
				out.println("<html><body><b>Email Already Exists !!!"
						+ "</b><br>");
			}
			//To display the successful result
			
			
			st.executeUpdate();
			st.close();
			con.close();
	
			
		} catch(Exception ex) {
			out.println("<html><body><b>UnSuccesfull Transaction Not Able to Save In DATA BASE Due To Inputs Exception !!!</b></body></html><br>");
			//ex.printStackTrace();
		}
		
		out.println("<a href=index.html> Home  </a></body></html>");

	} 

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
