package Testcode;

import java.util.ArrayList;

public class ListTestCode {

	public static void main(String[] args) {
		// List test용
		
		ArrayList<String> a= new ArrayList<String>();
		ArrayList<String> b= new ArrayList<String>();
		//추가하는 방법
		String name="kim";
		a.add(name);
		System.out.println("사이즈 : "+b.size());
		a.add(name);
		System.out.println("사이즈 : "+a.size());
		
	
		//a> 0    1
		//   kim  kim
		String n="Lee";
		a.add(n);
		//a> 0    1    2
		//   kim  kim  Lee
		System.out.println("사이즈 : "+a.size());
		//순서 있고 전체 출력
		for(int i=0; i<a.size(); i++) {
			System.out.println(i+"인덱스 값: "+ a.get(i));
		}
		//순서 있고 전체출력> 확장된 for로 작성
		for(String s: a) {
			System.out.println("값: "+s);
		}
		//삭제
		a.remove(1); //1번 인덱스를 삭제
		System.out.println("사이즈 : "+a.size());
		for(int i=0; i<a.size(); i++) {
			System.out.println(i+"인덱스 값: "+ a.get(i));
		}
		//삽입
		a.add(0,"park"); //0번 인덱스에 삽입한다
		for(int i=0; i<a.size(); i++) {
			System.out.println(i+"인덱스 값: "+ a.get(i));
		}
		//수정
		a.set(1, "kkk"); //1번 인덱스 수정
		for(int i=0; i<a.size(); i++) {
			System.out.println(i+"인덱스 값: "+ a.get(i));
		}
	}

}
