package program;

import java.util.Scanner;

public class manage {
	static event[] eventList= main.eventList;
	static Scanner in= new Scanner(System.in);
	int ent=0;
	manage(int ent){
		this.ent=ent;
		if(ent==2) {
			revise();
		}else if(ent==3) {
			delete();
		}else if(ent==4) {
			hide();
		}
	}
	public static void revise() {
		System.out.println("이벤트 수정 시작\n이벤트 담당자 입력하세요");
		for(int i=0; i<10; i++ ) {
			if(eventList[i]!=null){
				System.out.print(eventList[i].manager+" ");
			}
		}
		String name=in.nextLine();
		for(int i=0; i<10; i++) {
			if(eventList[i]!=null&&name.equals(eventList[i].manager)) {
				System.out.println(eventList[i].enventName);
				System.out.println("수정을 원하면 yes 아니면 no");
				String ent1=in.nextLine();
				if(ent1.equals("yes")) {
					System.out.println("원하는 이벤트 이름을 입력하세요");
					name=in.nextLine();
					eventList[i].enventName=name;
					break;
				}else if(ent1.equals("no")) {
					continue;
				}
			}
		}	
	}

	public static void delete() {
		System.out.println("이벤트 삭제 시작\n이벤트 담당자 입력하세요");
		for(int i=0; i<10; i++ ) {
			if(eventList[i]!=null){
				System.out.print(eventList[i].manager+" ");
			}
		}
		String name=in.nextLine();
		for(int i=0; i<10; i++) {
			if(eventList[i]!=null&&name.equals(eventList[i].manager)) {
				System.out.println(eventList[i].enventName);
				System.out.println("삭제 원하면 yes 아니면 no");
				String ent1=in.nextLine();
				if(ent1.equals("yes")) {
					eventList[i].enventName=null;
					eventList[i].manager=null;
					break;
				}else if(ent1.equals("no")) {
					continue;
				}
			}
		}	
	}

	public static void hide() {
		System.out.println("이벤트 숨기기 시작\n이벤트 담당자 입력하세요");
		for(int i=0; i<10; i++ ) {
			if(eventList[i]!=null){
				System.out.print(eventList[i].manager+" ");
			}
		}
		String name=in.nextLine();
		for(int i=0; i<10; i++) {
			if(eventList[i]!=null&&name.equals(eventList[i].manager)) {
				System.out.println(eventList[i].enventName);
				System.out.println("숨기기 원하면 yes 아니면 no");
				String ent1=in.nextLine();
				if(ent1.equals("yes")) {
					eventList[i].hide=1;
					break;
				}else if(ent1.equals("no")) {
					continue;
				}
			}
		}

	}
}
