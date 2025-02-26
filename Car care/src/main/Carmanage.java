package main;

import java.util.Scanner;

public class Carmanage {
	
	private Car[] carlist= new Car[20]; 
	
	Carmanage(){
	}
	
	public void menu() {
		Scanner in=new Scanner(System.in);
		boolean flag=true;
		while(flag) {
			System.out.println("1. 자동차 정보 입력  2. 전체 보기");
			int a=in.nextInt();
			in.nextLine();
			switch(a) {
			case 1:
				resist();
				break;
			case 2:
				carprt();
				break;
			default:
				flag=false;
				break;
			}
		}
	}
	
	public int searchnum(int num) {
		int rnum=0;
		for(int i=0; i<carlist.length; i++) {
			if(carlist[i]!=null) {
				if(num==carlist[i].getNum()) {
					rnum=carlist[i].getNum();
				}
			}
		}
		return rnum;
		
	}

	private void carprt() {
		for(int i=0; i<carlist.length; i++) {
			if(carlist[i]!=null) {
				System.out.println("번호 "+carlist[i].getNum());
				System.out.println("소유주 "+carlist[i].getName());
				System.out.println("정비사 "+carlist[i].getMechanic());
			}
		}
	}

	private void resist() {
		Scanner in=new Scanner(System.in);
		System.out.println("자동차 번호 입력");
		int num=in.nextInt();
		in.nextLine();
		System.out.println("자동차 소유주 입력");
		String name=in.nextLine();
		System.out.println("담당 정비사 입력");
		String mechanic=in.nextLine();
		Car car=new Car();
		car.setNum(num);
		car.setName(name);
		car.setMechanic(mechanic);
		for(int i=0; i<carlist.length; i++) {
			if(carlist[i]==null) {
				carlist[i]=car;
				break;
			}
		}
		
	}


	public void mechprt(String rmech) {
		int cnt=0;
		for(int i=0; i<carlist.length; i++) {
			if(carlist[i]!=null) {
				if(rmech.equals(carlist[i].getMechanic())) {
					System.out.println("번호 "+carlist[i].getNum());
					cnt++;
				}
			}
		}
		if(cnt==0) {
			System.out.println("새로운 정비사님 환영합니다");
		}
	}
	
	public void addmech(String rmech) {
		Scanner in=new Scanner(System.in);
		for(int i=0; i<carlist.length; i++) {
			if(carlist[i]!=null) {
				if(carlist[i].getMechanic()==null) {
					System.out.println("번호 "+carlist[i].getNum());
				}
			}
		}
		System.out.println("추가할 자동차 번호를 입력");
		int num=in.nextInt();
		in.nextLine();
		for(int i=0; i<carlist.length; i++) {
			if(carlist[i]!=null) {
				if(num==carlist[i].getNum()) {
					carlist[i].setMechanic(rmech);
				}
			}
		}
		
	}
	
	
}
