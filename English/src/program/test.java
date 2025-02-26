package program;

import java.util.Scanner;

public class test {
static String word[] = {"","","","",""};
	
	static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("영어 단어 저장 프로그램 v1");
		while(true) {
			System.out.println("1:단어저장, 2:전체단어 보기, 3:영어단어 검색, 4:영어단어삭제, 5:영어단어수정, q:종료");
			System.out.print("입력: ");
			String flag = in.nextLine();
			String a;
			if(flag.equals("1")) {
				wordSave(word);
			}else if(flag.equals("2")) {
				printWord();
			}else if(flag.equals("3")) {
				System.out.println("검색 방식을 선택해 주세요: 1: 동일한 단어 검색, 2: 포함된 단어 검색");
				String num = in.nextLine();
				if(num.equals("1")) {
					System.out.println("검색할 단어를 입력해 주세요: ");
					a = in.nextLine();
					if(search(a)==-1)
						System.out.println("없음");
					else
						System.out.println(a);
				}else if(num.equals("2")) {
					System.out.println("검색할 단어를 입력해 주세요: ");
					a = in.nextLine();
					inWord(a);
				}else {
					error();
				}
			}else if(flag.equals("4")) {
				delete();			
			}else if(flag.equals("5")) {
				modify();
			}else if(flag.equals("q")) {
				System.out.println("프로그램 종료");
				break;
			}else {
				error();
			}
			
		}
		
	}	
	
	public static void error() {
		System.out.println("잘못입력하셨습니다.");
	}
	
	public static void wordSave(String[] a) {
		for(int i = 0; i< a.length;) {
			System.out.println("단어를 입력하세요.");
			String b = in.nextLine();
			if(search(b)!=-1) {
				System.out.println("중복된 단어입니다.");
			}
			else if(!english(b)) {
				System.out.println("영어로 입력해 주세요");
			}
			else {
				word[i] = b;
				System.out.println("저장된 단어: " + b);
				i++;
			}
		}
	}
	
	public static void printWord() { 
		for(int i = 0; i < word.length; i++) {
			System.out.println(word[i]);
		}
	}
	
	
	public static int search(String a) {
		for(int i = 0; i < word.length; i++) {
			if(word[i].equals(a)){
				return i;
			}
		}
		return -1;
	}
	
	public static void inWord(String a) {
		System.out.println(a + "가 포함된 단어:");
		for(int i = 0; i < word.length; i++) {
			if(word[i].indexOf(a)>-1) {
				System.out.print(word[i] + " ");
			}
		}
		System.out.println();

	}
	
	public static boolean english(String a) {
		for(int i = 0; i < a.length(); i++) {
			if((a.charAt(i)<'a'||a.charAt(i)>'z')&& (a.charAt(i)<'A'||a.charAt(i)>'Z')) {
				return false;
			}
		}
		return true;
	}
	public static void delete() {
		System.out.println("삭제할 단어를 입력해 주세요.");
		String a = in.nextLine();
		int i = search(a);
		if(i!=-1) {
			word[i] = "";
			System.out.println(a + "단어가 삭제되었습니다.");
		}
		else {
			System.out.println("입력한 단어가 없습니다.");
		}
	}
	
	public static void modify() {
		System.out.println("수정할 단어를 입력해 주세요.");
		String a = in.nextLine();
		int i = search(a);
		if(i!=-1) {
			System.out.println("수정된 단어를 입력해 주세요: ");
			a = in.nextLine();
			word[i] = a;
			System.out.println("단어가 수정되었습니다.");
		}
		else {
			System.out.println("입력한 단어가 없습니다.");
		}
}
}
