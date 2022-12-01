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
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EditTeacher")
public class EditTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String name;
	String subject;
	String phoneNo;
	String mail;
	String gender;
	String type="text/html";
	String homePage="HomePage.jsp";
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		
		String query="update teachers set tname=?,gender=?,sub=?,phoneNo=?,mail=? where phoneNo=?";																																																												
		try(Connection con=DriverManager.getConnection(cs,"root","iasuruG@1433");PreparedStatement ps = con.prepareStatement(query);){
			
			
		
			
			ps.setString(1,name);
			ps.setString(2,gender);
			ps.setString(3,subject);
			ps.setString(4,phoneNo);
			ps.setString(5,mail);
			ps.setString(6,phoneNo);
			affectedRows= ps.executeUpdate();
			if (affectedRows >= 1) {
				response.setContentType(type);
				PrintWriter pw=response.getWriter();
				pw.println("<script type=\"text/javascript\">alert('Successfully updated ');</script>");
				RequestDispatcher rd=request.getRequestDispatcher(homePage);
				rd.include(request, response);
			}
			else {
				response.setContentType(type);
				PrintWriter pw=response.getWriter();
				pw.println("<script type=\"text/javascript\">alert('edit of Student Details fail .!!!');</script>");
				RequestDispatcher rd=request.getRequestDispatcher(homePage);
				rd.include(request, response);
				
			}

			
		} catch (SQLException |IOException e) {
			e.printStackTrace();
		}
	}


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String inputPhoneNo=request.getParameter("PhoneNo");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		String cs="jdbc:mysql://localhost:3306/mydb";

		ResultSet rs;
		try(Connection con=DriverManager.getConnection(cs,"root","iasuruG@1433");Statement stmt=con.createStatement()){
			String query="select * from teachers where phoneNo="+inputPhoneNo+" ";
			rs=stmt.executeQuery(query);
		if(rs.next()) {
			name=rs.getString(1);
			subject=rs.getString(3);
			phoneNo=rs.getString(4);
			mail=rs.getString(5);
			
			ServletContext context=getServletContext();
			context.setAttribute("name", name);
			context.setAttribute("subject", subject);
			context.setAttribute("phoneNo", phoneNo);
			context.setAttribute("mail", mail);
			
			response.setContentType(type);
			RequestDispatcher rd=request.getRequestDispatcher("EditTeacher.jsp");
			rd.include(request, response);
		}
		else {
			response.setContentType(type);
			PrintWriter pw=response.getWriter();
			pw.println("<script type=\"text/javascript\">alert('Teacher details not found ');</script>");
			RequestDispatcher rd=request.getRequestDispatcher("HomePage.jsp");
			rd.include(request, response);
			
		}
		} catch (SQLException |IOException e) {
			e.printStackTrace();
		}
	}

}
