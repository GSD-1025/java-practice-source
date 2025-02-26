package main;

public class Main {

	public static void main(String[] args) {
		// 의존한다는 것은 객체가 필요하다..
		//1.객체를 만든다  2.객체의 주소값을 갖는다;
		Useradmin useradmin= null; // 객체를 알아야한다. (의존)
		useradmin= new Useradmin();// 객페를 직접 생성해서 알게 됨.
		useradmin.mainStart();

	}

}
