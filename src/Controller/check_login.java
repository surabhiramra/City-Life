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
 * Servlet implementation class check_login
 */
@WebServlet("/check_login")
public class check_login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public check_login() {
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
			String u=request.getParameter("userid");
			String p=request.getParameter("pwd1");
			PreparedStatement ps=cn.prepareStatement("select * from USER");
			ResultSet rs=ps.executeQuery();
			int i=0;
			while(rs.next())
			{
			String x=rs.getString("password");
			String y=rs.getString("userid");
	
				if(p.equals(x)&&u.equals(y))
				{
					i=1;
					String y1=rs.getString("name");
					out.print("Name:"+ y1+"\n ");
					HttpSession session = request.getSession();
					session.setAttribute("Name:", y1);
					
					response.sendRedirect("About_Content.jsp");
					
					RequestDispatcher rd=request.getRequestDispatcher("About_Content.jsp");
					rd.include(request, response);	
					
				}	
			
				
			}
		if(i==0)
		{
		out.print("Invalid User_id and password");
		RequestDispatcher rd=request.getRequestDispatcher("login_lib.html");
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
