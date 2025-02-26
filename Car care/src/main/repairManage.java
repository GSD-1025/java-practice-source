package main;

import java.util.Scanner;

public class repairManage {
	private Repair[] repairlist= new Repair[20];
	public void menu(int num) {
		Scanner in=new Scanner(System.in);
		int rnum=repairnum(num);
		boolean flag=true;
		while(flag) {
			System.out.println("1. 수리내역 입력   2. 수리내역 조회");
			int a=in.nextInt();
			in.nextLine();
			switch(a) {
			case 1:
				resist(rnum);
				break;
			case 2:
				prt(rnum);
				break;
			default:
				flag=false;
				break;
			}
		}
	}

	private void prt(int rnum) {
		String[] date= repairlist[rnum].getDate();
		String[] content=repairlist[rnum].getContent();
		for(int i=0; i<date.length; i++) {
			if(content[i]!=null) {
				System.out.println(date[i]+"\n"+content[i]);
			}
		}
	}

	private void resist(int rnum) {
		Scanner in=new Scanner(System.in);
		String[] date=repairlist[rnum].getDate();
		String[] content=repairlist[rnum].getContent();
		for(int i=0; i<date.length; i++) {
			if(content[i]==null) {
				System.out.println("수리날짜 입력");
				date[i]=in.nextLine();
				System.out.println("수리내역 입력(종료를 원한다면 end 입력)");
				content[i]=in.nextLine();
				if(content[i].equals("end")) {
					content[i]=null;
					break;
				}
			}
			
		}
		repairlist[rnum].setDate(date);
		repairlist[rnum].setContent(content);
	}

	private int repairnum(int a) {
		int rnum=0;
		Repair repair=new Repair();
		repair.setNum(a);
		for(int i=0; i<repairlist.length; i++) {
			if(repairlist[i]==null) {
				repairlist[i]=repair;
				System.out.println("새로운 차");
				rnum=i;
				break;
			}else if(repairlist[i]!=null && repairlist[i].getNum()==a) {
				System.out.println(repairlist[i].getNum());
				rnum=i;
				System.out.println("등록된 차");
				break;
			}
		}
		return rnum;
	}

}
