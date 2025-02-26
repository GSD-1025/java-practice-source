package main;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		CarM carm=new CarM();
		Scanner in= new Scanner(System.in);
		boolean flag=true;
		while(flag) {
			System.out.println("1.자동차 관리 2.수리관리");
			//자동차 관리 의존
			/*CarM carm=null; //의존한다는 의미
			carm=new CarM(); */ //의존하는 객체를 생성하여 주소를 얻었다.
			int a=in.nextInt();
			in.nextLine();
			switch(a) {
			case 1: //자동차 관리
				carm.menu();
				break;
			case 2: //수리 관리
				System.out.println("수리할 자동차 번호를 입력");
				String carnum=in.nextLine();
				carOne[] list = carm.getCarlist();
				//확장된 for
				for(carOne c: list) { //list를 0번 인덱스부터 순회하면서 value를 변수 c에 저장한다.
					if(c!=null) {
						if(c.getNum().equals(carnum)) {
							//수리할 자동차를 찾은 것
							c.prt();
							c.menu();
							
						}
					}
				}
				break;
			default:
				flag=false;
			
			}
		}
		in.close();
	}

}
