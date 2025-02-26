package main;

public class Car {
	private int num=0;
	private String name=null;
	private String mechanic=null;
	
	public String getMechanic() {
		return mechanic;
	}
	public void setMechanic(String mechanic) {
		if(mechanic.equals("없음")) {
			this.mechanic=null;
		}else {
			this.mechanic = mechanic;
		}
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
