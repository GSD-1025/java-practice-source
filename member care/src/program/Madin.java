package program;

import java.util.Scanner;

public class Madin {
	static Memo memoList[]= new Memo[10];
	static Scanner in=new Scanner(System.in);
	static String wid=null;
	Madin(String id){
		System.out.println("메모관리 시작");
		this.wid=id;
		System.out.println("작성자: "+wid);
		System.out.println("메모 작성은 1번 메모 수정은 2번 메모 삭제는 3번 메모 보기는 4번");
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
		System.out.println("삭제 시작");
		for(int i=0; i<10; i++) {
			if(memoList[i]!=null&&wid.equals(memoList[i].id)) {
				System.out.println(i+"번 "+memoList[i].title);
				System.out.println("by "+memoList[i].id);
			}
		}
		System.out.println("삭제하고 싶은 메모 제목의 인덱스를 입력하세요");
		int ent=in.nextInt();
		in.nextLine();
		memoList[ent].title=null;
		memoList[ent].cont=null;
		memoList[ent].id=null;
	}
	private void mod() {
		System.out.println("수정 시작");
		for(int i=0; i<10; i++) {
			if(memoList[i]!=null&&wid.equals(memoList[i].id)) {
				System.out.println(i+"번 "+memoList[i].title);
				System.out.println("by "+memoList[i].id);
			}
		}
		System.out.println("수정하고 싶은 메모 제목의 인덱스를 입력하세요");
		int ent=in.nextInt();
		in.nextLine();
		System.out.println("수정할 내용 입력");
		memoList[ent].title=in.nextLine();
	}
	private void add() {
		System.out.println("작성 시작\n제목을 입력하세요");
		String title=in.nextLine();
		System.out.println("내용을 입력하세요");
		String cont=in.nextLine();
		String id=wid;
		Memo temp=new Memo(title,cont,id);
		for(int i=0; i<10; i++) {
			if(memoList[i]==null) {
				memoList[i]=temp;
				break;
			}else {
				System.out.println("메모장이 꽉찼습니다");
			}
		}
	}
	

}
