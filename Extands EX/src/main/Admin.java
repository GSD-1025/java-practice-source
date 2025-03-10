package main;

import java.util.ArrayList;
import java.util.Scanner;

public class Admin {
	Scanner in=new Scanner(System.in);
	ArrayList<Super> ss=new ArrayList<>();
	Admin(){
		boolean f=true;
		while(f) {
			System.out.println("동물병원");
			System.out.println("1. 등록   2. 전체보기  3. 먹는 방법");
			String a=in.nextLine();
			switch(a) {
			case "1":
				add();
				break;
			case "2":
				viewlist();
				break;
			case "3":
				eat();
				break;
			default:
				f=false;
			}
		}
	}
	
	

	private void viewlist() {
		for(Super s: ss) {
			s.prt();
		}
	}

	private void add() {
		System.out.println("1.개  2.고양이");
		String a=in.nextLine();
		Super s=null;
		switch(a) {
		case "1":
			s=new Dog();
			break;
		case "2":
			s=new Cat();
			break;
		}
		s.menu();
		ss.add(s);
	}

	public void eat() {
		for(Super s: ss) {
			s.eating();
		}
	}
}
