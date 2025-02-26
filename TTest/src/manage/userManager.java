package manage;

import java.util.Scanner;

public class userManager {
	
	private User[] ulist = new User[5];
	
	public userManager(){
		Scanner in= new Scanner(System.in);
		boolean flag=true;
		while(flag) {
			System.out.println("1. 등록 2. 전체보기");
			int a=in.nextInt();
			in.nextLine();
			switch(a) {
			case 1: 
				add(); 
				break;
		  	case 2: 
		  		viewList(); 
		  		break;
		  	default:
		  		System.out.println("메뉴 다시 선택");
		  		flag=false;
			} 
		}
		
	}

	private void add() {
		User user=new User();
		user.setId("kkk"); // 비지니스적인 해석으로 kkk이름 저장해 주세요
		System.out.println(user.getId());
	}

	private void viewList() {
		
		
	}

}
