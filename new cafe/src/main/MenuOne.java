package main;

public class MenuOne {
	String name=null;
	int price=0;
	String inform=null;
	
	MenuOne(String name, int price, String inform){
		this.name=name;
		this.price=price;
		this.inform=inform;
	}
	
	public void prt(int a,int b) {
		if(b==1) {
			System.out.println(a+"�� �޴� "+name);
			System.out.println(price+"��");
			System.out.println(inform);
		}else if(b==2) {
			System.out.println(a+"�� �޴� "+name);
		}
		
	}

}
