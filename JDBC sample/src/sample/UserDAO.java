package sample;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.*;

//책입: 데이터베이스에 CRUD작업 수행
public class UserDAO {
	private String driver="oracle.jdbc.driver.OracleDriver";
	private String url="jdbc:oracle:thin:@localhost:1521:orcl";
	                                   //DBMS주소:포트번호:데이터베이스 이름
	
	UserDAO(){
		init();
	}

	private void init() {
		try {
			Class.forName(driver);
			//라이브러리를 로드하는 의미
			//이 라이브러리는 오라클에 CRUD를 위한 클래스들이 있음
			System.out.println("클래스 load 성공");
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public void insert(UserDTO u) {
		try {
			//연결하기
			Connection conn=DriverManager.getConnection(url,"system","1111");
			System.out.println("연결성공");
			//쿼리문 정의
			String sq1="insert into user1 values (?,?)";
			//Statement 생성
			PreparedStatement stmt=conn.prepareStatement(sq1);
			stmt.setString(1, u.getName());
			stmt.setString(2, u.getId());
			//쿼리 전송 및 결과값 받기
			int result=stmt.executeUpdate();
			System.out.println(result+"건 삽입");
			//연결해체-자원반납
			stmt.close();
			conn.close();
		} catch (Exception e) {
			
		}
	}
	
	public ArrayList<UserDTO> selectAll(){
		ArrayList<UserDTO> ulist= new ArrayList<>();
		try {
			// 연결설정, 쿼리 만들기, 매핑, 쿼리실행, 리턴값 받기
			Connection conn=DriverManager.getConnection(url,"system","1111");
			System.out.println("연결성공");
			String sq1="select * from user1";
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(sq1);
			while(rs.next()) {
				UserDTO u= new UserDTO();
				u.setId(rs.getString("id"));//"id"는 컬럼명
				u.setName(rs.getString("name"));
				ulist.add(u);
			}
			
		} catch (Exception e) {
			
		}
		return ulist;
	}
	
	
	
	
}
