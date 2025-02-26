package userAdmin;

import java.util.Scanner;

//시작의 책임을 갖고 있는 클래스
public class Main {
	static User[] userlist= new User[5];
	static Scanner in= new Scanner(System.in);
    //main 메서드는 static이 있어서 객체를 생성하지 않아도 호출 가능
	//르로그램이 실행되면 jvm은 제일 먼저 main 메서드를 호출(call)
	public static void main(String[] args) {
		System.out.println("프로그램을 시작합니다.");
	//객체생성 생성자(인자);  생성자를 call하여 객체를 만든다.
		new UserManager("휴먼");
		while(true) {
			System.out.println("추가는 1번 전체 출력은 2번");
			int ent=in.nextInt();
			in.nextLine();
			if(ent==1) {
				add();
			}else if (ent==2) {
				allist();
			}
		}
	}
	public static void add() {
		System.out.println("id 입력");
		String id=in.nextLine();
		System.out.println("name 입력");
		String name=in.nextLine();
		User temp= new User(id,name);
		for(int i=0; i<5; i++) {
			if(userlist[i]==null) {
				userlist[i]=temp;
				break;
			}
		}
	}
	public static void allist() {
		for(int i=0; i<5; i++) {
			if(userlist[i]!=null) {
				System.out.println(userlist[i].id);
				System.out.println(userlist[i].name);
			}
		}
	}

}
