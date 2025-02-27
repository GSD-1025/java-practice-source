package test;

import java.util.HashMap;

public class member {
	private HashMap<String, String> id= new HashMap<String, String>();
	private String pass=null;
	private String name=null;
	private String inform=null;
	
	member(String id, String pass){
		this.pass=pass;
		this.id.put(pass, id);
	}
	
	
	public String getPass() {
		return pass;
	}


	public String getId() {
		String rid=id.get(pass);
		return rid;
	}
	
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getInform() {
		return inform;
	}
	public void setInform(String inform) {
		this.inform = inform;
	}

}
