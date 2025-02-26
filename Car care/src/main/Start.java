package main;

import java.util.Scanner;

public class Start {
	private Carmanage Carmanage=new Carmanage();
	private repairManage repairManage= new repairManage();
	Start(){
		menu();
	}

	private void menu() {
		Scanner in=new Scanner(System.in);
		boolean flag=true;
		while(flag) {
			System.out.println("1. 자동차 관리   2. 수리관리  3. 자동차 수리 리스트");
			int a=in.nextInt();
			in.nextLine();
			switch(a) {
			case 1:
				Carmanage.menu();
				break;
			case 2:
				System.out.println("자동차 번호 입력");
				int num=in.nextInt();
				in.nextLine();
				int rnum=Carmanage.searchnum(num);
				if(rnum!=0) {
					repairManage.menu(rnum);
				}else {
					System.out.println("해당 번호가 없음");
				}
				break;
			case 3:
				System.out.println("정비사 이름을 입력하세요");
				String rmech=in.nextLine();
				Carmanage.mechprt(rmech);
				System.out.println("수리할 자동차를 추가하겠습니까?\n1 : 예   2 : 아니오");
				int b=in.nextInt();
				in.nextLine();
				switch(b) {
				case 1:
					Carmanage.addmech(rmech);
				case 2:
					break;
				}
				break;
				
			default:
				flag=false;
				break;
			}
		}
	}

}
