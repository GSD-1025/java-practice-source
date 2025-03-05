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
	private String id="system";
	private String pass="1111";
	private Connection conn=null;
	//싱글톤 기법~
	private static UserDAO userdao=null;
	
	private UserDAO(){
		init();
	}
	
	public static UserDAO getInstance() {
		if(userdao==null) {
			userdao=new UserDAO();
		}
		return userdao;
	}
	//~ 싱글톤 기법

	
	private void init() {
		try {
			Class.forName(driver);
			//라이브러리를 로드하는 의미
			//이 라이브러리는 오라클에 CRUD를 위한 클래스들이 있음
			System.out.println("클래스 load 성공");
		} catch(ClassNotFoundException e) {
			System.out.println("클래스 laod 실패");
			e.printStackTrace();// 오류 원인 찾기
		}
		
	}
	
	private Connection getConnection() {
		try {
			conn=DriverManager.getConnection(url,"system","1111");
			System.out.println("연결성공");
		} catch (Exception e) {
			System.out.println("연결오류");
		}
		return conn;
	}
	
	public void insert(UserDTO u) {
		PreparedStatement stmt=null;
		try {
			//연결하기
			conn=getConnection();
			if(conn!=null) {
				//쿼리문 정의
				String sq1="insert into user1 values (?,?)";
				//Statement 생성
				stmt=conn.prepareStatement(sq1);
				stmt.setString(1, u.getName());
				stmt.setString(2, u.getId());
				//쿼리 전송 및 결과값 받기
				int result=stmt.executeUpdate();
				System.out.println(result+"건 삽입");
			}
		} catch (Exception e) {
			
		}finally {
			try {
				//연결해체-자원반납
				stmt.close();
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();// 오류 원인 찾기
			}
		}
	}
	

	public ArrayList<UserDTO> selectAll(){
		ArrayList<UserDTO> ulist= new ArrayList<>();
		Statement stmt=null;
		ResultSet rs=null;
		try {
			if(getConnection()!=null) {
				// 연결설정, 쿼리 만들기, 매핑, 쿼리실행, 리턴값 받기
				conn=getConnection();
				String sq1="select * from user1";
				stmt=conn.createStatement();
				rs=stmt.executeQuery(sq1);
				while(rs.next()) {
					UserDTO u= new UserDTO();
					u.setId(rs.getString("id"));//"id"는 컬럼명
					u.setName(rs.getString("name"));
					ulist.add(u);
				}
			}		
		} catch (Exception e) {
			
		}finally {
			try {
				//연결해체-자원반납
				rs.close();
				stmt.close();
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();// 오류 원인 찾기
			}
		}
		return ulist;
	}
	
	
	
	
	
	
}
