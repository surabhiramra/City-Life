package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String driver="com.ibm.db2.jcc.DB2Driver";
		String url="jdbc:db2://localhost:50000/CITYLIFE";
		String user="db2admin";
		String pass="surabhir";
		PrintWriter out=response.getWriter();
		
		try
		{
			response.setContentType("Text/Html");
			Class.forName(driver);
			Connection cn=DriverManager.getConnection(url, user, pass);
			String u=request.getParameter("user_id");
			String p=request.getParameter("password");
			PreparedStatement ps=cn.prepareStatement("select * from User");
			ResultSet rs=ps.executeQuery();
			int i=0;
			while(rs.next())
			{
			String x=rs.getString("password");
			String y=rs.getString("user_id");
	
				if(p.equals(x)&&u.equals(y))
				{
					i=1;
					
					
				}	
			
				
			}
		if(i==0)
		{
		out.print("Invalid User_id and password");
		RequestDispatcher rd=request.getRequestDispatcher("Home_page.jsp");
		rd.include(request, response);
		}
		}
		catch(Exception e)
		{
			out.print(e);
		}

}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
