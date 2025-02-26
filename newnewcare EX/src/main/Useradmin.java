package main;

import java.util.Scanner;

public class Useradmin {
	User[] ulist= new User[5];
	
	public void mainStart() {
		Scanner in=new Scanner(System.in);
		System.out.println("����");
		while(true) {
			menu();
			System.out.println("����");
			int a=in.nextInt();
			in.nextLine();
			if(a==1) {
				add();
			}else if(a==2) {
				list();
			}else if(a==3) {
				delete();
			}else if(a==4) {
				mod();
			}else if(a==5) {
				search();
			}else {
				break;
			}
		}
		in.close();
	}
	
	public void menu() {
		System.out.println("1.�߰�");
		System.out.println("2.��ü����");
		System.out.println("1.����");
		System.out.println("1.����");
		System.out.println("1.�˻�");
		
	}
	public void add() {
		Scanner in=new Scanner(System.in);
		System.out.println("����� �߰�");
		System.out.println("���̵� �Է�");
		String id=in.nextLine();
		System.out.println("�̸� �Է�");
		String name=in.nextLine();
		System.out.println("�ּ� �Է�");
		String addr=in.nextLine();
		System.out.println("1.���� 2. �̼�����");
		String a=in.nextLine();
		boolean adultFlag=true;
		if(a.equals("2")) {
			adultFlag=false;
		}
		User user=new User(id,name,addr,adultFlag);
		for(int i=0; i<5; i++) {
			if(ulist[i]==null) {
			   ulist[i]= user; // �ּҺ���
			   break;
			}
		}
		in.close();
	}
	public void list() {
		for(int i=0; i<ulist.length; i++) {
			if(ulist[i]!=null) {
				ulist[i].prt();
			}
		}
		
	}
	public void delete() {
		Scanner in=new Scanner(System.in);
		//���̵� �Է¹޾Ƽ� ����
		System.out.println("���̵� �Է��ϼ���");
		String eid=in.nextLine();
		for(int i=0; i<ulist.length; i++) {
			if(ulist[i]!=null) {
				if(ulist[i].id.equals(eid)) {
					ulist[i]=null;
					break;
				}
			}
		}
		in.close();
	}
	public void mod() {
		Scanner in=new Scanner(System.in);
		//���̵� �Է¹޾Ƽ� ����
		//���� 1. ���̵� �Է¹޴´�.  2.�迭���� ã�´�.  3. �����Ѵ�(�̸���)
		System.out.println("���̵� �Է��ϼ���");
		String eid=in.nextLine();
		for(int i=0; i<ulist.length; i++) {
			if(ulist[i]!=null) {
				if(ulist[i].id.equals(eid)) {
					//System.out.println("������ �̸��� �Է��ϼ���");
					//String newname=in.nextLine();
					//ulsit[i].name=newname;->���� ������ ���� ����
					//ulist[i].setname(newname);
					ulist[i].menu();
				}
			}
		}
	}
	public void search() {
		Scanner in=new Scanner(System.in);
		System.out.println("�˻���(id)�� �Է��ϼ���");
		String eid=in.nextLine();
		for(int i=0; i<ulist.length; i++) {
			if(ulist[i]!=null) {
				//if(ulist[i].id.equals(eid)) {
				//indexOf  �޼���   ��� :���ڿ��� �ε��� ã��    ����   ���ϰ�: ��ġ�� �ε�����ȣ/ ���ٸ� -1 ��ȯ
				if(ulist[i].id.indexOf(eid)!=-1) {
					ulist[i].prt();
				}
			}
		}
	}
	
	

}
