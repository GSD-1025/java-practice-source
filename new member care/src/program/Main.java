package program;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in= new Scanner(System.in);
		while(true) {
			System.out.println("���α׷� ����");
			while(true) {
				System.out.println("���ϴ� ����� �����ϼ���\n1. ȸ�� ��� 2. ȸ�� ����  3.ȸ�� ���� 4. �޸����  5. ��̰��� else: ����");
				int ent=in.nextInt();
				in.nextLine();
				if(ent==1) {
					Admin.add();
				}else if(ent==2) {
					Admin.mod();
				}else if(ent==3) {
					Admin.delete();
				}else if(ent==4){
					System.out.println("���ϴ� ����� �����ϼ���\n1. ��� ��� 2. ��� ����  3.��� ����");
					int ent2=in.nextInt();
					in.nextLine();
					if(ent2==1) {
						Admin.hobadd();
					}else if(ent2==2) {
						Admin.hobmod();
					}else if(ent2==3) {
						Admin.hobdelete();
					}else {
						System.out.println("�Է� ����-> �ٽ� �Է�");
					}
				}else if(ent==5){
					System.out.println("���ϴ� ����� �����ϼ���\n1. �޸� ��� 2. �޸� ����  3 �޸� ����");
					int ent2=in.nextInt();
					in.nextLine();
					if(ent2==1) {
						Admin.memoadd();
					}else if(ent2==2) {
						Admin.memomod();
					}else if(ent2==3) {
						Admin.memodel();
					}else {
						System.out.println("�Է� ����-> �ٽ� �Է�");
					}
				}
				else {
					break;
				}
			}
			
		}

	}

}
