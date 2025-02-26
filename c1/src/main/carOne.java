package main;

import java.util.Scanner;

public class carOne {
	//자동차 한 대 책임
	private String num=null;
	private String name=null;
	//수리 내역을 저장할 책임 > 수리내역은 여러개 이므로 배열로
	private RepairOne[] repairlist =new RepairOne[5];
	
	public void menu() {
		Scanner in=new Scanner(System.in);
		boolean flag=true;
		while(flag) {
			System.out.println("1.수리내역 입력 2.수리내역 보기\n번호선택");
			int a=in.nextInt();
			in.nextLine();
			switch(a) {
			case 1:
				addrepair();
				break;
			case 2:
				listrepair();
				break;
			default:
				flag=false;
			}
		
		}

	}
	private void listrepair() {
		for(int i=0; i<repairlist.length; i++) {
			if(repairlist[i]!=null) {
				repairlist[i].prt();
			}
		}
		
	}
	private void addrepair() {
		Scanner in=new Scanner(System.in);
		System.out.println("날짜와 제목과 내용을 차레대로 입력");
		String date=in.nextLine();
		String memo=in.nextLine();
		RepairOne repair= new RepairOne();
		repair.setDate(date);
		repair.setMemo(memo);
		for(int i=0; i<repairlist.length; i++) {
			if(repairlist[i]==null) {
				repairlist[i]=repair;
				break;
			}
		}
		
	}
	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getNaem() {
		return name;
	}

	public void setNaem(String naem) {
		this.name = naem;
	}

	public RepairOne[] getRepairlist() {
		return repairlist;
	}

	public void setRepairlist(RepairOne[] repairlist) {
		this.repairlist = repairlist;
	}
	
	public void prt() {
		System.out.println("차번호 : "+ this.num);
		System.out.println("차 소유자 : "+this.name);
		System.out.println("-----------수리내역");
		listrepair();
	}

	
	

}
