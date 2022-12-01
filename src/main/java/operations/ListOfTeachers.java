package operations;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/ListOfTeachers")
public class ListOfTeachers extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		String cs="jdbc:mysql://localhost:3306/mydb";
		ResultSet rs;
		try(Connection con=DriverManager.getConnection(cs,"root","iasuruG@1433");Statement stmt=con.createStatement()){
			
			
			String query="select * from teachers";
			rs=stmt.executeQuery(query);
			ArrayList<String> alist=new ArrayList<>();
			
			while(rs.next())
			{
				alist.add(rs.getString(1));
				alist.add(rs.getString(2));
				alist.add(rs.getString(3));
				alist.add(rs.getString(4));
				alist.add(rs.getString(5));
				
			}
			PrintWriter pw=response.getWriter();
			pw.print("List Of Teachers ");
			request.setAttribute("obj", alist);
			RequestDispatcher rd=request.getRequestDispatcher("ListOfTeachers.jsp");
			rd.forward(request, response);
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
	}

}
