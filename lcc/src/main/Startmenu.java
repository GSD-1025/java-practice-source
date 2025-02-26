package main;

import java.util.Scanner;

public class Startmenu {

	private ChainaM manager = new ChainaM();
	private Quiz ask = new Quiz();
	
	public void startMenu() {
		Scanner s = new Scanner(System.in);
		boolean flag = true;
		while(flag) {
			System.out.println("시작 메뉴입니다. 무엇을 하시겠습니까?");
			System.out.println("1. 노트  / 2. 퀴즈");
			String num = s.nextLine();
			switch(num) {
				case "1": manager.menu(); break;
				case "2": ask.menu(); break;
				default: flag = false;
			}
		}
	}
}