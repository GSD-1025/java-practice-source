package program;

import java.util.Scanner;

public class Resist {
	Scanner in= new Scanner(System.in);
	programAdmin p=new programAdmin(0);
	Resist(){
		System.out.println("�޴� ���");
		add();
	}

	private void add() {
		System.out.println("�޴����� �Է��ϼ���");
		String name=in.nextLine();
		int duple=p.reducheck(name);
		while(true) {
			if(duple==0) {
				System.out.println("�ߺ� �޴� ����\n�ٸ� �޴����� ����ϼ���");
				name=in.nextLine();
				duple=p.reducheck(name);
			}else {
				break;
			}
		}
		System.out.println("������ �����ϼ���");
		int price=in.nextInt();
		in.nextLine();
		System.out.println("�޴��� ������ �Է��ϼ���");
		String inform=in.nextLine();
		for(int i=0; i<5; i++) {
			if(Main.menuList[i]==null) {
				Main.menuList[i]=new Mdata(1);
				Main.menuList[i].name=name;
				Main.menuList[i].price=price;
				Main.menuList[i].inform=inform;
				break;
			}
		}
	}

}
