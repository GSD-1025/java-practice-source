package main;

import java.util.Random;
import java.util.Scanner;

public class Ex_method {
	static int[] lottoNum= new int[6];
	public static void main(String[] args) {
		System.out.println("프로그램 시작");
		Scanner in= new Scanner(System.in);
		System.out.println("로또게임 몇번 할래?");
		int num=in.nextInt();
		for (int i=0; i<num; i++) {
			randomInt();
			prtLotto();
		}
	}
	public static void randomInt() {
		Random r= new Random();
		for(int i=0; i<lottoNum.length; i++) {
			int k=r.nextInt(45)+1;
			int flag=checkDuplex(k);
			if (flag!=0) {
				i--;
			}else {
				lottoNum[i]=k;
			}
		}
	}
	public static int checkDuplex(int a) {
		for(int i=0; i<lottoNum.length; i++) {
			if(lottoNum[i]==a) {
				return i;
			}
		}
		return 0;
	}
	public static void prtLotto() {
		for(int i=0; i<lottoNum.length; i++) {
			System.out.print(lottoNum[i]+" ");
		}
		System.out.println();
	}
}
