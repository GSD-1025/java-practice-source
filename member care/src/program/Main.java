package program;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		while(true) {
			System.out.println("원하는 기능을 선택하세요\n1. 회원관리 2. 취미 관리  3. 메모관리  else: 종료");
			int ent=in.nextInt();
			in.nextLine();
			if(ent==1) {
				new Uadmin();
			}else if(ent==2) {
				new Hadmin();
			}else if(ent==3) {
				Uadmin.idprint();
				System.out.println("메모를 작성할 id 인덱스 입력");
				int index=in.nextInt();
				in.nextLine();
				new Madin(Uadmin.userList[index].id);
			}else {
				break;
			}
		}

	}

}
