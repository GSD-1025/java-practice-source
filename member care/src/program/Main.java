package program;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		while(true) {
			System.out.println("���ϴ� ����� �����ϼ���\n1. ȸ������ 2. ��� ����  3. �޸����  else: ����");
			int ent=in.nextInt();
			in.nextLine();
			if(ent==1) {
				new Uadmin();
			}else if(ent==2) {
				new Hadmin();
			}else if(ent==3) {
				Uadmin.idprint();
				System.out.println("�޸� �ۼ��� id �ε��� �Է�");
				int index=in.nextInt();
				in.nextLine();
				new Madin(Uadmin.userList[index].id);
			}else {
				break;
			}
		}

	}

}
