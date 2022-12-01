package operations;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/AddTeacher")
public class AddTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String name;
	String subject;
	String phoneNo;
	String mail;
	String gender;
	
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		name=request.getParameter("name");
		subject=request.getParameter("subject");
		phoneNo=request.getParameter("PhoneNo");
		mail=request.getParameter("mail");
		gender=request.getParameter("gender");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		String cs="jdbc:mysql://localhost:3306/mydb";

		int affectedRows=0;
		String query="insert into teachers values(?,?,?,?,?)";
		try(Connection con=DriverManager.getConnection(cs,"root","iasuruG@1433");PreparedStatement pt=con.prepareStatement(query)){
			
			pt.setString(1, name);
			pt.setString(2, gender);
			pt.setString(3, subject);
			pt.setString(4, phoneNo);
			pt.setString(5, mail);
			
			
			affectedRows = pt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try
		{
			if(affectedRows>0) {
				response.setContentType("text/html");
				PrintWriter pw=response.getWriter();
				pw.println("<script type=\"text/javascript\">alert('Successfully added teacher');</script>");
				RequestDispatcher rd=request.getRequestDispatcher("HomePage.jsp");
				rd.include(request, response);
			}
			else {
				response.setContentType("text/html");
				PrintWriter pw=response.getWriter();
				pw.println("<script type=\"text/javascript\">alert('addition of Teacher Details fail .!!!');</script>");
				RequestDispatcher rd=request.getRequestDispatcher("AddTeacher.jsp");
				rd.include(request, response);	
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}

