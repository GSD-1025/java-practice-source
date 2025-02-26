package program;

import java.util.Random;
import java.util.Scanner;

public class engword {
	static String[] enword= new String[5];
	static String[] mean= new String[5];
	static Scanner in= new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("단어장 프로그램 스타트");
		input_save();
		printword();
		while(true) {
			System.out.println("원하는 기능을 선택하세요.\n'1': 단어 검색   '2':단어 삭제  '3':단어 수정  '4':단어장 출력  '5': 단어 시험  '6': 종료");
			int ut=in.nextInt();
			in.nextLine();
			if(ut==1) {
				System.out.println("원하는 검색을 선택하세요.\n'1':전체 단어 검색  '2':포함된 단어 검색");
				int ser=in.nextInt();
				in.nextLine();
				if(ser==1) {
					searchword1();
				}else {
					searchword2();
				}
			}else if(ut==2) {
				deleteword();
			}else if(ut==3) {
				updateword();
			}else if(ut==4) {
				printword();
			}else if(ut==5) {
				testword();
			}else if(ut==6) {
				System.out.println("프로그램 종료");
				break;
			}else {
				System.out.println("입력하신 번호에 해당하는 기능이 없습니다.\n번호를 다시 입력하세요");
			}
		}
	}
	//입력 및 저장 기능
	public static void input_save() {
		System.out.println("단어를 입력 및 저장합니다");
		for(int i=0; i<5; i++) {
			System.out.println("단어를 입력하세요");
			enword[i]=in.nextLine();
			System.out.println("단어의 뜻을 입력하세요");
			mean[i]=in.nextLine();
		}
	}
	//출력 기능
	public static void printword() { 
		System.out.println("단어장 출력");
		for(int i=0; i<5; i++) {
			System.out.print(enword[i]+":");
			System.out.print(mean[i]);
			System.out.println();
		}
		System.out.println();
	}
	//전체 단어 검색 기능
	public static void searchword1() { 
		System.out.println("전체 단어 검색 시작");
		System.out.println("검색할 단어를 입력하세요");
		while(true) {
			String serw=in.nextLine();
			if(serw.equals("종료")) {
				System.out.println("검색 종료");
				break;
			}
			int flag=checkword(serw);
			if(flag!=-1) {
				System.out.println(serw);
				System.out.println("뜻: "+mean[flag]);
			}else {
				System.out.println("없음");
			}
			System.out.println("다음 검색");
		}
			
	}
	//포함된 단어 검색 기능
	public static void searchword2() { 
		System.out.println("포함된 단어 검색 시작");
		System.out.println("검색할 단어 입력하세요");
		while(true) {
			String serw=in.nextLine();
			if(serw.equals("종료")) {
				System.out.println("검색 종료");
				return;
			}else {
				test1(serw);
			}
			System.out.println("다음 검색 단어를 입력하세요");
		}
	}
	//삭제 기능
	public static void deleteword() { 
		System.out.println("단어 삭제 시작");
		System.out.println("삭제할 단어를 입력하세요");
		int cnt=0;
		while(true) {
			String delw=in.nextLine();
			if(delw.equals("종료")) {
				System.out.println("삭제 종료");
				return;
			}
			int flag=checkword(delw);
			if (flag!=-1) {
				cnt++;
				System.out.println(enword[flag]+" 삭제\n삭제를 원하는 다른 단어를 입력하세요");
				enword[flag]="삭제됨"+cnt;
				mean[flag]="   ";
			}else {
				System.out.println("해당 단어 없음\n단어를 다시 입력하세요");
				continue;
			}
		}
	}
	//수정 기능
	public static void updateword() { 
		System.out.println("단어 수정 시작");
		System.out.println("수정할 단어를 입력하세요");
		while(true) {
			String delw=in.nextLine();
			if(delw.equals("종료")) {
				System.out.println("수정 종료");
				return;
			}
			int flag=checkword(delw);
			if (flag!=-1) {
				System.out.println("다시 넣을 단어와 뜻을 다시 입력하세요");
				System.out.println("단어");
				enword[flag]=in.nextLine();
				System.out.println("뜻");
				mean[flag]=in.nextLine();
				System.out.println("수정 완료 다음 단어를 입력하세요");
			}else {
				System.out.println("해당 단어 없음\n단어를 다시 입력하세요");
				continue;
			}
		}
	}
	//단어 일치 여부 기능
	public static int checkword(String a) { 
		for(int i=0; i<5; i++) {
			if(enword[i].equals(a)) {
				return i;	
			}
		}return -1;
	}
	//알파벳 일치여부 기능
	public static void checkalp(String a) {
		for(int i=0; i<5; i++) {
			if(enword[i].indexOf(a)!=-1) {
				System.out.println(enword[i]);
				System.out.println("뜻: "+mean[i]);
			}
		}
	}
	//테스트용 method(포함된 단어 찾기)
	public static void test1(String a) {
		for(int i=0; i<5; i++) {
			int k=0;
			String c=String.valueOf(enword[i].charAt(k));
			for(int j=k+1; j<enword[i].length(); j++) {
				c+=String.valueOf(enword[i].charAt(j));
				if(c.equals(a)) {
					 System.out.println(enword[i]);
					 break;
				}
				if(c.length()==a.length()) {
					 c=null;
					 k++;
					 j=k;
					 c=String.valueOf(a.charAt(k));
				}
			 }
		}
		
	}
	//단어 시험 기능
 	public static void testword(){
		System.out.println("단어 시험 시작");
		while(true) {
			Random r= new Random();
			int point=0;
			int[] l= {-1,-1,-1};
			for(int i=0; i<3; i++ ) {
				int k=r.nextInt(5);
				l[i]=k;
				for(int j=0; j<3; j++) {
					if(l[j]==k && i!=j) {
						k=r.nextInt(5);
						j=0;
					}
				}
				System.out.println("문제"+(i+1));
				String testword=enword[k];
				System.out.println(mean[k]+"\n단어를 입력하세요");
				String inputword=in.nextLine();
				if(testword.equals(inputword)) {
					point++;
				}
			}
			System.out.println("총점수:"+point);
			System.out.println("시험을 다시 원한다면 '1' 종료를 원한다면'2'를 입력하세요");
			int re=in.nextInt();
			in.nextLine();
			for(int i=0;i<1; i++) {
				if(re!=1 && re!=2) {
					System.out.println("다시 입력하세요");
					i--;
				}
			}
			if(re==2) {
				break;
			}
		}
	}
 	//중복 없는 랜덤 번호 뽑기 기능
 	public static void randomnum() {
 		
 	}

}










