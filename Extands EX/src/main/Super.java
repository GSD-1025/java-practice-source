package main;

public abstract class Super {
	String username;
	String useraddr;
	
	public Super() {
		// TODO Auto-generated constructor stub
	}
	
	public void eating() {
		System.out.println("슈퍼 eat");
	}
	
	public abstract void menu();// 추상 메서드
	
	public void prt() {
		System.out.println("보호자 이름:"+this.username);
	}
}
