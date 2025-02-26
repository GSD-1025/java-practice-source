package program;

import java.util.Scanner;

public class Order {
	int onum=0;
	int cnt=0;
	Scanner in= new Scanner(System.in);
	Order(int a){
		if(a==2) {
			System.out.println("주문하기\n주문자 이름 입력");
			String oname=in.nextLine();
			for(int i=0; i<10; i++) {
				if(Main.orderList[i][0]==null) {
					Main.orderList[i][0]=new Mdata(1);
					Main.orderList[i][0].oname=oname;
					onum=i;
					break;
				}
			}
			while(true) {
				System.out.println("원하는 메뉴를 선택하세요\n1번 주문하기  2번 주문리스트 확인하기\n이외의 번호는 종료");
				int ent1=in.nextInt();
				in.nextLine();
				if(ent1==1) {
					order();
					cnt++;
				}else if(cnt==0){
					System.out.println("주문하신적이 없습니다\n주문부터 하세요");
					continue;
				}else if(ent1==2) {
					confirm();
					break;
				}else {
					break;
				}
			}
		}else if(a==3) {
			check();
		}

	}
	private void confirm() {
		System.out.println("주문리스트 확인하기");
		System.out.println(Main.orderList[onum][0].oname+"님의 주문리스트 ");
		for(int i=1; i<6; i++) {
			if(Main.orderList[onum][i]!=null) {
				System.out.print(Main.orderList[onum][i].omenu+" "+Main.orderList[onum][i].count+"개\n");
			}
		}
		System.out.println();
		System.out.println("총금액은 "+Main.orderList[onum][6].price+" 원");
	}
	
	private void order() {
		for(int i=0; i<5 ;i++) {
			if(Main.menuList[i]!=null) {
				System.out.println((i+1)+"번 "+Main.menuList[i].name+" "+Main.menuList[i].price+"원");
				System.out.println(Main.menuList[i].inform);
			}
		}
		int ent1=0;
		int sumP=0;
		int dup=1;
		for(int i=0; i<5;i++) {
			System.out.println("주문할 메뉴의 번호를 입력하세요\n주문 번호외의 번호 입력시 주문 종료");
			ent1=in.nextInt();
			in.nextLine();
			if(ent1<1 || ent1>5) {
				break;
			}
			String omenu=Main.menuList[ent1-1].name;
			//주문메뉴 중복 체크
			for(int j=1;j<6;j++) {
				if(Main.orderList[onum][j]!=null){
					if(omenu.equals(Main.orderList[onum][j].omenu)){
						dup=0;
						break;
					}
				}
			}
			System.out.println("수량을 입력하세요");
			int count=in.nextInt();
			in.nextLine();
			if(i>0&&dup==0) {
				System.out.println("중복주문");
				Main.orderList[onum][ent1].count+=count;
				sumP+=Main.menuList[ent1-1].price*count;
				System.out.println("주문완료");
				dup=1;
				continue;
			}
			Main.orderList[onum][ent1]=new Mdata(1);
			Main.orderList[onum][ent1].omenu=omenu;
			Main.orderList[onum][ent1].count=count;
			sumP+=Main.menuList[ent1-1].price*count;
			System.out.println("주문완료\n리뷰를 남기길 원하신다면 yes를 입력해주세요");
			String ent2=in.nextLine();
			if(ent2.equals("yes")) {
				review(ent1-1);
			}
			
		}
		Main.orderList[onum][6]=new Mdata(1);
		Main.orderList[onum][6].price=sumP;
		System.out.println("주문완료!!!!!");
	}

	public void check() {
		System.out.println("주문자 조회");
		for(int i=0; i<10; i++) {
			if(Main.orderList[i][0]!=null) {
				System.out.print((i+1)+"번 "+Main.orderList[i][0].oname+" ");
			}
		}
		System.out.println();
		System.out.println("조회할 주문자의 번호를 입력하세요");
		onum=in.nextInt()-1;
		confirm();
	}

	private void review(int num) {
		System.out.println(Main.menuList[num].name+"에 대한 리뷰를 등록하세요" );
		Main.review[onum][0]=new Mdata(1);
		Main.review[onum][0].oname=Main.orderList[onum][0].oname;
		Main.review[onum][1+num]=new Mdata(1);
		Main.review[onum][1+num].review=Main.menuList[num].name+": "+in.nextLine()+" by "+Main.orderList[onum][0].oname;
	}
}

