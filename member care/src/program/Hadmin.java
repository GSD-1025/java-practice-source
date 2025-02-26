package program;

import java.util.Scanner;

public class Hadmin {
	static Scanner in=new Scanner(System.in);
	static Hobby[][] hobList= new Hobby[10][5];
	Hadmin(){
		System.out.println("1. 취미 등록 2. 취미 수정");
		int ent1=in.nextInt();
		in.nextLine();
		if (ent1==1) {
			add();
		}else if(ent1==2) {
			mod();
		}
				
	}
	public static void mod() {
		System.out.println("수정 시작");
		Uadmin.idprint();
		System.out.println("취미를 수정할 id의 인덱스를 입력하세요");
		int ent1=in.nextInt();
		in.nextLine();
		for(int i=0; i<5; i++) {
			if(hobList[ent1][i]==null) {
				break;
			}
			System.out.println(i+"번 인덱스"+hobList[ent1][i].hob);
		}
		System.out.println();
		System.out.println("수정할 취미의 인덱스를 입력하세요");
		int ent2=in.nextInt();
		in.nextLine();
		System.out.println("취미를 다시 입력하세요");
		hobList[ent1][ent2].hob=in.nextLine();
		System.out.println("수정 완료");
	}
	public static void add() {
		System.out.println("등록 시작");
		Uadmin.idprint();
		System.out.println("취미를 등록할 id의 인덱스를 입력 입력하세요");
		int ent1=in.nextInt();
		in.nextLine();
		System.out.println("등록할 취미의 갯수를 입력하세요");
		int ent2=in.nextInt();
		in.nextLine();
		for(int i=0; i<ent2; i++) {
			System.out.println("등록할 취미를 입력하세요");
			String hob=in.nextLine();
			Hobby temp= new Hobby(hob);
			hobList[ent1][i]=temp;
		}
		
	}

}
