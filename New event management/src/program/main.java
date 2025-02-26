package program;

import java.util.Scanner;

public class main {
	static event[] eventList= new event[10];
	static Scanner in= new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("이벤트 관리 프로그램 시작\n 원하는 기능을 선택하세요");
		while(true) {
			System.out.println("1: 이벤트 관리 2: 이벤트 리스트 확인 3: 종료");
			int ent1=in.nextInt();
			in.nextLine();
			if(ent1==1) {
				System.out.println("이벤트 관리\n원하는 기능을 선택하세요");
				System.out.println("1: 이벤트 등록  2: 이벤트 수정 3:이벤트 삭제 4:이벤트 숨기기");
				int ent2=in.nextInt();
				in.nextLine();
				if(ent2==1) {
					add();
				}else if(ent2>=2 && ent2<=4) {
					new manage(ent2);
				}
				
			}else if(ent1==2) {
				System.out.println("이벤트 리스트 확인\n원하는 기능을 선택하세요");
				System.out.println("1: 전체 보기  2: 숨긴 이벤트 보기");
				int ent2=in.nextInt();
				in.nextLine();
				if(ent2==1) {
					all();
				}else if(ent2==2) {
					hidden();
				}
		
			}else {
				break;
			}
		}
		
	}
	
	public static void add() {
		System.out.println("등록 시작\n원하는 이벤트명 입력");
		String name=in.nextLine();
		System.out.println("담당자 입력");
		String manager=in.nextLine();
		int cnt=0;
		while(true) {
			for(int i=0; i<10; i++) {
				if(eventList[i]!=null&&eventList[i].manager==null) {
					continue;
				}else {
					if(eventList[i]!=null&&manager.equals(eventList[i].manager)) {
						cnt++;
					}
				}
			}
			if(cnt==2) {
				System.out.println("다시 입력하세요");
				cnt=0;
				manager=in.nextLine();
			}else {
				break;
			}
		}
		int hide=0;
		event temp= new event(name,manager,hide);
		for(int i=0; i<10; i++) {
			if(eventList[i]==null) {
				eventList[i]=temp;
				break;
			}
		}
		
	}
	public static void all() {
		System.out.println("전체 보기 시작");
		for(int i=0; i<10; i++) {
			if(eventList[i]!=null&&eventList[i].enventName!=null) {
				System.out.println(eventList[i].manager+" "+ eventList[i].enventName);
			}
		}
	}
	public static void hidden() {
		System.out.println("숨긴 이벤트 보기 시작");
		for(int i=0; i<10; i++) {
			if(eventList[i]!=null&&eventList[i].enventName!=null&& eventList[i].hide==1) {
				System.out.println(eventList[i].manager+" "+ eventList[i].enventName);
			}
		}
	}
	
}
