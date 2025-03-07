package main;

import java.util.ArrayList;
import java.util.Scanner;

public class Admin {
	private SuprDAO sdao=SuprDAO.getInstance();
	
	Admin(){
		System.out.println("프로그램 시작");
		menu();
	}

	private void menu() {
		Scanner in= new Scanner(System.in);
		boolean f=true;
		while(f) {
			System.out.println("1: 등록   2: 수정  3: 삭제  4: 조회");
			String a=in.nextLine();
			switch(a) {
			case "1":
				resist();
				break;
			case "2":
				modify();
				break;
			case "3":
				delete();
				break;
			case "4":
				System.out.println("1: 전체 조회   2: 일부 조회");
				String b=in.nextLine();
				switch(b) {
				case "1":
					all();
					break;
				case "2":
					part();
					break;
				}
			default:
				f=true;
			}
		}
		
		
	}

	private void part() {
		
		
	}

	private void all() {
		ArrayList<Franchise> flist=sdao.selectall();
		if(flist.size()==0) {
			System.out.println("검색대상 없음");
		}
		for(Franchise t:flist) {
			t.prt();
		}	
	}

	private void delete() {
		// TODO Auto-generated method stub
		
	}

	private void modify() {
		// TODO Auto-generated method stub
		
	}

	private void resist() {
		Scanner in= new Scanner(System.in);
		System.out.println("메뉴를 등록할 프랜차이즈 명을 입력");
		String fname=in.nextLine();

		System.out.println("메뉴 이름 입력");
		String mname=in.nextLine();
		System.out.println("추천도 입력");
		int recostar=in.nextInt();
		in.nextLine();
		System.out.println("업종 입력");
		String type=in.nextLine();
		if(type.equals("chicken")) {
			Franchise fran=new ChickenDTO();
			fran.setFname(fname);
			fran.setMname(mname);
			fran.setRecostar(recostar);
			fran.setType(type);
			System.out.println("닭 크기 입력");
			int csize=in.nextInt();
			in.nextLine();
			System.out.println("조리 방식");
			String cooking=in.nextLine();
			fran.setchick(csize, cooking);
			sdao.insertc(fran);
		}else if(type.equals("pizza")) {
			Franchise fran=new PizzaDTO();
			fran.setFname(fname);
			fran.setMname(mname);
			fran.setRecostar(recostar);
			fran.setType(type);
			System.out.println("사이즈 입력");
			String psize=in.nextLine();
			System.out.println("토핑 입력");
			String topping=in.nextLine();
			fran.setpizz(psize,topping );
			System.out.println(fran.getpizz(1));
			System.out.println(fran.getpizz(2));
			sdao.insertp(fran);
		}else if(type.equals("burger")) {
			Franchise fran=new BurgerDTO();
			fran.setFname(fname);
			fran.setMname(mname);
			fran.setRecostar(recostar);
			fran.setType(type);
			System.out.println("패티 종류 입력");
			String petty=in.nextLine();
			System.out.println("번 종류 입력");
			String bun=in.nextLine();
			System.out.println("같이 곁들일 음료 종류 입력");
			String drink=in.nextLine();
			fran.setburg(petty, bun, drink);
			sdao.insertb(fran);
		}
		
	}
}
