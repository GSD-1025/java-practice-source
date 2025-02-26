package main;

import java.util.Scanner;

public class Useradmin {
	User[] ulist= new User[5];
	
	public void mainStart() {
		Scanner in=new Scanner(System.in);
		System.out.println("시작");
		while(true) {
			menu();
			System.out.println("선택");
			int a=in.nextInt();
			in.nextLine();
			if(a==1) {
				add();
			}else if(a==2) {
				list();
			}else if(a==3) {
				delete();
			}else if(a==4) {
				mod();
			}else if(a==5) {
				search();
			}else {
				break;
			}
		}
		in.close();
	}
	
	public void menu() {
		System.out.println("1.추가");
		System.out.println("2.전체보기");
		System.out.println("1.삭제");
		System.out.println("1.수정");
		System.out.println("1.검색");
		
	}
	public void add() {
		Scanner in=new Scanner(System.in);
		System.out.println("사용자 추가");
		System.out.println("아이디 입력");
		String id=in.nextLine();
		System.out.println("이름 입력");
		String name=in.nextLine();
		System.out.println("주소 입력");
		String addr=in.nextLine();
		System.out.println("1.성인 2. 미성년자");
		String a=in.nextLine();
		boolean adultFlag=true;
		if(a.equals("2")) {
			adultFlag=false;
		}
		User user=new User(id,name,addr,adultFlag);
		for(int i=0; i<5; i++) {
			if(ulist[i]==null) {
			   ulist[i]= user; // 주소복사
			   break;
			}
		}
		in.close();
	}
	public void list() {
		for(int i=0; i<ulist.length; i++) {
			if(ulist[i]!=null) {
				ulist[i].prt();
			}
		}
		
	}
	public void delete() {
		Scanner in=new Scanner(System.in);
		//아이디를 입력받아서 삭제
		System.out.println("아이디를 입력하세요");
		String eid=in.nextLine();
		for(int i=0; i<ulist.length; i++) {
			if(ulist[i]!=null) {
				if(ulist[i].id.equals(eid)) {
					ulist[i]=null;
					break;
				}
			}
		}
		in.close();
	}
	public void mod() {
		Scanner in=new Scanner(System.in);
		//아이디를 입력받아서 수정
		//순서 1. 아이디를 입력받는다.  2.배열에서 찾는다.  3. 수정한다(이름만)
		System.out.println("아이디를 입력하세요");
		String eid=in.nextLine();
		for(int i=0; i<ulist.length; i++) {
			if(ulist[i]!=null) {
				if(ulist[i].id.equals(eid)) {
					//System.out.println("수정할 이름을 입력하세요");
					//String newname=in.nextLine();
					//ulsit[i].name=newname;->직접 접근은 좋지 못함
					//ulist[i].setname(newname);
					ulist[i].menu();
				}
			}
		}
	}
	public void search() {
		Scanner in=new Scanner(System.in);
		System.out.println("검색어(id)를 입력하세요");
		String eid=in.nextLine();
		for(int i=0; i<ulist.length; i++) {
			if(ulist[i]!=null) {
				//if(ulist[i].id.equals(eid)) {
				//indexOf  메서드   기능 :문자열의 인덱스 찾기    인자   리턴값: 위치한 인덱스번호/ 없다면 -1 반환
				if(ulist[i].id.indexOf(eid)!=-1) {
					ulist[i].prt();
				}
			}
		}
	}
	
	

}
