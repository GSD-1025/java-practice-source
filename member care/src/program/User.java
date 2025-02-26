package program;

public class User {
	String id=null;
	String name=null;
	String add=null;
	boolean minor=false;
	User(String id,String name,String add,boolean minor ){
		this.id=id;
		this.name=name;
		this.add=add;
		this.minor=minor;
	}
	public void Uprt() {
		System.out.println(id);
		System.out.println(name);
		System.out.println(add);
	}

}
