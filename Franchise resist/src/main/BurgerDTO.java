package main;

import lombok.Data;

@Data
public class BurgerDTO extends Franchise{
	private String petty;
	private String bun;
	private String drink;
	
	@Override
	public void setburg(String petty, String bun, String drink) {
		this.petty=petty;
		this.bun=bun;
		this.drink=drink;
	}

	@Override
	public String getburg(int a) {
		if(a==1){
			return this.petty;
		}else if(a==2) {
			return this.bun;
		}else if(a==3) {
			return this.drink;
		}
		return null;
	}

	@Override
	public void prt() {
		super.prt();
		if(super.getType().equals("burger")) {
			System.out.print("정보->");
			System.out.print("패티: "+this.petty+"\t");
			System.out.print("번: "+this.bun);
			System.out.println("음료: "+this.drink);
			System.out.println();
		}
	}
	
	
	
	
	
	

}
