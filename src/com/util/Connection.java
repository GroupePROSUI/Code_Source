package com.util;
import java.sql.*;

public class Connection {
private static String URL="jdbc:oracle:thin:@localhost:1521/pdborcl";
private static java.sql.Connection conn;
private static Statement st;
public static void connect() {
	try {
		Class.forName("oracle.jdbc.OracleDriver");
		conn=DriverManager.getConnection(URL, "system", "yassine");
		st=conn.createStatement();
		
	}catch(ClassNotFoundException | SQLException e) {
		e.printStackTrace();
	}	
}
public static void disconnect() {
	try {
		conn.close();
	}catch(SQLException e){
		e.printStackTrace();
	}
}
public static int miseajour(String sql) {
int nb=0;
	try {
	nb=st.executeUpdate(sql);
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	return nb;
}

public static ResultSet select(String sql) {
	ResultSet rs=null;
	try {
		rs=st.executeQuery(sql);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return rs;

}
}
