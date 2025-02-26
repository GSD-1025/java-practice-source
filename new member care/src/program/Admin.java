package program;

import java.util.Scanner;

public class Admin {
	static Inform[] userList= new Inform[10];
	static Scanner in=new Scanner(System.in);
	Admin(){
		
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
		Inform temp=new Inform(id,name,add,minor);
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

	public static void hobadd() {
		System.out.println("등록 시작");
		for(int i=0; i<10; i++) {
			if(userList[i]!=null) {
				System.out.println(i+"번 "+userList[i].id);
			}
		}
		System.out.println("취미를 등록할 id의 인덱스를 입력 입력하세요");
		int ent1=in.nextInt();
		in.nextLine();
		System.out.println("등록할 취미의 갯수를 입력하세요");
		int ent2=in.nextInt();
		in.nextLine();
		while(true) {
			if(ent2<=5) {
				break;
			}else if(ent2>5) {
				System.out.println("다시 입력하세요");
				ent2=in.nextInt();
				in.nextLine();
			}
		}
		for(int i=0; i<ent2; i++) {
			System.out.println("등록할 취미를 입력하세요");
			String hobb=in.nextLine();
			userList[ent1].hob[i]=hobb;
		}
	}

	public static void hobmod() {
		System.out.println("수정 시작");
		for(int i=0; i<10; i++) {
			if(userList[i]!=null) {
				System.out.println(i+"번 "+userList[i].id);
			}
		}
		System.out.println("취미를 수정할 id의 인덱스를 입력하세요");
		int ent1=in.nextInt();
		in.nextLine();
		for(int i=0; i<5; i++) {
			if(userList[ent1].hob[i]==null) {
				break;
			}
			System.out.println(i+"번 인덱스"+userList[ent1].hob[i]);
		}
		System.out.println();
		System.out.println("수정할 취미의 인덱스를 입력하세요");
		int ent2=in.nextInt();
		in.nextLine();
		System.out.println("취미를 다시 입력하세요");
		userList[ent1].hob[ent2]=in.nextLine();
		System.out.println("수정 완료");
	}

	public static void hobdelete() {
		System.out.println("삭제 시작");
		for(int i=0; i<10; i++) {
			if(userList[i]!=null) {
				System.out.println(i+"번 "+userList[i].id);
			}
		}
		System.out.println("취미를 삭제할 id의 인덱스를 입력하세요");
		int ent1=in.nextInt();
		in.nextLine();
		for(int i=0; i<5; i++) {
			if(userList[ent1].hob[i]==null) {
				break;
			}
			System.out.println(i+"번 인덱스"+userList[ent1].hob[i]);
		}
		System.out.println();
		System.out.println("삭제할 취미의 인덱스를 입력하세요");
		int ent2=in.nextInt();
		in.nextLine();
		userList[ent1].hob[ent2]=null;
		for(int i=0; i<5; i++) {
			if(userList[ent1].hob[i]==null) {
				for(int j=i; j<4; j++) {
					userList[ent1].hob[j]=userList[ent1].hob[j+1];
				}
			}
		}
		System.out.println("삭제 완료");
	}

	public static void memoadd() {
		System.out.println("등록 시작");
		for(int i=0; i<10; i++) {
			if(userList[i]!=null) {
				System.out.println(i+"번 "+userList[i].id);
			}
		}
		System.out.println("메모를 등록할 id의 인덱스를 입력 입력하세요");
		int ent1=in.nextInt();
		in.nextLine();
		System.out.println("등록할 메모의 갯수를 입력하세요");
		int ent2=in.nextInt();
		in.nextLine();
		while(true) {
			if(ent2<=10) {
				break;
			}else if(ent2>10) {
				System.out.println("다시 입력하세요");
				ent2=in.nextInt();
				in.nextLine();
			}
		}
		for(int i=0; i<ent2; i++) {
			System.out.println("등록할 메모를 입력하세요");
			String memo=in.nextLine();
			userList[ent1].memo[i]=memo;
		}
		System.out.println("등록 완료");
	}

	public static void memomod() {
		
	}
}
