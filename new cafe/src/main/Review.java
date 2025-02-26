package main;

public class Review {
	String rmenu=null;
	String name=null;
	String content=null;
	
	public void prt() {
		System.out.println("이름 : "+name);
		System.out.println("내용 : "+content);
	}
	
	public void setdata(String rmenu,String name,String content) {
		this.rmenu=rmenu;
		this.name=name;
		this.content=content;
	}
}
