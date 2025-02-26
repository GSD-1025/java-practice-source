package main;

import java.util.Scanner;

public class StartMenu {
	MenuOne[] menulist= new MenuOne[5];
	OrderAdmin[] orderlist=new OrderAdmin[20];
	Review[] reviewlist=new Review[5];
	
	public void menu() {
		Scanner in= new Scanner(System.in);
		MenuAdmin m= new MenuAdmin(menulist);
		OrderAdmin o= new OrderAdmin(orderlist);
		while(true) {
			System.out.println("1: 메뉴 등록  2: 주문하기  3: 주문 조회하기  4:리뷰 보기 0연습시행 7 주문의 저장여부");
			int ent1=in.nextInt();
			in.nextLine();
			if(ent1==1) {
				m.add();
			}else if(ent1==2) {
				o.orderstart();
			}else if(ent1==3) {
				o.ordcheck();
			}else if(ent1==4) {
				for(int i=0;i<5;i++) {
					if(menulist[i]!=null) {
						menulist[i].prt(i, 2);
					}
				}
				System.out.println("리뷰 보기 원하는 메뉴번호를 입력");
				int ent2=in.nextInt();
				in.nextLine();
				reviewlist[ent2].prt();
			}else if(ent1==0) {
				prac.prac();
				
			}else if(ent1==7){
				System.out.println(menulist[0].name);
			}
			else {
				break;
			}
		}
	
	}

}
