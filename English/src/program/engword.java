package program;

import java.util.Random;
import java.util.Scanner;

public class engword {
	static String[] enword= new String[5];
	static String[] mean= new String[5];
	static Scanner in= new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("�ܾ��� ���α׷� ��ŸƮ");
		input_save();
		printword();
		while(true) {
			System.out.println("���ϴ� ����� �����ϼ���.\n'1': �ܾ� �˻�   '2':�ܾ� ����  '3':�ܾ� ����  '4':�ܾ��� ���  '5': �ܾ� ����  '6': ����");
			int ut=in.nextInt();
			in.nextLine();
			if(ut==1) {
				System.out.println("���ϴ� �˻��� �����ϼ���.\n'1':��ü �ܾ� �˻�  '2':���Ե� �ܾ� �˻�");
				int ser=in.nextInt();
				in.nextLine();
				if(ser==1) {
					searchword1();
				}else {
					searchword2();
				}
			}else if(ut==2) {
				deleteword();
			}else if(ut==3) {
				updateword();
			}else if(ut==4) {
				printword();
			}else if(ut==5) {
				testword();
			}else if(ut==6) {
				System.out.println("���α׷� ����");
				break;
			}else {
				System.out.println("�Է��Ͻ� ��ȣ�� �ش��ϴ� ����� �����ϴ�.\n��ȣ�� �ٽ� �Է��ϼ���");
			}
		}
	}
	//�Է� �� ���� ���
	public static void input_save() {
		System.out.println("�ܾ �Է� �� �����մϴ�");
		for(int i=0; i<5; i++) {
			System.out.println("�ܾ �Է��ϼ���");
			enword[i]=in.nextLine();
			System.out.println("�ܾ��� ���� �Է��ϼ���");
			mean[i]=in.nextLine();
		}
	}
	//��� ���
	public static void printword() { 
		System.out.println("�ܾ��� ���");
		for(int i=0; i<5; i++) {
			System.out.print(enword[i]+":");
			System.out.print(mean[i]);
			System.out.println();
		}
		System.out.println();
	}
	//��ü �ܾ� �˻� ���
	public static void searchword1() { 
		System.out.println("��ü �ܾ� �˻� ����");
		System.out.println("�˻��� �ܾ �Է��ϼ���");
		while(true) {
			String serw=in.nextLine();
			if(serw.equals("����")) {
				System.out.println("�˻� ����");
				break;
			}
			int flag=checkword(serw);
			if(flag!=-1) {
				System.out.println(serw);
				System.out.println("��: "+mean[flag]);
			}else {
				System.out.println("����");
			}
			System.out.println("���� �˻�");
		}
			
	}
	//���Ե� �ܾ� �˻� ���
	public static void searchword2() { 
		System.out.println("���Ե� �ܾ� �˻� ����");
		System.out.println("�˻��� �ܾ� �Է��ϼ���");
		while(true) {
			String serw=in.nextLine();
			if(serw.equals("����")) {
				System.out.println("�˻� ����");
				return;
			}else {
				test1(serw);
			}
			System.out.println("���� �˻� �ܾ �Է��ϼ���");
		}
	}
	//���� ���
	public static void deleteword() { 
		System.out.println("�ܾ� ���� ����");
		System.out.println("������ �ܾ �Է��ϼ���");
		int cnt=0;
		while(true) {
			String delw=in.nextLine();
			if(delw.equals("����")) {
				System.out.println("���� ����");
				return;
			}
			int flag=checkword(delw);
			if (flag!=-1) {
				cnt++;
				System.out.println(enword[flag]+" ����\n������ ���ϴ� �ٸ� �ܾ �Է��ϼ���");
				enword[flag]="������"+cnt;
				mean[flag]="   ";
			}else {
				System.out.println("�ش� �ܾ� ����\n�ܾ �ٽ� �Է��ϼ���");
				continue;
			}
		}
	}
	//���� ���
	public static void updateword() { 
		System.out.println("�ܾ� ���� ����");
		System.out.println("������ �ܾ �Է��ϼ���");
		while(true) {
			String delw=in.nextLine();
			if(delw.equals("����")) {
				System.out.println("���� ����");
				return;
			}
			int flag=checkword(delw);
			if (flag!=-1) {
				System.out.println("�ٽ� ���� �ܾ�� ���� �ٽ� �Է��ϼ���");
				System.out.println("�ܾ�");
				enword[flag]=in.nextLine();
				System.out.println("��");
				mean[flag]=in.nextLine();
				System.out.println("���� �Ϸ� ���� �ܾ �Է��ϼ���");
			}else {
				System.out.println("�ش� �ܾ� ����\n�ܾ �ٽ� �Է��ϼ���");
				continue;
			}
		}
	}
	//�ܾ� ��ġ ���� ���
	public static int checkword(String a) { 
		for(int i=0; i<5; i++) {
			if(enword[i].equals(a)) {
				return i;	
			}
		}return -1;
	}
	//���ĺ� ��ġ���� ���
	public static void checkalp(String a) {
		for(int i=0; i<5; i++) {
			if(enword[i].indexOf(a)!=-1) {
				System.out.println(enword[i]);
				System.out.println("��: "+mean[i]);
			}
		}
	}
	//�׽�Ʈ�� method(���Ե� �ܾ� ã��)
	public static void test1(String a) {
		for(int i=0; i<5; i++) {
			int k=0;
			String c=String.valueOf(enword[i].charAt(k));
			for(int j=k+1; j<enword[i].length(); j++) {
				c+=String.valueOf(enword[i].charAt(j));
				if(c.equals(a)) {
					 System.out.println(enword[i]);
					 break;
				}
				if(c.length()==a.length()) {
					 c=null;
					 k++;
					 j=k;
					 c=String.valueOf(a.charAt(k));
				}
			 }
		}
		
	}
	//�ܾ� ���� ���
 	public static void testword(){
		System.out.println("�ܾ� ���� ����");
		while(true) {
			Random r= new Random();
			int point=0;
			int[] l= {-1,-1,-1};
			for(int i=0; i<3; i++ ) {
				int k=r.nextInt(5);
				l[i]=k;
				for(int j=0; j<3; j++) {
					if(l[j]==k && i!=j) {
						k=r.nextInt(5);
						j=0;
					}
				}
				System.out.println("����"+(i+1));
				String testword=enword[k];
				System.out.println(mean[k]+"\n�ܾ �Է��ϼ���");
				String inputword=in.nextLine();
				if(testword.equals(inputword)) {
					point++;
				}
			}
			System.out.println("������:"+point);
			System.out.println("������ �ٽ� ���Ѵٸ� '1' ���Ḧ ���Ѵٸ�'2'�� �Է��ϼ���");
			int re=in.nextInt();
			in.nextLine();
			for(int i=0;i<1; i++) {
				if(re!=1 && re!=2) {
					System.out.println("�ٽ� �Է��ϼ���");
					i--;
				}
			}
			if(re==2) {
				break;
			}
		}
	}
 	//�ߺ� ���� ���� ��ȣ �̱� ���
 	public static void randomnum() {
 		
 	}

}










