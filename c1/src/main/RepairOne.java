package main;

public class RepairOne {
	private String num=null;
	private String date=null;
	private String memo=null;
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public void prt() {
		System.out.println("수리 날짜: "+this.date);
		System.out.println("수리 내역: "+this.memo);
	}

}
