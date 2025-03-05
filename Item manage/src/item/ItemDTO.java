package item;

public class ItemDTO {
	private String id;
	private String iname;
	private int price;
	private String itype;
	private int amount;
	private String chman;
	private String idate;
	private String inform;
	
	
	
	public String getInform() {
		return inform;
	}
	public void setInform(String inform) {
		this.inform = inform;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getIname() {
		return iname;
	}
	public void setIname(String iname) {
		this.iname = iname;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getItype() {
		return itype;
	}
	public void setItype(String itype) {
		this.itype = itype;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getChman() {
		return chman;
	}
	public void setChman(String chman) {
		this.chman = chman;
	}
	public String getIdate() {
		return idate;
	}
	public void setIdate(String idate) {
		this.idate = idate;
	}
	public void prt() {
		System.out.print(this.id+" ");
		System.out.print(this.iname+" ");
		System.out.print(this.price+"원  ");
		System.out.print(this.amount+"개   ");
		System.out.println("  "+this.itype);
		System.out.print(this.chman+"   ");
		System.out.println(this.idate+" ");
		System.out.println(this.inform);
	}
}
