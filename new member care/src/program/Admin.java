package program;

import java.util.Scanner;

public class Admin {
	static Inform[] userList= new Inform[10];
	static Scanner in=new Scanner(System.in);
	Admin(){
		
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
		Inform temp=new Inform(id,name,add,minor);
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

	public static void hobadd() {
		System.out.println("��� ����");
		for(int i=0; i<10; i++) {
			if(userList[i]!=null) {
				System.out.println(i+"�� "+userList[i].id);
			}
		}
		System.out.println("��̸� ����� id�� �ε����� �Է� �Է��ϼ���");
		int ent1=in.nextInt();
		in.nextLine();
		System.out.println("����� ����� ������ �Է��ϼ���");
		int ent2=in.nextInt();
		in.nextLine();
		while(true) {
			if(ent2<=5) {
				break;
			}else if(ent2>5) {
				System.out.println("�ٽ� �Է��ϼ���");
				ent2=in.nextInt();
				in.nextLine();
			}
		}
		for(int i=0; i<ent2; i++) {
			System.out.println("����� ��̸� �Է��ϼ���");
			String hobb=in.nextLine();
			userList[ent1].hob[i]=hobb;
		}
	}

	public static void hobmod() {
		System.out.println("���� ����");
		for(int i=0; i<10; i++) {
			if(userList[i]!=null) {
				System.out.println(i+"�� "+userList[i].id);
			}
		}
		System.out.println("��̸� ������ id�� �ε����� �Է��ϼ���");
		int ent1=in.nextInt();
		in.nextLine();
		for(int i=0; i<5; i++) {
			if(userList[ent1].hob[i]==null) {
				break;
			}
			System.out.println(i+"�� �ε���"+userList[ent1].hob[i]);
		}
		System.out.println();
		System.out.println("������ ����� �ε����� �Է��ϼ���");
		int ent2=in.nextInt();
		in.nextLine();
		System.out.println("��̸� �ٽ� �Է��ϼ���");
		userList[ent1].hob[ent2]=in.nextLine();
		System.out.println("���� �Ϸ�");
	}

	public static void hobdelete() {
		System.out.println("���� ����");
		for(int i=0; i<10; i++) {
			if(userList[i]!=null) {
				System.out.println(i+"�� "+userList[i].id);
			}
		}
		System.out.println("��̸� ������ id�� �ε����� �Է��ϼ���");
		int ent1=in.nextInt();
		in.nextLine();
		for(int i=0; i<5; i++) {
			if(userList[ent1].hob[i]==null) {
				break;
			}
			System.out.println(i+"�� �ε���"+userList[ent1].hob[i]);
		}
		System.out.println();
		System.out.println("������ ����� �ε����� �Է��ϼ���");
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
		System.out.println("���� �Ϸ�");
	}

	public static void memoadd() {
		System.out.println("��� ����");
		for(int i=0; i<10; i++) {
			if(userList[i]!=null) {
				System.out.println(i+"�� "+userList[i].id);
			}
		}
		System.out.println("�޸� ����� id�� �ε����� �Է� �Է��ϼ���");
		int ent1=in.nextInt();
		in.nextLine();
		System.out.println("����� �޸��� ������ �Է��ϼ���");
		int ent2=in.nextInt();
		in.nextLine();
		while(true) {
			if(ent2<=10) {
				break;
			}else if(ent2>10) {
				System.out.println("�ٽ� �Է��ϼ���");
				ent2=in.nextInt();
				in.nextLine();
			}
		}
		for(int i=0; i<ent2; i++) {
			System.out.println("����� �޸� �Է��ϼ���");
			String memo=in.nextLine();
			userList[ent1].memo[i]=memo;
		}
		System.out.println("��� �Ϸ�");
	}

	public static void memomod() {
		
	}
}
