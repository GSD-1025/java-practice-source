package main;

import lombok.Data;

@Data
public class PizzaDTO extends Franchise{
	private String psize;
	private String topping;

	
	
	
	@Override
	public void setpizz(String psize,String topping ) {
		this.psize=psize;
		this.topping=topping;
	}



	@Override
	public String getpizz(int a) {
		if(a==1) {
			return this.psize;
		}else if(a==2) {
			return this.topping;
		}
		return null;
	}



	@Override
	public void prt() {
		// TODO Auto-generated method stub
		super.prt();
		if(super.getType().equals("pizza")) {
			System.out.print("정보->  ");
			System.out.print("사이즈: "+this.psize+"\t");
			System.out.print("토핑: "+this.topping);
			System.out.println();
		}
	}
	
	
	
	

}
