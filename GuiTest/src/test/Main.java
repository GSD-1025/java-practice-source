package test;

public class Main {

	public static void main(String[] args) {
		TDAO td=TDAO.getInstance();
		String image=td.getImagePath(); 
		System.out.println("경로:"+image);
		new Guimain();
		
	}

}
