package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TDAO {
	private String driver="oracle.jdbc.driver.OracleDriver";
	private String url="jdbc:oracle:thin:@localhost:1521:orcl";
	private String id="system";
	private String pass="1111";
	private Connection conn=null;
	private static TDAO td=null;
	
	private TDAO() {
		try {
			Class.forName(driver);
			System.out.println("load");
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static TDAO getInstance() {
		if(td==null) {
			td=new TDAO();
		}
		return td;
	}
	
	private Connection getconnect() {
		try {
			conn=DriverManager.getConnection(url,id,pass);
		} catch (Exception e) {
			System.out.println("실패");
		}
		return conn;
	}
	
	public String getImagePath() {
		String imagePath = null;
		try {
			if(getconnect()!=null) {
				String sq1="SELECT image_path FROM image_table";
				Statement stmt=conn.createStatement();
				ResultSet rs=stmt.executeQuery(sq1);			
				while(rs.next()) {
					imagePath=rs.getString("image_path");
				}
			}
		} catch (Exception e) {
			
		}
		return imagePath;
	}
}
