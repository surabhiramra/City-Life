package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Reg_newuser
 */
@WebServlet("/Reg_newuser")
public class Reg_newuser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Reg_newuser() {
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
			
			ServletContext sc=getServletContext();
			
			String n=request.getParameter("name");
			String u=request.getParameter("userid");
			String p=request.getParameter("pwd");
			String m=request.getParameter("mail");
			out.println(n);
			out.println(u);
			out.println(p);
			out.println(m);
			
			PreparedStatement ps=cn.prepareStatement("update User set name=?, userid=?, password=?, email=? where userid="+u);
			ps.setString(1,n);
			ps.setString(2,u);
			ps.setString(3,p);
			ps.setString(4,m);
			int k=ps.executeUpdate();
			RequestDispatcher rd=request.getRequestDispatcher("login.html");
			rd.forward(request, response);
			
			 
			
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
