package manage;

public class User {
	private String id=null;
	private String name=null;
	
	public void setId(String id) {    //Setter
		System.out.println(id+ " 로 이름 바꾸고 싶구나");
		this.id=id;
	}
	
	public String getId() {   //Getter
		return this.id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
