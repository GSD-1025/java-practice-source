package main;

import java.util.Scanner;

public class Startmenu {

	private ChainaM manager = new ChainaM();
	private Quiz ask = new Quiz();
	private Study study= new Study(manager);
	
	public void startMenu() {
		Scanner s = new Scanner(System.in);
		boolean flag = true;
		int f=0;
		while(flag) {
			System.out.println("시작 메뉴입니다. 무엇을 하시겠습니까?");
			System.out.println("1. 노트  / 2. 퀴즈  / 3. 천자문 공부(천자문 정보 등록 후 시행) / 4. 종료");
			String num = s.nextLine();
			switch(num) {
				case "1": 
					manager.menu(); 
					f=1;
					break;
				case "2": 
					ask.menu(manager.getCheon());
					break;
				case "3":
					if(f==0) {
						System.out.println("천자문 등록부터 하세요");
						break;
					}
					study.menu();
					break;
				case "4":	
					System.out.println("프로그램을 종료합니다. 감사합니다.");
					flag = false;
					break;
				default: 
					System.out.println("다시 입력하세요.");
			}
		}
	}
}