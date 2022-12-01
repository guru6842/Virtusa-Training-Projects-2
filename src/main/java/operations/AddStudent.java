package operations;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddStudent")
public class AddStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
     String sname;
     String gender;
     String grade;
     String fatherName;
     String phoneNo;
   
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		sname=request.getParameter("sname");
		gender=request.getParameter("gender");
		grade=request.getParameter("grade");
		fatherName=request.getParameter("fatherName");
		phoneNo=request.getParameter("PhoneNo");
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
	
		String cs="jdbc:mysql://localhost:3306/mydb";
		int affectedRows=0;
		int id=1;
		int lastID=0;
		String query="insert into students values(?,?,?,?,?,?)";
		String query1="select max(id) from students";
		try(Connection con=DriverManager.getConnection(cs,"root","iasuruG@1433");PreparedStatement pt=con.prepareStatement(query);Statement stmt = con.createStatement())
		{
		
			ResultSet rs = stmt.executeQuery(query1);
			
			
			if(rs.next()) {
				lastID=rs.getInt(1);
				id=lastID+1;
			}
			else {
				id=1;
			}
			pt.setInt(1, id);
			pt.setString(2, sname);
			pt.setString(3, gender);
			pt.setString(4, grade);
			pt.setString(5, fatherName);
			pt.setString(6,phoneNo);
			
			affectedRows = pt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(affectedRows>0) {
				response.setContentType("text/html");
				PrintWriter pw=response.getWriter();
				pw.println("<script type=\"text/javascript\">alert('Successfully added Student');</script>");
				RequestDispatcher rd=request.getRequestDispatcher("HomePage.jsp");
				rd.include(request, response);
			}
			else {	
				
				PrintWriter pw=response.getWriter();
				response.setContentType("text/html");
				pw.println("<script type=\"text/javascript\">alert('addition of Student Details fail ..!!');</script>");
				RequestDispatcher rd=request.getRequestDispatcher("AddStudent.jsp");
				rd.include(request, response);
				
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
