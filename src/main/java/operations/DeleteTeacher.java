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


@WebServlet("/DeleteTeacher")
public class DeleteTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String phoneNo;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		phoneNo=request.getParameter("PhoneNo");
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		String cs="jdbc:mysql://localhost:3306/mydb";
		int affectedRows=0;
		String query="DELETE FROM teachers WHERE phoneNo="+phoneNo+" ";
		try(Connection con=DriverManager.getConnection(cs,"root","iasuruG@1433");PreparedStatement pt = con.prepareStatement(query);) {
			
			affectedRows = pt.executeUpdate();
			
			if(affectedRows>0) {
				response.setContentType("text/html");
				PrintWriter pw=response.getWriter();
				pw.print("Successfully Deleted ....");
				pw.println("<script type=\"text/javascript\">alert('Successfully deleted teacher');</script>");
				RequestDispatcher rd=request.getRequestDispatcher("HomePage.jsp");
				rd.include(request, response);
			}
			else {
				response.setContentType("text/html");
				PrintWriter pw=response.getWriter();
				pw.println("<script type=\"text/javascript\">alert('Details teacher not found');</script>");
				RequestDispatcher rd=request.getRequestDispatcher("DeleteTeacher.jsp");
				rd.include(request, response);
				
			}
			
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		
	}

}
