package program;

import java.util.Scanner;

public class main {
	static event[] eventList= new event[10];
	static Scanner in= new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("�̺�Ʈ ���� ���α׷� ����\n ���ϴ� ����� �����ϼ���");
		while(true) {
			System.out.println("1: �̺�Ʈ ���� 2: �̺�Ʈ ����Ʈ Ȯ�� 3: ����");
			int ent1=in.nextInt();
			in.nextLine();
			if(ent1==1) {
				System.out.println("�̺�Ʈ ����\n���ϴ� ����� �����ϼ���");
				System.out.println("1: �̺�Ʈ ���  2: �̺�Ʈ ���� 3:�̺�Ʈ ���� 4:�̺�Ʈ �����");
				int ent2=in.nextInt();
				in.nextLine();
				if(ent2==1) {
					add();
				}else if(ent2>=2 && ent2<=4) {
					new manage(ent2);
				}
				
			}else if(ent1==2) {
				System.out.println("�̺�Ʈ ����Ʈ Ȯ��\n���ϴ� ����� �����ϼ���");
				System.out.println("1: ��ü ����  2: ���� �̺�Ʈ ����");
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
		System.out.println("��� ����\n���ϴ� �̺�Ʈ�� �Է�");
		String name=in.nextLine();
		System.out.println("����� �Է�");
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
				System.out.println("�ٽ� �Է��ϼ���");
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
		System.out.println("��ü ���� ����");
		for(int i=0; i<10; i++) {
			if(eventList[i]!=null&&eventList[i].enventName!=null) {
				System.out.println(eventList[i].manager+" "+ eventList[i].enventName);
			}
		}
	}
	public static void hidden() {
		System.out.println("���� �̺�Ʈ ���� ����");
		for(int i=0; i<10; i++) {
			if(eventList[i]!=null&&eventList[i].enventName!=null&& eventList[i].hide==1) {
				System.out.println(eventList[i].manager+" "+ eventList[i].enventName);
			}
		}
	}
	
}
