package program;

import java.util.Scanner;

public class Resist {
	Scanner in= new Scanner(System.in);
	programAdmin p=new programAdmin(0);
	Resist(){
		System.out.println("메뉴 등록");
		add();
	}

	private void add() {
		System.out.println("메뉴명을 입력하세요");
		String name=in.nextLine();
		int duple=p.reducheck(name);
		while(true) {
			if(duple==0) {
				System.out.println("중복 메뉴 오류\n다른 메뉴명을 등록하세요");
				name=in.nextLine();
				duple=p.reducheck(name);
			}else {
				break;
			}
		}
		System.out.println("가격을 설정하세요");
		int price=in.nextInt();
		in.nextLine();
		System.out.println("메뉴의 정보를 입력하세요");
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
