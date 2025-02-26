package main;

import java.util.Scanner;

public class OrderAdmin {
	String ordman=null;
	String[] ordmenu=new String[5];
	int[] cnt=new int[5];
	int ordnum=0;
	int price=0;
	StartMenu s=new StartMenu();
	OrderAdmin[] orderlist=new OrderAdmin[20];
	OrderAdmin(OrderAdmin[] orderlist){
		this.orderlist=orderlist;
	}
	public void orderstart() {
		Scanner in= new Scanner(System.in);
		System.out.println("주문자 입력");
		String ent1=in.nextLine();
		setman(ent1);
		for(int i=0; i<s.orderlist.length; i++) {
			if(s.orderlist[i]==null) {
				s.orderlist[i].setman(ent1);
				ordnum=i;
				break;
			}	
		}
		while(true) {
			System.out.println("1: 주문하기  2; 주문한 리스트 확인하기");
			int ent2=in.nextInt();
			in.nextLine();
			if(ent2==1) {
				for(int i=0; i<s.menulist.length; i++) {
					if(s.menulist[i]!=null) {
						System.out.println("실행여부");
						s.menulist[i].prt(i, 1);
					}
				}
				order();
			}else if(ent2==2) {
				confirm();
			}else {
				break;
			}
		}
	}
	
	private void confirm() {
		System.out.println("현재 주문 리스트 조회");
		for(int i=0; i<5; i++) {
			if(s.orderlist[ordnum].ordmenu[i]!=null) {
				System.out.println(s.orderlist[ordnum].ordmenu[i]);
				System.out.println(s.orderlist[ordnum].cnt[i]);
			}
		}
		System.out.println(s.orderlist[ordnum].price+"원");
	}

	private void order() {
		Scanner in= new Scanner(System.in);
		Review r=new Review();
		System.out.println("주문 시작");
		int sump=0;
		int dup=0;
		for(int i=0; i<5; i++) {
			System.out.println("주문하고 싶은 메뉴번호 입력");
			int ent1=in.nextInt();
			in.nextLine();
			for(int j=0; j<5; j++) {
				if(s.menulist[ent1].name.equals(s.orderlist[ordnum].ordmenu[j])) {
					dup=1;
				}
			}
			System.out.println("수량 입력");
			int ent2=in.nextInt();
			in.nextLine();
			if(dup==1) {
				System.out.println("중복주문");
				s.orderlist[ordnum].cnt[ent1]+=ent2;
				sump+=s.menulist[ent1].price*ent2;
				dup=0;
				continue;
			}
			s.orderlist[ordnum].setmenu(ent1, ent2);
			sump+=s.menulist[ent1].price*ent2;
			System.out.println("리뷰를 등록을 원하면 yes 입력");
			String ent3=in.nextLine();
			if(ent3.equals(ent3)) {
				System.out.println("리뷰 입력");
				String ent4=in.nextLine();
				r.setdata(s.menulist[ent1].name, s.orderlist[ordnum].ordman, ent4);
			}
		}
		s.orderlist[ordnum].price=sump;
		
	}

	public void ordcheck() {
		Scanner in= new Scanner(System.in);
		System.out.println("주문자 조회");
		for(int i=0; i<s.orderlist.length; i++) {
			if(s.orderlist[i]!=null) {
				System.out.print(i+"번 "+s.orderlist[i].ordman+"  ");
			}
		}
		System.out.println("\n조회할 주문자 번호 선택");
		int ent1=in.nextInt();
		for(int i=0; i<5; i++) {
			if(s.orderlist[ent1].ordmenu[i]!=null) {
				System.out.println(s.orderlist[ent1].ordmenu[i]+"\n"+s.orderlist[ent1].cnt[i]);
			}
		}
	}

 	public void setman(String name) {
		this.ordman=name;
	}
	public void setmenu(int a,int b) {
		this.ordmenu[a]=s.menulist[a].name;
		this.cnt[a]=b;
	}

}
