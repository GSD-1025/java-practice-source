package main;

import lombok.Data;

@Data
public class ChickenDTO extends Franchise{
	private int csize;
	private String cooking;
	
	
	@Override
	public void setchick(int csize,String cooking) {
		this.csize=csize;
		this.cooking=cooking;
	}


	@Override
	public int getchicksize() {
		return this.csize;
	}


	@Override
	public String getchickcook() {
		// TODO Auto-generated method stub
		return this.cooking;
	}


	@Override
	public void prt() {
		super.prt();
		if(super.getType().equals("chicken")) {
			System.out.print("정보->  ");
			System.out.print("사이즈: "+this.csize+"\t");
			System.out.print("조리방식: "+this.cooking);
			System.out.println();
		}
	}
	
	
	
	
	
	
	
	
	
}
