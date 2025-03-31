package item;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data

public class ItemDTO {
	
	
	
	private String id;
	private String iname;
	private int price;
	private String itype;
	private int amount;
	private String chman;
	private String idate;
	private String inform;
	private static final String nid="hm";
	
	public static String getNid() {
		return nid;
	}
	
	
	public void prt() {
		System.out.print(this.id+" ");
		System.out.print(this.iname+" ");
		System.out.print(this.price+"원  ");
		System.out.print(this.amount+"개   ");
		System.out.println("  "+this.itype);
		System.out.print("담당자 :"+this.chman);
		System.out.println("    "+this.idate+" ");
		System.out.println("정보 :"+this.inform);
	}
}
