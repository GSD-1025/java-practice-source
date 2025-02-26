package main;

public class Memo {
	String title=null;
	String content=null;
	//생성자를 기본 생성자로 코딩
	public void prt() {
		System.out.println("제목: "+title);
		System.out.println("내용: "+content);
	}
	
	
	public void setmemo(String title, String content) {
		this.title=title;
		this.content=content;
	}

}
