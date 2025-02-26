package program;

import java.util.Scanner;

public class test {
static String word[] = {"","","","",""};
	
	static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("���� �ܾ� ���� ���α׷� v1");
		while(true) {
			System.out.println("1:�ܾ�����, 2:��ü�ܾ� ����, 3:����ܾ� �˻�, 4:����ܾ����, 5:����ܾ����, q:����");
			System.out.print("�Է�: ");
			String flag = in.nextLine();
			String a;
			if(flag.equals("1")) {
				wordSave(word);
			}else if(flag.equals("2")) {
				printWord();
			}else if(flag.equals("3")) {
				System.out.println("�˻� ����� ������ �ּ���: 1: ������ �ܾ� �˻�, 2: ���Ե� �ܾ� �˻�");
				String num = in.nextLine();
				if(num.equals("1")) {
					System.out.println("�˻��� �ܾ �Է��� �ּ���: ");
					a = in.nextLine();
					if(search(a)==-1)
						System.out.println("����");
					else
						System.out.println(a);
				}else if(num.equals("2")) {
					System.out.println("�˻��� �ܾ �Է��� �ּ���: ");
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
				System.out.println("���α׷� ����");
				break;
			}else {
				error();
			}
			
		}
		
	}	
	
	public static void error() {
		System.out.println("�߸��Է��ϼ̽��ϴ�.");
	}
	
	public static void wordSave(String[] a) {
		for(int i = 0; i< a.length;) {
			System.out.println("�ܾ �Է��ϼ���.");
			String b = in.nextLine();
			if(search(b)!=-1) {
				System.out.println("�ߺ��� �ܾ��Դϴ�.");
			}
			else if(!english(b)) {
				System.out.println("����� �Է��� �ּ���");
			}
			else {
				word[i] = b;
				System.out.println("����� �ܾ�: " + b);
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
		System.out.println(a + "�� ���Ե� �ܾ�:");
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
		System.out.println("������ �ܾ �Է��� �ּ���.");
		String a = in.nextLine();
		int i = search(a);
		if(i!=-1) {
			word[i] = "";
			System.out.println(a + "�ܾ �����Ǿ����ϴ�.");
		}
		else {
			System.out.println("�Է��� �ܾ �����ϴ�.");
		}
	}
	
	public static void modify() {
		System.out.println("������ �ܾ �Է��� �ּ���.");
		String a = in.nextLine();
		int i = search(a);
		if(i!=-1) {
			System.out.println("������ �ܾ �Է��� �ּ���: ");
			a = in.nextLine();
			word[i] = a;
			System.out.println("�ܾ �����Ǿ����ϴ�.");
		}
		else {
			System.out.println("�Է��� �ܾ �����ϴ�.");
		}
}
}
