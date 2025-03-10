package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;



public class SuprDAO {
	
	private String driver="oracle.jdbc.driver.OracleDriver";
	private String url="jdbc:oracle:thin:@localhost:1521:orcl";
	private String id="system";
	private String pass="1111";
	private Connection conn=null;
	
	private static SuprDAO sdao=null;
	
	private SuprDAO() {
		try {
			Class.forName(driver);
			System.out.println("클래스 load 성공");
		} catch(ClassNotFoundException e) {
			System.out.println("클래스 laod 실패");
			e.printStackTrace();
		}
	}
	public static SuprDAO getInstance() {
		if(sdao==null) {
			sdao=new SuprDAO();
		}
		return sdao;
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
	
	public void insertc(Franchise fran){
		PreparedStatement stmt=null;
		try {
			if( getConnection()!=null) {
				String sq1="insert into chicken values(?,?,?,?,?,?)";
				stmt=conn.prepareStatement(sq1);
				stmt.setString(1, fran.getFname());
				stmt.setString(2, fran.getMname());
				stmt.setString(3, fran.getType());
				stmt.setInt(4, fran.getchicksize());
				stmt.setString(5, fran.getchickcook());
				stmt.setInt(6, fran.getRecostar());
				stmt.execute();
				stmt.close();
				conn.close();
			}
		} catch (Exception e) {
			
		}
	}
	
	public void insertp(Franchise fran){
		PreparedStatement stmt=null;
		try {
			if( getConnection()!=null) {
				String sq1="insert into pizza values(?,?,?,?,?,?)";
				stmt=conn.prepareStatement(sq1);
				stmt.setString(1, fran.getFname());
				stmt.setString(2, fran.getMname());
				stmt.setString(3, fran.getType());
				stmt.setString(4, fran.getpizz(1));
				stmt.setString(5, fran.getpizz(2));
				stmt.setInt(6, fran.getRecostar());
				stmt.execute();
				stmt.close();
				conn.close();
			}
		} catch (Exception e) {
			
		}
	}
	
	public void insertb(Franchise fran){
		PreparedStatement stmt=null;
		try {
			if( getConnection()!=null) {
				String sq1="insert into burger values(?,?,?,?,?,?,?)";
				stmt=conn.prepareStatement(sq1);
				stmt.setString(1, fran.getFname());
				stmt.setString(2, fran.getMname());
				stmt.setString(3, fran.getType());
				stmt.setString(4, fran.getburg(1));
				stmt.setString(5, fran.getburg(2));
				stmt.setString(6, fran.getburg(3));
				stmt.setInt(7, fran.getRecostar());
				stmt.execute();
				stmt.close();
				conn.close();
			}
		} catch (Exception e) {
			
		}
	}
	
	public ArrayList<Franchise> selectall() {
		ArrayList<Franchise> list= new ArrayList<Franchise>();
		System.out.println("시도");
		try {
			getConnection();
			String sq1="select * from chicken c full join pizza p on c.mname=p.mname full join burger b on c.mname=b.mname";
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(sq1);
			while(rs.next()) {
				if(rs.getString("ctype")!=null) {
					Franchise ft= new ChickenDTO();
					ft.setFname(rs.getString("fname"));
					ft.setMname(rs.getString("mname"));
					ft.setType(rs.getString("ctype"));
					ft.setchick(rs.getInt("csize"), rs.getString("cooking"));
					ft.setRecostar(rs.getInt("recostar"));
					list.add(ft);
				}else if(rs.getString("ptype").equals("pizza")) {
					Franchise ft= new PizzaDTO();
					ft.setFname(rs.getString("fname_1"));
					System.out.println(rs.getString("fname_1"));
					ft.setMname(rs.getString("mname_1"));
					ft.setType(rs.getString("ptype"));
					ft.setpizz(rs.getString("psize"), rs.getString("topping"));
					ft.setRecostar(rs.getInt("recostar_1"));
					list.add(ft);
				}else if(rs.getString("btype")!=null) {
					Franchise ft= new BurgerDTO();
					ft.setFname(rs.getString("fname_2"));
					ft.setMname(rs.getString("mname_2"));
					ft.setType(rs.getString("btype"));
					ft.setburg(rs.getString("petty"),rs.getString("bun"), rs.getString("drink"));
					ft.setRecostar(rs.getInt("recostar_2"));
					list.add(ft);
				}
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	
}
