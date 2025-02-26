package program;

import java.util.Scanner;

public class Madin {
	static Memo memoList[]= new Memo[10];
	static Scanner in=new Scanner(System.in);
	static String wid=null;
	Madin(String id){
		System.out.println("�޸���� ����");
		this.wid=id;
		System.out.println("�ۼ���: "+wid);
		System.out.println("�޸� �ۼ��� 1�� �޸� ������ 2�� �޸� ������ 3�� �޸� ����� 4��");
		int ent=in.nextInt();
		in.nextLine();
		if(ent==1) {
			add();
		}else if(ent==2) {
			mod();
		}else if(ent==3) {
			delete();
		}else if(ent==4) {
			print();
		}
	}
	private void print() {
		for(int i=0; i<10; i++) {
			if(memoList[i]!=null) {
				System.out.println(memoList[i].title);
				System.out.println(memoList[i].cont);
				System.out.println("by "+memoList[i].id);
			}
		}
		
	}
	private void delete() {
		System.out.println("���� ����");
		for(int i=0; i<10; i++) {
			if(memoList[i]!=null&&wid.equals(memoList[i].id)) {
				System.out.println(i+"�� "+memoList[i].title);
				System.out.println("by "+memoList[i].id);
			}
		}
		System.out.println("�����ϰ� ���� �޸� ������ �ε����� �Է��ϼ���");
		int ent=in.nextInt();
		in.nextLine();
		memoList[ent].title=null;
		memoList[ent].cont=null;
		memoList[ent].id=null;
	}
	private void mod() {
		System.out.println("���� ����");
		for(int i=0; i<10; i++) {
			if(memoList[i]!=null&&wid.equals(memoList[i].id)) {
				System.out.println(i+"�� "+memoList[i].title);
				System.out.println("by "+memoList[i].id);
			}
		}
		System.out.println("�����ϰ� ���� �޸� ������ �ε����� �Է��ϼ���");
		int ent=in.nextInt();
		in.nextLine();
		System.out.println("������ ���� �Է�");
		memoList[ent].title=in.nextLine();
	}
	private void add() {
		System.out.println("�ۼ� ����\n������ �Է��ϼ���");
		String title=in.nextLine();
		System.out.println("������ �Է��ϼ���");
		String cont=in.nextLine();
		String id=wid;
		Memo temp=new Memo(title,cont,id);
		for(int i=0; i<10; i++) {
			if(memoList[i]==null) {
				memoList[i]=temp;
				break;
			}else {
				System.out.println("�޸����� ��á���ϴ�");
			}
		}
	}
	

}
