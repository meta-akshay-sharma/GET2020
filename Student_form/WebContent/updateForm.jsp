
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*"%>
<%@ page import="java.io.*"%>
<%@ page import="java.io.IOException"%>
<%@ page import="java.util.*"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form id="registerformid" action="update" method="get">

		<%
			try {
				int id = Integer.parseInt(request.getParameter("id"));
				//out.print(id);
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root","akshay");
				PreparedStatement ps = con.prepareStatement("select * from student where studentId=?");
				ps.setInt(1, id);
				ResultSet rs = ps.executeQuery();
				rs.next();
				String fatherName = rs.getString("fatherName");
				String firstName = rs.getString("firstName");
				String lastName = rs.getString("lastName");
		%>

		<fieldset>
			<h1>Student Detail Form</h1>
			<input name="id" value="<%=id%> " hidden> 
			First Name : <input id="firstname" type="text" name="firstName"
				value="<%= firstName%>"><br>
			<br> Last Name : <input id="lastname" type="text" name="lastName"
				value="<%= lastName%>"><br>
			<br> Father's Name : <input id="fathername" type="text" name="fatherName"
				value="<%= fatherName%>"><br>
			<br> Email : <input id="email" type="email" name="email"
				value=<%=rs.getString("email")%>><br>
			<br> Class : <input id="class" type="number" name="class"
				value=<%=rs.getInt("class")%>><br>
			<br> Age : <input id="age" type="number" name="age"
				value=<%=rs.getInt("age")%>><br>
			<br> <input type="submit" value="Submit"><br>
			<br>
		</fieldset>
		<%
			 con.close();
			 } catch (Exception ex) {
				 out.println("Unable to connect to database.");
			 }
		%>
	</form>
</body>
</html>