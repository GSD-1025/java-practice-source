package item;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;



public class ItemDAO {

	private String driver="oracle.jdbc.driver.OracleDriver";
	private String url="jdbc:oracle:thin:@localhost:1521:orcl";
	private String id="system";
	private String pass="1111";
	private Connection conn=null;
	private static ItemDAO idao=null;
	
	
	private ItemDAO() {
		init();
	}
	public static ItemDAO getInstance() {
		if(idao==null) {
			idao=new ItemDAO();
		}
		return idao;
	}
	private void init() {
		try {
			Class.forName(driver);
			System.out.println("클래스 load 성공");
		} catch(ClassNotFoundException e) {
			System.out.println("클래스 laod 실패");
			e.printStackTrace();
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
	
	public void insert2(ItemDTO i) {
		PreparedStatement stmt=null;
		try {
			if(getConnection()!=null&&i.getItype().equals("a")) {
				String sq1="insert into itype values(?,?,null,null,null)";
				stmt=conn.prepareStatement(sq1);
				stmt.setString(1, i.getIname());
				stmt.setString(2,"daily");
				int re=stmt.executeUpdate();
				if(re==1) {
					System.out.println("전송 성공");	
				}
			}else if(getConnection()!=null&&i.getItype().equals("b")) {
				String sq1="insert into itype values(?,null,?,null,null)";
				stmt=conn.prepareStatement(sq1);
				stmt.setString(1, i.getIname());
				stmt.setString(2,"electronics");
				int re=stmt.executeUpdate();
				if(re==1) {
					System.out.println("전송 성공");	
				}
			}else if(getConnection()!=null&&i.getItype().equals("c")) {
				String sq1="insert into itype values(?,null,null,?,null)";
				stmt=conn.prepareStatement(sq1);
				stmt.setString(1, i.getIname());
				stmt.setString(2,"sports");
				int re=stmt.executeUpdate();
				if(re==1) {
					System.out.println("전송 성공");	
				}
			}else if(getConnection()!=null&&i.getItype().equals("d")) {
				String sq1="insert into itype values(?,null,null,null,?)";
				stmt=conn.prepareStatement(sq1);
				stmt.setString(1, i.getIname());
				stmt.setString(2,"car");
				int re=stmt.executeUpdate();
				if(re==1) {
					System.out.println("전송 성공");	
				}
			}
			stmt.close();
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void insert1(ItemDTO i) {
		PreparedStatement stmt=null;
		try {
			if( getConnection()!=null) {
				String sq1="insert into item values('hm'||sq100.nextval,?,?,?,?,?,default,?)";
				stmt=conn.prepareStatement(sq1);
				stmt.setString(1, i.getIname());
				stmt.setInt(2, i.getPrice());
				stmt.setString(3, i.getItype());
				stmt.setInt(4, i.getAmount());
				stmt.setString(5, i.getChman());
				stmt.setString(6, i.getInform());
				int re=stmt.executeUpdate();
				if(re==1) {
					System.out.println("전송 성공");
					
				}
			}
			stmt.close();
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void updateint(int a, int num, String iname) {
		PreparedStatement stmt=null;
		try {
			if(getConnection()!=null&&a==1) {
				String sq1="update item set price=? where iname=?";
				stmt=conn.prepareStatement(sq1);
				stmt.setInt(1, num);
				stmt.setString(2, iname);
				int re=stmt.executeUpdate();
				if(re==1) {
					System.out.println("전송 성공");
				}
			}else if(getConnection()!=null&&a==2) {
				String sq1="update item set amount=? where iname=?";
				stmt=conn.prepareStatement(sq1);
				stmt.setInt(1, num);
				stmt.setString(2, iname);
				int re=stmt.executeUpdate();
				if(re==1) {
					System.out.println("전송 성공");
				}
			}
			stmt.close();
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void updatesent(int a, String sent, String iname) {
		PreparedStatement stmt=null;
		try {
			if(getConnection()!=null&&a==3) {
				String sq1="update item set chman=? where iname=?";
				stmt=conn.prepareStatement(sq1);
				stmt.setString(1, sent);
				stmt.setString(2, iname);
				int re=stmt.executeUpdate();
				if(re==1) {
					System.out.println("전송 성공");
				}
			}else if(getConnection()!=null&&a==4) {
				String sq1="update item set inform=? where iname=?";
				stmt=conn.prepareStatement(sq1);
				stmt.setString(1, sent);
				stmt.setString(2, iname);
				int re=stmt.executeUpdate();
				if(re==1) {
					System.out.println("전송 성공");
				}
			}
			stmt.close();
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void delete(String iname) {
		PreparedStatement stmt=null;
		try {
			if(getConnection()!=null) {
				String sq1="delete from item where iname=?";
				stmt=conn.prepareStatement(sq1);
				stmt.setString(1, iname);
				int re=stmt.executeUpdate();
				if(re==1) {
					System.out.println("전송 성공");
				}
			}
			stmt.close();
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public ArrayList<ItemDTO> selectall(){
		ArrayList<ItemDTO> list=new ArrayList<>();
		try {
			if(getConnection()!=null) {
				String sq1="select * from item i inner join itype t on  i.iname=t.iname";
				Statement stmt=conn.createStatement();
				ResultSet rs=stmt.executeQuery(sq1);
				while(rs.next()) {
					ItemDTO i=new ItemDTO();
					i.setId(rs.getString("id"));
					i.setIname(rs.getString("iname"));
					i.setPrice(rs.getInt("price"));
					i.setAmount(rs.getInt("amount"));
					i.setChman(rs.getString("chman"));
					i.setIdate(rs.getString("idate"));
					i.setInform(rs.getString("inform"));
					if(rs.getString("itype").equals("a")) {
						i.setItype(rs.getString("a"));
					}else if(rs.getString("itype").equals("b")) {
						i.setItype(rs.getString("b"));
					}else if(rs.getString("itype").equals("c")) {
						i.setItype(rs.getString("c"));
					}else if(rs.getString("itype").equals("d")) {
						i.setItype(rs.getString("d"));
					}
					list.add(i);
				}
				rs.close();
				stmt.close();
				conn.close();
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
		
	}
	
	public ArrayList<ItemDTO> select(String id) {
		ArrayList<ItemDTO> list=new ArrayList<>();
		try {
			if(getConnection()!=null) {
				String like="%"+id+"%";
				System.out.println("1");
				String sq1="select * from item i inner join itype t on i.iname=t.iname where i.iname like ? or i.inform like ?";
				PreparedStatement stmt=conn.prepareStatement(sq1);
				stmt.setString(1, like);
				stmt.setString(2, like);
				ResultSet rs=stmt.executeQuery();
				while(rs.next()) {
					ItemDTO i=new ItemDTO();
					i.setId(rs.getString("id"));
					i.setIname(rs.getString("iname"));
					i.setPrice(rs.getInt("price"));
					i.setAmount(rs.getInt("amount"));
					i.setChman(rs.getString("chman"));
					i.setIdate(rs.getString("idate"));
					i.setInform(rs.getString("inform"));
					if(rs.getString("itype").equals("a")) {
						i.setItype(rs.getString("a"));
					}else if(rs.getString("itype").equals("b")) {
						i.setItype(rs.getString("b"));
					}else if(rs.getString("itype").equals("c")) {
						i.setItype(rs.getString("c"));
					}else if(rs.getString("itype").equals("d")) {
						i.setItype(rs.getString("d"));
					}
					list.add(i);
				}
				rs.close();
				stmt.close();
				conn.close();
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	
}
