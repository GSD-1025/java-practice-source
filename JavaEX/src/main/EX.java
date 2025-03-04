package main;
import java.util.Random;
import java.util.Scanner;

public class EX { //class: EX
	static int[] lottoNum = new int[6]; // 멤버변수 : lottoNum
	public static void main(String[] args) { //main method
		Scanner in = new Scanner(System.in);
		menu(); //1) 메뉴 method 실행
		System.out.println("메뉴를 선택하세요");
		int num = in.nextInt(); // 2) "1" or "2" 입력
		if(num==2) { 
			randomInt(); //3-1) 랜덤 번호 입력 method 실행
			prtLotto();  //3-3) 로또 번호 출력 method 실행
		}else {
			manualInt(); //4-1) 수동 번호 입력 method 실행 
		}		
	}
	public static void manualInt() { // 수동 번호 입력 method
		Scanner in = new Scanner(System.in);
		for(int i=0; i < lottoNum.length; i++) {
			System.out.println("1부터 45번호 중 하나를 입력하세요");
			int num = in.nextInt();
			if(num <= 0 || num >= 46) {
				System.out.println("입력 값이 잘못 됨");
				i--;
			}else {
				int flag = checkDuplex(num); //4-2) 중복 체크 method 실행
				if(flag != -100){
					System.out.println("중복. 다시입력");
					i--;
				}else {
					lottoNum[i]=num;
					prtLotto(); // 4-3)로또 번호 출력 method 실행
				}
			}
		}
	}
	public static void menu() { //메뉴 method
		System.out.println("1. 수동");
		System.out.println("2. 자동");
	}
	public static void randomInt() { // 랜덤 번호 입력 method
		Random r = new Random();
		for(int i=0; i < lottoNum.length; i++) {
			int k = r.nextInt(45)+1;
			int flag = checkDuplex(k); // 3-2) 중복선택 method 실행 && 리턴값을  flag에 저장
			if(flag != -100){
				i--;
			}else {
				lottoNum[i]=k;
			}
		}
	}
	public static int checkDuplex(int a) { // 중복 체크 method
		for(int i=0; i<lottoNum.length; i++) {
			if(lottoNum[i]==a) {
				return i;
			}
		}
		return -100;
		
	}
	public static void prtLotto() { // 로또 번호 출력 메서드
		for(int i=0; i < lottoNum.length; i++) {
			System.out.print(lottoNum[i]+ " ");
		}
		System.out.println();
	}
}


	


