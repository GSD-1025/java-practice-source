package main;

import lombok.Data;

@Data
public class Franchise {
	private String fname;
	private String mname;
	private String type;
	private int recostar;
	
	public void setchick(int csize,String cooking) {
		
	}
	public void setpizz(String topping,String psize) {
	}
	public void setburg(String petty, String bun, String drink) {
		
	}	
	public int getchicksize() {	
		return 0;
	}
	public String getchickcook() {
		return null;
	}
	public String getpizz(int a) {
		return null;
	}
	public String getburg(int b) {
		return null;
	}
	
	public void prt() {
		System.out.println("프랜차이즈 명:"+this.fname);
		System.out.print("업좋: "+this.type);
		System.out.println("메뉴: "+this.mname);
		System.out.print("추천도: ");
		for(int i=0; i<this.recostar; i++) {
			System.out.print("★");
		}
		System.out.println();
	}
	
	
}
