package program;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in= new Scanner(System.in);
		while(true) {
			System.out.println("프로그램 시작");
			while(true) {
				System.out.println("원하는 기능을 선택하세요\n1. 회원 등록 2. 회원 수정  3.회원 삭제 4. 메모관리  5. 취미관리 else: 종료");
				int ent=in.nextInt();
				in.nextLine();
				if(ent==1) {
					Admin.add();
				}else if(ent==2) {
					Admin.mod();
				}else if(ent==3) {
					Admin.delete();
				}else if(ent==4){
					System.out.println("원하는 기능을 선택하세요\n1. 취미 등록 2. 취미 수정  3.취미 삭제");
					int ent2=in.nextInt();
					in.nextLine();
					if(ent2==1) {
						Admin.hobadd();
					}else if(ent2==2) {
						Admin.hobmod();
					}else if(ent2==3) {
						Admin.hobdelete();
					}else {
						System.out.println("입력 오류-> 다시 입력");
					}
				}else if(ent==5){
					System.out.println("원하는 기능을 선택하세요\n1. 메모 등록 2. 메모 수정  3 메모 삭제");
					int ent2=in.nextInt();
					in.nextLine();
					if(ent2==1) {
						Admin.memoadd();
					}else if(ent2==2) {
						Admin.memomod();
					}else if(ent2==3) {
						Admin.memodel();
					}else {
						System.out.println("입력 오류-> 다시 입력");
					}
				}
				else {
					break;
				}
			}
			
		}

	}

}
