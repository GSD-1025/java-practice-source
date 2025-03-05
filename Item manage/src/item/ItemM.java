package item;

import java.util.ArrayList;
import java.util.Scanner;

public class ItemM {
	
	private ItemDAO idao=ItemDAO.getInstance();
	
	ItemM(){
		menu();
	}

	private void menu() {
		Scanner in=new Scanner(System.in);
		boolean f=true;
		while(f) {
			System.out.println("1. 등록  2. 수정  3. 삭제  4. 보기");
			int a=in.nextInt();
			in.nextLine();
			switch(a) {
			case 1:
				resist();
				break;
			case 2:
				update();
				break;
			case 3:
				delete();
				break;
			case 4:
				System.out.println("1. 전체보기  2. 검색");
				int b=in.nextInt();
				in.nextLine();
				switch(b) {
				case 1:
					all();
					break;
				case 2:
					search();
					break;
				}
				break;
			default:
				f=false;
				break;
			}
		}
		
	}

	private void search() {
		Scanner in=new Scanner(System.in);
		System.out.println("검색하고 싶은 제폼명을 입력하시오");
		String snt=in.nextLine();
		ArrayList<ItemDTO> itlist=idao.select(snt);
		for(ItemDTO i:itlist) {
			i.prt();
			System.out.println();
		}
		
		
	}

	private void all() {
		ArrayList<ItemDTO> itlist=idao.selectall();
		for(ItemDTO i:itlist) {
			i.prt();
			System.out.println();
		}
	}

	private void delete() {
		Scanner in=new Scanner(System.in);
		System.out.println("삭제하고 싶은 제폼 이름을 입력하시오");
		String iname=in.nextLine();
		idao.delete(iname);	
	}

	private void update() {
		Scanner in=new Scanner(System.in);
		System.out.println("수정하고 싶은 제품명 입력");
		String iname=in.nextLine();
		System.out.println("수정하고 싶은 부문을 선택하세요\n1.가격  2.수량  3.담당자  4.정보");
		int a=in.nextInt();
		in.nextLine();
		if(a==1||a==2) {
			System.out.println("수정 대상 입력");
			int num=in.nextInt();
			in.nextLine();
			idao.updateint(a,num,iname);
		}else if(a==3||a==4) {
			System.out.println("수정 대상 입력");
			String sent=in.nextLine();
			idao.updatesent(a,sent,iname);
		}
	}

	private void resist() {
		Scanner in=new Scanner(System.in);
		System.out.println("제품 등록 시작 ");
		System.out.println("이름 ");
		String iname=in.nextLine();
		System.out.println("가격");
		int price=in.nextInt();
		in.nextLine();
		System.out.println("종류 abcd만 입력해줘");
		String itype=in.nextLine();
		System.out.println("수량");
		int amount=in.nextInt();
		in.nextLine();
		System.out.println("담당자");
		String chman=in.nextLine();
		System.out.println("정보");
		String inform=in.nextLine();
		ItemDTO item=new ItemDTO();
		item.setIname(iname);
		item.setPrice(price);
		item.setItype(itype);
		item.setAmount(amount);
		item.setChman(chman);
		item.setInform(inform);
		idao.insert1(item);
		idao.insert2(item);
	}
}
