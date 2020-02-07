package com.StudentRegister;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.StudentRegister.DatabaseConnection;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

/**
 * Servlet implementation class ShowStudent
 */
@WebServlet("/ShowStudent")
public class ShowStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		PrintWriter out = response.getWriter();
		//out.println("Called");
		try {
		Connection conn = DatabaseConnection.initializeDatabase();  //Initialized the DB
		PreparedStatement st = (PreparedStatement) conn.prepareStatement("select * from student");
		ResultSet rs = (ResultSet) st.executeQuery();
		out.println("<html><h1 align=\"center\">Student Details</h1><body>");
		out.println("<table align=\"center\" border=\"2px\" cellspacing=\"15\">");
		out.println("<tr><th>Student Id</th><th>First Name</th><th>Last Name</th><th>Father's Name</th><th>Email</th><th>Class</th><th>Age</th></tr>");
		while(rs.next()) {
			int sid = rs.getInt(1);
		String fName = rs.getString(2);
		String lName = rs.getString(3);
		String fatherName = rs.getString(4);
		String emailId = rs.getString(5);
		int classStudent = rs.getInt(6);
		int age = rs.getInt(7);
		out.println("<tr><td>" + sid +"</td><td>" + fName + "</td><td>" + lName + "</td><td>" + fatherName + "</td><td>" + emailId + "</td><td>" + classStudent +"</td><td>"+ age +"</td><td><a href=updateForm.jsp?id="+sid+"> <button>Update</button>  </a></td></tr>");
		//out.println("<tr><td>" + sid +"</td><td><input type=\" text\" value=" + fName + " disabled></td><td>" + lName + "</td><td>" + fatherName + "</td><td>" + emailId + "</td><td>" + classStudent +"</td><td>"+ age +"</td><td><a href=updateForm.html <button>Update</button>  </a></td></tr>");
		
		}
		out.println("</table>");
		out.println("</body></html>");
		st.close();
		conn.close();

		} catch(Exception ex) {
		ex.printStackTrace();
		}	
		
		out.println("<html><body>");
		out.println("<a href=index.html> Home  </a></body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}

/*<input type="button" value="update" onclick="f2(sid)">


f2(sid){
	
	req.setAttribute("eid",sid);
	res.sendRedirect("updateForm.html");
	req.forward
	
	
}

*/