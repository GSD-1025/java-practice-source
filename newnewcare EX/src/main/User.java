package main;

import java.util.Scanner;

public class User {
	String id=null;
	String name=null;
	String addr=null;
	boolean adultFlag=true;
	String[] hobby= new String[5];
	Memo[] memo= new Memo[10];
	User(String id, String name, String addr,boolean adultFlag){
		this.id=id;
		this.name=name;
		this.addr=addr;
		this.adultFlag=adultFlag;
	}
	
	public void prt() { //다른 클래스에서 멤버변수에 직접 접근하지 말고
		                //prt() 메서드를 통해서 접근해라 (은닉화)
		System.out.println("ID :"+ id);
		String prtName=this.name;
		if(!adultFlag) {
			System.out.println("이름 :"+ prtName+"(미성년자)");
		}else {
			System.out.println("이름 :"+ prtName);
		}
		
		System.out.println("취미---------------");
		for(int i=0; i<5; i++) {
			if(hobby[i]!=null) {
				System.out.println(hobby[i]);
			}
		}
		System.out.println("메모---------------");
		for(int i=0; i<5; i++) {
			if(memo[i]!=null) {
				System.out.println(memo[i]);
			}
		}
	}
	public void setname(String name) {
		this.name=name;
	}
	public void menu() {
		while(true) {
			System.out.println("1. 정보 수정  2. 메모 추가  3. 취미 추가  4. 나의 정보");
			Scanner in= new Scanner(System.in);
			int a= in.nextInt();
			in.nextLine();
			if(a==1) {
				modinfo();
			}else if(a==2) {
				addmemo();
			}else if(a==3) {
				addhobby();
			}else if(a==2) {
				;
			}
			else {
				break;
			}
		}
	}

	private void addhobby() {
		Scanner in= new Scanner(System.in);
		System.out.println("최대 5개까지 입력이 가능합니다");
		for(int i=0; i<5; i++) {
			String hob=in.nextLine();
			for(int j=0; j<hobby.length; j++) {
				if(hobby[j]==null) {
					hobby[j]=hob;
					break;
				}
			}
		}
		
	}

	private void addmemo() {
		Scanner in= new Scanner(System.in);
		System.out.println("제목 입력");
		String title=in.nextLine();
		System.out.println("내용 입력");
		String content=in.nextLine();
		Memo temp= new Memo();
		temp.setmemo(title, content);
		for(int i=0; i<memo.length; i++) {
			if(memo[i]==null) {
				memo[i]=temp;
				break;
			}
		}
	}

	private void modinfo() {
		Scanner in= new Scanner(System.in);
		System.out.println("새로운 이름을 입력하세요");
		String name=in.nextLine();
		this.name=name;
		
	}
}
