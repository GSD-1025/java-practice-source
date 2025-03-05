package tryTest;

public class Test {
	
	
	public void abc() {
		System.out.println("a");
		int[] aa= new int[3];
		try {
			System.out.println(aa[2]);
			//System.out.println(aa[4]);
			Test t=null;
			t.kkk();
		}catch (NullPointerException e) {	
			System.out.println("널포인트");
		}catch (ArrayIndexOutOfBoundsException e) {										
			System.out.println("배열범위");
		}catch (Exception e) {
			System.out.println("예외");
		}finally {
			System.out.println("try 구문 종료");
		}
		System.out.println("b");
		System.out.println("c");
	}
	
	public void kkk() {
		System.out.println("kkk");
	}

}
