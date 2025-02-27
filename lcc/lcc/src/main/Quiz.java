package main;

import java.util.Scanner;

public class Quiz {

	public void menu(Thousand tAddr) {
		TimeAttack ta = new TimeAttack();
		Scanner in = new Scanner(System.in);
		String input = null;
		boolean flag = true;
		
		while(flag) {
			System.out.println("1.타임어택  2.나가기");
			input = in.nextLine();
			
			switch(input) {
			case "1":
				ta.start(tAddr);
			break;
			case "2":
				flag = false;
			break;
			default:
				System.out.println("다시 입력해주세요");			
			}
		}
	}

}
