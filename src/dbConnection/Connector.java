package dbConnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connector {

	static Connection con=null;
	static String driver="com.ibm.db2.jcc.DB2Driver";
	static String url="jdbc:db2://localhost:50000/CITYLIFE";
	static String user="db2admin";
	static String pass="surabhir";
	public static Connection getConnector(){
		
	
	
	try
	{
		Class.forName(driver);
		con=DriverManager.getConnection(url, user, pass);
	

	}
	catch(Exception e)
	{
		
	}
	return con;
	}


}
