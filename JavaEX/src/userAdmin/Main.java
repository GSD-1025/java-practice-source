package userAdmin;

import java.util.Scanner;

//������ å���� ���� �ִ� Ŭ����
public class Main {
	static User[] userlist= new User[5];
	static Scanner in= new Scanner(System.in);
    //main �޼���� static�� �־ ��ü�� �������� �ʾƵ� ȣ�� ����
	//���α׷��� ����Ǹ� jvm�� ���� ���� main �޼��带 ȣ��(call)
	public static void main(String[] args) {
		System.out.println("���α׷��� �����մϴ�.");
	//��ü���� ������(����);  �����ڸ� call�Ͽ� ��ü�� �����.
		new UserManager("�޸�");
		while(true) {
			System.out.println("�߰��� 1�� ��ü ����� 2��");
			int ent=in.nextInt();
			in.nextLine();
			if(ent==1) {
				add();
			}else if (ent==2) {
				allist();
			}
		}
	}
	public static void add() {
		System.out.println("id �Է�");
		String id=in.nextLine();
		System.out.println("name �Է�");
		String name=in.nextLine();
		User temp= new User(id,name);
		for(int i=0; i<5; i++) {
			if(userlist[i]==null) {
				userlist[i]=temp;
				break;
			}
		}
	}
	public static void allist() {
		for(int i=0; i<5; i++) {
			if(userlist[i]!=null) {
				System.out.println(userlist[i].id);
				System.out.println(userlist[i].name);
			}
		}
	}

}
