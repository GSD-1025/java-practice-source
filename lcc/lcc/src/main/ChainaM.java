package main;
import java.util.ArrayList;
import java.util.Scanner;

public class ChainaM {

	private Thousand cheon = new Thousand();	// 천자문 정보를 어떤 방식으로 출력할 지 검토 필요
	private ArrayList<Chinese> hanjaList = new ArrayList<Chinese>();
		
	public void menu() {
		Scanner s = new Scanner(System.in);
		boolean flag = true;
		while(flag) {
			System.out.println("배우기 메뉴입니다. 무엇을 하시겠습니까?");
			System.out.println("1. 천자문 정보 / 2. 한자");
			String num = s.nextLine();
			switch(num) {
				case "1": 
					System.out.println("1. 문장 보기  2. 단어 보기  3. 전체 보기");
					String num2 = s.nextLine();
					switch(num2) {
					case "1":
						cheon.sentprt(0); 
						break;
					case "2":
						cheon.wordprt(0);
						break;
					case "3":
						cheon.prt();
					}
					break;
				case "2": 
					hanja(); 
					break;
				default: 
					flag = false;
			}
		}
		
	}

	public void modmean() {
		Scanner in =new Scanner(System.in);
		System.out.println("뜻을 수정하고 싶은 문자나 문장을 입력하세요");
		String key=in.nextLine();
		System.out.println("등록할 뜻을 다시 입력하세요");
		String value=in.nextLine();
		cheon.modmean(key, value);
		System.out.println("수정 끝");
	}
	
	public void study(int a) {
		Scanner in =new Scanner(System.in);
		if(a==1) {
			cheon.wordprt(1);
			System.out.println("출력된 문자의 순서에 맞게 뜻을 입력하세요");
			cheon.setmean(1);
			System.out.println("등록 완료");
		}else if(a==2) {
			cheon.sentprt(1);
			cheon.setmean(2);
			System.out.println("등록 완료");
		}else if(a==3) {
			System.out.println("1. 단어보기  / 2. 문장 보기");
			int b=in.nextInt();
			in.nextLine();
			if(b==1) {
				cheon.meanprt(1);
			}else if(b==2) {
				cheon.meanprt(2);
			}
		}
	}

	private void hanja() {
		Scanner s = new Scanner(System.in);
		boolean flag = true;
		while(flag) {
			System.out.println("한자 메뉴입니다. 무엇을 하시겠습니까?");
			System.out.println("1. 한자 등록 / 2. 한자 정보");
			String num = s.nextLine();
			switch(num) {
				case "1": addHanja(); break;
				case "2": infoHanja(); break;
				default: flag = false;
			}
		}
	}
	
	private void addHanja() {
		Scanner s = new Scanner(System.in);
		System.out.println("등록할 한자를 입력해주세요. (1/3)");
		String alphabet = s.nextLine();
		System.out.println("등록할 한자의 뜻를 입력해주세요. (2/3)");
		String mean = s.nextLine();
		System.out.println("등록할 한자의 음를 입력해주세요. (3/3)");
		String pron = s.nextLine();
		Chinese hanja = new Chinese();
		hanja.setAlphabet(alphabet);
		hanja.setMean(mean);
		hanja.setPron(pron);
		hanjaList.add(hanja);		
	}

	private void infoHanja() {
		Scanner s = new Scanner(System.in);
		System.out.println("검색하실 한자를 입력해주세요.");
		String alphabet = s.nextLine();
		for(Chinese c : hanjaList) {
			if(c.getAlphabet().indexOf(alphabet) != -1) {
				System.out.print(c.getAlphabet() + " ");
				System.out.print(c.getMean() + " ");
				System.out.println(c.getPron());
			}
		}
	}
	public Thousand getCheon() {
		return cheon;
	}
}