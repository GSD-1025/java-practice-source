package main;

import java.util.Scanner;

public class Study {
	private ChainaM manager = new ChainaM();
	
	Study(ChainaM manager){
		this.manager=manager;
	}
	
	public void menu() {
		Scanner in=new Scanner(System.in);
		boolean flag=true;
		while(flag) {
			System.out.println("1. 단어 뜻 등록  / 2. 문장 뜻 등록  / 3. 등록보기 및 수정  ");
			int a=in.nextInt();
			in.nextLine();
			switch(a) {
			case 1:
				manager.study(1);
				break;
			case 2:
				manager.study(2);
				break;
			case 3:
				manager.study(3);
				System.out.println("수정을 원하면 yes 아니면 no");
				String b=in.nextLine();
				if(b.equals("yes")) {
					manager.modmean();
				}
				break;
			default:
				flag=false;
				3.
			}
		}
	}

}
