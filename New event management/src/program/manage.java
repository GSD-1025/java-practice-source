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
		System.out.println("�̺�Ʈ ���� ����\n�̺�Ʈ ����� �Է��ϼ���");
		for(int i=0; i<10; i++ ) {
			if(eventList[i]!=null){
				System.out.print(eventList[i].manager+" ");
			}
		}
		String name=in.nextLine();
		for(int i=0; i<10; i++) {
			if(eventList[i]!=null&&name.equals(eventList[i].manager)) {
				System.out.println(eventList[i].enventName);
				System.out.println("������ ���ϸ� yes �ƴϸ� no");
				String ent1=in.nextLine();
				if(ent1.equals("yes")) {
					System.out.println("���ϴ� �̺�Ʈ �̸��� �Է��ϼ���");
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
		System.out.println("�̺�Ʈ ���� ����\n�̺�Ʈ ����� �Է��ϼ���");
		for(int i=0; i<10; i++ ) {
			if(eventList[i]!=null){
				System.out.print(eventList[i].manager+" ");
			}
		}
		String name=in.nextLine();
		for(int i=0; i<10; i++) {
			if(eventList[i]!=null&&name.equals(eventList[i].manager)) {
				System.out.println(eventList[i].enventName);
				System.out.println("���� ���ϸ� yes �ƴϸ� no");
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
		System.out.println("�̺�Ʈ ����� ����\n�̺�Ʈ ����� �Է��ϼ���");
		for(int i=0; i<10; i++ ) {
			if(eventList[i]!=null){
				System.out.print(eventList[i].manager+" ");
			}
		}
		String name=in.nextLine();
		for(int i=0; i<10; i++) {
			if(eventList[i]!=null&&name.equals(eventList[i].manager)) {
				System.out.println(eventList[i].enventName);
				System.out.println("����� ���ϸ� yes �ƴϸ� no");
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
