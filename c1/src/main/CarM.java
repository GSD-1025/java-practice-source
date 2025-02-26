package main;

import java.util.ArrayList;
import java.util.Scanner;

public class CarM {
	//자동차 관리
	//carOne 객체를 등록하고 조회하는 책임
	private ArrayList<carOne> carlist= new  ArrayList<carOne>();
	
	
	public ArrayList<carOne> getCarlist() {
		return this.carlist;
	}

	public void menu() {
		Scanner in= new Scanner(System.in);
		boolean flag=true;
		while(flag) {
			System.out.println(this.hashCode()+"객체주소");
			System.out.println("1.자동차등록 2.전체보기");
			System.out.println("번호를 선택하세요");
			int a=in.nextInt();
			in.nextLine();
			switch(a) {
			case 1: 
				incertcar(); break;
			case 2: 
				listcar(); break;
			default: 
				flag=false;
			}
		}
	}
	
	public void incertcar() {
		Scanner in= new Scanner(System.in);
		System.out.println("번호와 소유자 입력");
		String num=in.nextLine();
		String name=in.nextLine();
		carOne carone= new carOne();
		carone.setNum(num);
		carone.setName(name);
		/*for(int i=0; i<carlist.length; i++) {
			if(carlist[i]==null) {
				carlist[i]=carone;
				break;
			}
		}*/
		carlist.add(carone);
		
		
		
	}
	
	public void listcar() {
		for(int i=0; i<carlist.size(); i++) {
			if(carlist.get(i)!=null) {
				carlist.get(i).prt();
			}
		}
	}

}
