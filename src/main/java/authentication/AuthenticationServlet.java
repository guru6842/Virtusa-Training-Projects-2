package authentication;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;





@WebServlet("/AuthenticationServlet")
public class AuthenticationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    String uname;
    String password;
   
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		uname=request.getParameter("uname");
		password=request.getParameter("pwd");
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		String cs="jdbc:mysql://localhost:3306/mydb";

		int count=0;
		String query="select count(*) as count from user_dataBase where uname='"+uname+"'and password='"+password+"'";
		try(Connection con=DriverManager.getConnection(cs,"root","iasuruG@1433");Statement stmt=con.createStatement();) {
			
			
      		ResultSet rs=stmt.executeQuery(query);
			
			if(rs.next()) {
				count=(rs.getInt(1));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try
		{
			if(count==1)
			{
				HttpSession session=request.getSession();
				session.setAttribute("username", uname);
				session.setAttribute("role","admin");
				RequestDispatcher rd=request.getRequestDispatcher("HomePage.jsp");
				rd.forward(request, response);
				
			}
			else
			{
				
				response.setContentType("text/html");
				PrintWriter pw=response.getWriter();
				pw.println("<script type=\"text/javascript\">alert('Invalid user name or Password ');</script>");	
				RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
				rd.include(request, response);
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
