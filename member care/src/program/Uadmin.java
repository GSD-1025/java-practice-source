package program;

import java.util.Scanner;

public class Uadmin {
	static User[] userList= new User[10];
	static Scanner in=new Scanner(System.in);
	Uadmin() {
		System.out.println("원하는 기능을 선택하세요\n1.회원 등록  2.회원 수정  3.회원 삭제  4.회원 보기");
		int ent1=in.nextInt();
		in.nextLine();
		if(ent1==1) {
			add();
		}else if(ent1==2) {
			mod();
		}else if(ent1==3) {
			delete();
		}else if(ent1==4) {
			System.out.println("1.전체보기  2.미성년자 보기");
			int ent2=in.nextInt();
			in.nextLine();
			if(ent2==1) {
				allprint();
			}else if(ent2==2) {
				minorprint();
			}
		}
	}
	public static void minorprint() {
		System.out.println("미성년자 회원 보기");
		for(int i=0; i<10; i++) {
			if(userList[i]!=null&&userList[i].minor==true) {
				userList[i].Uprt();
				for(int j=0; j<5; j++) {
					if(Hadmin.hobList[i][j]!=null) {
						System.out.print(Hadmin.hobList[i][j].hob+" ");
					}
				}
				System.out.println();
			}
		}
	}
	public static void allprint() {
		System.out.println("전체 회원 보기");
		for(int i=0; i<10; i++) {
			if(userList[i]!=null) {
				userList[i].Uprt();
				for(int j=0; j<5; j++) {
					if(Hadmin.hobList[i][j]!=null) {
						System.out.print(Hadmin.hobList[i][j].hob+" ");
					}
				}
				System.out.println();
			}
		}
	}
	public static void delete() {
		System.out.println("삭제 시작");
		for(int i=0; i<10; i++) {
			if(userList[i]!=null) {
				System.out.println(i+"번 "+userList[i].id);
			}
		}
		System.out.println();
		System.out.println("삭제할 id의 인덱스 입력");
		int ent1=in.nextInt();
		in.nextLine();
		userList[ent1].id=null;
		userList[ent1].name=null;
		userList[ent1].add=null;
		System.out.println("삭제 완료");
	}
	public static void add() {
		System.out.println("등록 시작\nid를 입력하세요");
		String id=in.nextLine();
		System.out.println("이름을 입력하세요");
		String name=in.nextLine();
		System.out.println("주소를 입력하세요");
		String add=in.nextLine();
		System.out.println("미성년자 여부 체크\n1.미성년X  2.미성년O");
		int check=in.nextInt();
		in.nextLine();
		boolean minor=false;
		if(check==2) {
			minor=true;
		}
		User temp=new User(id,name,add,minor);
		for(int i=0; i<10; i++) {
			if(userList[i]==null) {
				userList[i]=temp;
				break;
			}
		}
		System.out.println("등록 완료");
	}
	public static void mod() {
		System.out.println("수정 시작");
		for(int i=0; i<10; i++) {
			if(userList[i]!=null) {
				System.out.println(i+"번 "+userList[i].id);
			}
		}
		System.out.println();
		System.out.println("수정할 id의 인덱스 입력");
		int ent1=in.nextInt();
		in.nextLine();
		while(true) {
			System.out.println("수정을 원하는 정보 입력\n 1. 이름  2. 주소  3. 미성년자 여부 \nelse: 종료");
			int ent2=in.nextInt();
			in.nextLine();
			if(ent2==1) {
				System.out.println("이름 다시 입력");
				userList[ent1].name=in.nextLine();
			}else if(ent2==2) {
				System.out.println("주소 다시 입력");
				userList[ent1].add=in.nextLine();
			}else if(ent2==3) {
				System.out.println("미성년자 여부 체크\n1.미성년X  2.미성년O");
				int check=in.nextInt();
				in.nextLine();
				boolean minor=false;
				if(check==2) {
					minor=true;
				}
				userList[ent1].minor=minor;
			}else {
				System.out.println("수정 종료");
				break;
			}
		}	
	}

	public static void idprint() {
		for(int i=0; i<10; i++) {
			if(userList[i]!=null) {
				System.out.println(i+"번 인덱스"+userList[i].id);
			}
		}
	}
	
}
