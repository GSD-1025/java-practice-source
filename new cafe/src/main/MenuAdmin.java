package main;

import java.util.Scanner;

public class MenuAdmin {
	MenuOne[] menulist= new MenuOne[5];
	
	MenuAdmin(MenuOne[] menulist){
		this.menulist=menulist;
	}
	public void add() {
		Scanner in= new Scanner(System.in);
		System.out.println("�̸� �Է�");
		String name=in.nextLine();
		System.out.println("���� �Է�");
		int price=in.nextInt();
		in.nextLine();
		System.out.println("���� �Է�");
		String inform=in.nextLine();
		MenuOne td= new MenuOne(name,price,inform);
		for(int i=0; i<5; i++) {
			if(menulist[i]==null) {
				menulist[i]=td;
				break;
			}
		}
	}

	
}
