package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

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
			PreparedStatement stmt=conn.prepareStatement(sq1);			
			stmt.setString(1, b.getName());			
			stmt.setString(2, b.getBname());
			stmt.setString(3, b.getBdate());
			int result=stmt.executeUpdate();
			System.out.println(result+"건 삽입");
			stmt.close();
			conn.close();
		} catch (Exception e) {
		}
		
		try {
			Connection conn=DriverManager.getConnection(url,"system","1111");
			System.out.println("연결성공");
			String sq1="update libuser set book=book+1 where name=?";
			PreparedStatement stmt=conn.prepareStatement(sq1);			
			stmt.setString(1, b.getName());			
			stmt.executeUpdate();
			stmt.close();
			conn.close();
		} catch (Exception e) {
		}
		
	}
	
	public void delete(String bname, String name) {
		try {
			Connection conn=DriverManager.getConnection(url,"system","1111");
			System.out.println("연결성공");
			String sq1="delete from booklist where bname=?";
			PreparedStatement stmt=conn.prepareStatement(sq1);
			stmt.setString(1, bname);
			int result=stmt.executeUpdate();
			System.out.println(result+"건 삭제");
			stmt.close();
			conn.close();
		} catch (Exception e) {
			
		}
		try {
			Connection conn=DriverManager.getConnection(url,"system","1111");
			System.out.println("연결성공");
			String sq1="update libuser set book=book-1 where name=?";
			PreparedStatement stmt=conn.prepareStatement(sq1);			
			stmt.setString(1,name);
			stmt.executeUpdate();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	public ArrayList<BookDTO> selectall(){
		ArrayList<BookDTO> list=new ArrayList<>();
		try {
			Connection conn=DriverManager.getConnection(url,"system","1111");
			System.out.println("연결성공");
			String sq1="select * from booklist";
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(sq1);
			while(rs.next()) {
				BookDTO b= new BookDTO();
				b.setName(rs.getString("name"));
				b.setBname(rs.getString("bname"));
				b.setBdate(rs.getString("bdate"));
				list.add(b);
			}
			stmt.close();
			conn.close();
		} catch (Exception e) {

		}
		return list;
	}
	
	
	
	
	
	
}
