package main;

import java.util.Scanner;

public class User {
	String id=null;
	String name=null;
	String addr=null;
	boolean adultFlag=true;
	String[] hobby= new String[5];
	Memo[] memo= new Memo[10];
	User(String id, String name, String addr,boolean adultFlag){
		this.id=id;
		this.name=name;
		this.addr=addr;
		this.adultFlag=adultFlag;
	}
	
	public void prt() { //�ٸ� Ŭ�������� ��������� ���� �������� ����
		                //prt() �޼��带 ���ؼ� �����ض� (����ȭ)
		System.out.println("ID :"+ id);
		String prtName=this.name;
		if(!adultFlag) {
			System.out.println("�̸� :"+ prtName+"(�̼�����)");
		}else {
			System.out.println("�̸� :"+ prtName);
		}
		
		System.out.println("���---------------");
		for(int i=0; i<5; i++) {
			if(hobby[i]!=null) {
				System.out.println(hobby[i]);
			}
		}
		System.out.println("�޸�---------------");
		for(int i=0; i<5; i++) {
			if(memo[i]!=null) {
				System.out.println(memo[i]);
			}
		}
	}
	public void setname(String name) {
		this.name=name;
	}
	public void menu() {
		while(true) {
			System.out.println("1. ���� ����  2. �޸� �߰�  3. ��� �߰�  4. ���� ����");
			Scanner in= new Scanner(System.in);
			int a= in.nextInt();
			in.nextLine();
			if(a==1) {
				modinfo();
			}else if(a==2) {
				addmemo();
			}else if(a==3) {
				addhobby();
			}else if(a==2) {
				;
			}
			else {
				break;
			}
		}
	}

	private void addhobby() {
		Scanner in= new Scanner(System.in);
		System.out.println("�ִ� 5������ �Է��� �����մϴ�");
		for(int i=0; i<5; i++) {
			String hob=in.nextLine();
			for(int j=0; j<hobby.length; j++) {
				if(hobby[j]==null) {
					hobby[j]=hob;
					break;
				}
			}
		}
		
	}

	private void addmemo() {
		Scanner in= new Scanner(System.in);
		System.out.println("���� �Է�");
		String title=in.nextLine();
		System.out.println("���� �Է�");
		String content=in.nextLine();
		Memo temp= new Memo();
		temp.setmemo(title, content);
		for(int i=0; i<memo.length; i++) {
			if(memo[i]==null) {
				memo[i]=temp;
				break;
			}
		}
	}

	private void modinfo() {
		Scanner in= new Scanner(System.in);
		System.out.println("���ο� �̸��� �Է��ϼ���");
		String name=in.nextLine();
		this.name=name;
		
	}
}
