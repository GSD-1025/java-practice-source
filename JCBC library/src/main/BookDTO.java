package main;

public class BookDTO {
	private String name;
	private String bname;
	private String bdate;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getBdate() {
		return bdate;
	}
	public void setBdate(String bdate) {
		this.bdate = bdate;
	}
	
	public void prt() {
		System.out.println("name: "+this.name);
		System.out.println("book name: "+this.bname);
		System.out.println("date: "+this.bdate);
	}

}
