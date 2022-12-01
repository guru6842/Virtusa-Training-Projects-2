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

@WebServlet("/EditStudent")
public class EditStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String sname;
	String id;
	String gender;
	String grade;
	String fatherName;
	String phoneNo;
	String homePage="HomePage.jsp";
	String type="text/html";
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		sname=request.getParameter("sname");
		id=request.getParameter("id");
		grade=request.getParameter("grade");
		fatherName=request.getParameter("fatherName");
		phoneNo=request.getParameter("PhoneNo");
		gender=request.getParameter("gender");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		String cs="jdbc:mysql://localhost:3306/mydb";

		int affectedRows=0;
		String query="update students set sname=?,id=?,gender=?,grade=?,fatherName=?,PhoneNo=? where id=?";																																																												
		try(Connection con=DriverManager.getConnection(cs,"root","iasuruG@1433");PreparedStatement ps = con.prepareStatement(query);)
		{
			ps.setString(1,sname);
			ps.setString(2, id);
			ps.setString(3, gender);
			ps.setString(4,grade);
			ps.setString(5,fatherName);
			ps.setString(6,phoneNo);
			ps.setString(7,id);
			affectedRows= ps.executeUpdate();
			if (affectedRows >= 1) {
				response.setContentType(type);
				PrintWriter pw=response.getWriter();
				pw.println("<script type=\"text/javascript\">alert('Successfully updated  .!!!');</script>");
				RequestDispatcher rd=request.getRequestDispatcher(homePage);
				rd.include(request, response);
			}
			else {
				response.setContentType(type);
				PrintWriter pw=response.getWriter();
				
				pw.println("<script type=\"text/javascript\">alert('edit of student Details fail .!!!');</script>");
				RequestDispatcher rd=request.getRequestDispatcher(homePage);
				rd.include(request, response);
				
			}

			
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
	
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String inputID=request.getParameter("id");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		String cs="jdbc:mysql://localhost:3306/mydb";
		ResultSet rs;
		try(Connection con=DriverManager.getConnection(cs,"root","iasuruG@1433");Statement stmt=con.createStatement()){
			String query="select * from students where id="+inputID+" ";
			rs=stmt.executeQuery(query);
		if(rs.next()) {
			
			id=rs.getString(1);
			sname=rs.getString(2);
			gender=rs.getNString(3);
			grade=rs.getString(4);
			fatherName=rs.getString(5);
			phoneNo=rs.getString(6);
			
			ServletContext context=getServletContext();
			context.setAttribute("sname", sname);
			context.setAttribute("id", id);
			context.setAttribute("grade", grade);
			context.setAttribute("fatherName", fatherName);
			context.setAttribute("phoneNo", phoneNo);
			
		
			RequestDispatcher rd=request.getRequestDispatcher("EditStudent.jsp");
			rd.include(request, response);
		}
		else {
			response.setContentType("text/html");
			PrintWriter pw=response.getWriter();
			pw.println("<script type=\"text/javascript\">alert('student details not found ');</script>");
			RequestDispatcher rd=request.getRequestDispatcher(homePage);
			rd.include(request, response);
		}
		} catch (SQLException | IOException  e) {
			e.printStackTrace();
		}
	}

}
