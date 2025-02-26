package program;

import java.util.Scanner;

public class programAdmin {
	Scanner in= new Scanner(System.in);
	programAdmin(int a){
		if(a==1) {
			int mcnt=0;
			while(true) {
				System.out.println("1번 메뉴등록  2번 주문하기  3번 주문 조회하기  4번 리뷰 보기 else 종료 0번 연습메뉴");
				int ent1=in.nextInt();
				in.nextLine();
				if(ent1==1) {
					if(mcnt==5) {
						System.out.println("메뉴가 꽉 찼어요");
						continue;
					}
					new Resist();
					mcnt++;
				}else if(ent1==2) {
					new Order(ent1);
				}else if(ent1==3) {
					new Order(ent1);
				}else if(ent1==4) {
					rprint();
				}else {
					break;
				}
			}

		}else{
			
		}
	}
	
	public void print() {
		for(int i=0; i<5 ;i++) {
			if(Main.menuList[i]!=null) {
				System.out.println((i+1)+"번 "+Main.menuList[i].name+" "+Main.menuList[i].price+"원");
				System.out.println(Main.menuList[i].inform);
			}
		}
	}
	
	public void rprint() {
		print();
		System.out.println("리뷰를 보고 싶은 메뉴의 번호를 선택하세요");
		int ent2=in.nextInt();
		in.nextLine();
		for(int i=0; i<10; i++) {
			if(Main.review[i][ent2]!=null) {
				System.out.println(Main.review[i][ent2].review);
			}
		}
	}
	
	public int reducheck(String name) {
		int dup=1;
		for(int i=0; i<5; i++) {
			if(Main.menuList[i]!=null) {
				if(Main.menuList[i].name.equals(name)) {
					dup=0;
					break;
				}
			}
		}
		return dup;
	}


}