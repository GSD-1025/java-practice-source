package program;

import java.util.Scanner;

public class Main {
	static Mdata[] menuList=new Mdata[5];
	static Mdata[][] orderList= new Mdata[20][7];
	static Mdata[][] review=new Mdata[20][6];
	static Scanner in= new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("프로그램 시작");
		new programAdmin(1);
	}
	
		
}
