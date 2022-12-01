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


@WebServlet("/DeleteStudent")
public class DeleteStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String id;
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		id=request.getParameter("id");
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		String cs="jdbc:mysql://localhost:3306/mydb";
		
		int affectedRows=0;
		String query="DELETE FROM students WHERE id="+id+" ";
		try(Connection con=DriverManager.getConnection(cs,"root","iasuruG@1433");PreparedStatement pt = con.prepareStatement(query);) {
			
			affectedRows = pt.executeUpdate();
			
			if(affectedRows>0) {
				response.setContentType("text/html");
				PrintWriter pw=response.getWriter();
				pw.println("<script type=\"text/javascript\">alert('Successfully deleted student');</script>");
				RequestDispatcher rd=request.getRequestDispatcher("HomePage.jsp");
				rd.include(request, response);
			}
			else {
				response.setContentType("text/html");
				PrintWriter pw=response.getWriter();
				pw.println("<script type=\"text/javascript\">alert(' Details Student not found ..!!');</script>");
				RequestDispatcher rd=request.getRequestDispatcher("DeleteStudent.jsp");
				rd.include(request, response);
				
			}
			
			
		} catch (SQLException| IOException e) {
			e.printStackTrace();
		}
		
	}

}
