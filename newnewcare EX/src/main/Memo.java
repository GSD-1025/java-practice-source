package main;

public class Memo {
	String title=null;
	String content=null;
	//�����ڸ� �⺻ �����ڷ� �ڵ�
	public void prt() {
		System.out.println("����: "+title);
		System.out.println("����: "+content);
	}
	
	
	public void setmemo(String title, String content) {
		this.title=title;
		this.content=content;
	}

}
