package program;

import java.util.Scanner;

public class Hadmin {
	static Scanner in=new Scanner(System.in);
	static Hobby[][] hobList= new Hobby[10][5];
	Hadmin(){
		System.out.println("1. ��� ��� 2. ��� ����");
		int ent1=in.nextInt();
		in.nextLine();
		if (ent1==1) {
			add();
		}else if(ent1==2) {
			mod();
		}
				
	}
	public static void mod() {
		System.out.println("���� ����");
		Uadmin.idprint();
		System.out.println("��̸� ������ id�� �ε����� �Է��ϼ���");
		int ent1=in.nextInt();
		in.nextLine();
		for(int i=0; i<5; i++) {
			if(hobList[ent1][i]==null) {
				break;
			}
			System.out.println(i+"�� �ε���"+hobList[ent1][i].hob);
		}
		System.out.println();
		System.out.println("������ ����� �ε����� �Է��ϼ���");
		int ent2=in.nextInt();
		in.nextLine();
		System.out.println("��̸� �ٽ� �Է��ϼ���");
		hobList[ent1][ent2].hob=in.nextLine();
		System.out.println("���� �Ϸ�");
	}
	public static void add() {
		System.out.println("��� ����");
		Uadmin.idprint();
		System.out.println("��̸� ����� id�� �ε����� �Է� �Է��ϼ���");
		int ent1=in.nextInt();
		in.nextLine();
		System.out.println("����� ����� ������ �Է��ϼ���");
		int ent2=in.nextInt();
		in.nextLine();
		for(int i=0; i<ent2; i++) {
			System.out.println("����� ��̸� �Է��ϼ���");
			String hob=in.nextLine();
			Hobby temp= new Hobby(hob);
			hobList[ent1][i]=temp;
		}
		
	}

}
