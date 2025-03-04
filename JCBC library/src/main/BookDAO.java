package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BookDAO {
	private String driver="oracle.jdbc.driver.OracleDriver";
	private String url="jdbc:oracle:thin:@localhost:1521:orcl";
	
	BookDAO(){
		init();
	}

	private void init() {
		try {
			Class.forName(driver);
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}	
	}
	
	public void insert(BookDTO b) {
		try {
			Connection conn=DriverManager.getConnection(url,"system","1111");
			System.out.println("연결성공");
			String sq1="insert into booklist values(?,?,?)";
			System.out.println("1");
			PreparedStatement stmt=conn.prepareStatement(sq1);
			System.out.println("2");
			stmt.setString(1, b.getName());
			System.out.println("3");
			stmt.setString(2, b.getBname());
			System.out.println("3");
			stmt.setString(3, b.getBdate());
			System.out.println("3");
			int result=stmt.executeUpdate();
			System.out.println("3");
			String sq2="update libuser set book=book+1 where name=?";
			System.out.println("3");
			PreparedStatement stmt2=conn.prepareStatement(sq2);
			System.out.println("3");
			stmt2.setString(1, b.getName());
			System.out.println("3");
			int result2=stmt2.executeUpdate();
			System.out.println("3");
			System.out.println(result+"건 삽입");
			System.out.println(result2+"건 삽입");
			stmt.close();
			conn.close();
		} catch (Exception e) {
			
		}
	}
	
	public void delete(String bname) {
		try {
			Connection conn=DriverManager.getConnection(url,"system","1111");
			System.out.println("연결성공");
			String sq1="delete from booklist where bname=?";
			PreparedStatement stmt=conn.prepareStatement(sq1);
			stmt.setString(1, bname);
			String sq2="update libuser set book=book-1 where name=?";
			PreparedStatement stmt2=conn.prepareStatement(sq2);
			stmt2.setString(1,selectname(bname));
			int result=stmt.executeUpdate();
			int result2=stmt2.executeUpdate();
			System.out.println(result+"건 삭제");
			System.out.println(result2+"건 삭제");
			stmt.close();
			conn.close();
		} catch (Exception e) {
			
		}
		
	}
	
	private String selectname(String bname) {
		String name=null;
		try {
			Connection conn=DriverManager.getConnection(url,"system","1111");
			System.out.println("연결성공");
			String sq1="select name from booklist where bname=?";
			PreparedStatement stmt=conn.prepareStatement(sq1);
			stmt.setString(1, bname);
			stmt.executeUpdate();
			ResultSet rs=stmt.executeQuery(sq1);
			name=rs.getString("name");
			
		} catch (Exception e) {
			
		}
		System.out.println(name);
		return name;
	}
	
	
	
	
	
	
}
