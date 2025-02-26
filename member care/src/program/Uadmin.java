package program;

import java.util.Scanner;

public class Uadmin {
	static User[] userList= new User[10];
	static Scanner in=new Scanner(System.in);
	Uadmin() {
		System.out.println("���ϴ� ����� �����ϼ���\n1.ȸ�� ���  2.ȸ�� ����  3.ȸ�� ����  4.ȸ�� ����");
		int ent1=in.nextInt();
		in.nextLine();
		if(ent1==1) {
			add();
		}else if(ent1==2) {
			mod();
		}else if(ent1==3) {
			delete();
		}else if(ent1==4) {
			System.out.println("1.��ü����  2.�̼����� ����");
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
		System.out.println("�̼����� ȸ�� ����");
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
		System.out.println("��ü ȸ�� ����");
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
		System.out.println("���� ����");
		for(int i=0; i<10; i++) {
			if(userList[i]!=null) {
				System.out.println(i+"�� "+userList[i].id);
			}
		}
		System.out.println();
		System.out.println("������ id�� �ε��� �Է�");
		int ent1=in.nextInt();
		in.nextLine();
		userList[ent1].id=null;
		userList[ent1].name=null;
		userList[ent1].add=null;
		System.out.println("���� �Ϸ�");
	}
	public static void add() {
		System.out.println("��� ����\nid�� �Է��ϼ���");
		String id=in.nextLine();
		System.out.println("�̸��� �Է��ϼ���");
		String name=in.nextLine();
		System.out.println("�ּҸ� �Է��ϼ���");
		String add=in.nextLine();
		System.out.println("�̼����� ���� üũ\n1.�̼���X  2.�̼���O");
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
		System.out.println("��� �Ϸ�");
	}
	public static void mod() {
		System.out.println("���� ����");
		for(int i=0; i<10; i++) {
			if(userList[i]!=null) {
				System.out.println(i+"�� "+userList[i].id);
			}
		}
		System.out.println();
		System.out.println("������ id�� �ε��� �Է�");
		int ent1=in.nextInt();
		in.nextLine();
		while(true) {
			System.out.println("������ ���ϴ� ���� �Է�\n 1. �̸�  2. �ּ�  3. �̼����� ���� \nelse: ����");
			int ent2=in.nextInt();
			in.nextLine();
			if(ent2==1) {
				System.out.println("�̸� �ٽ� �Է�");
				userList[ent1].name=in.nextLine();
			}else if(ent2==2) {
				System.out.println("�ּ� �ٽ� �Է�");
				userList[ent1].add=in.nextLine();
			}else if(ent2==3) {
				System.out.println("�̼����� ���� üũ\n1.�̼���X  2.�̼���O");
				int check=in.nextInt();
				in.nextLine();
				boolean minor=false;
				if(check==2) {
					minor=true;
				}
				userList[ent1].minor=minor;
			}else {
				System.out.println("���� ����");
				break;
			}
		}	
	}

	public static void idprint() {
		for(int i=0; i<10; i++) {
			if(userList[i]!=null) {
				System.out.println(i+"�� �ε���"+userList[i].id);
			}
		}
	}
	
}
