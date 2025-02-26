package program;

import java.util.Scanner;

public class Order {
	int onum=0;
	int cnt=0;
	Scanner in= new Scanner(System.in);
	Order(int a){
		if(a==2) {
			System.out.println("�ֹ��ϱ�\n�ֹ��� �̸� �Է�");
			String oname=in.nextLine();
			for(int i=0; i<10; i++) {
				if(Main.orderList[i][0]==null) {
					Main.orderList[i][0]=new Mdata(1);
					Main.orderList[i][0].oname=oname;
					onum=i;
					break;
				}
			}
			while(true) {
				System.out.println("���ϴ� �޴��� �����ϼ���\n1�� �ֹ��ϱ�  2�� �ֹ�����Ʈ Ȯ���ϱ�\n�̿��� ��ȣ�� ����");
				int ent1=in.nextInt();
				in.nextLine();
				if(ent1==1) {
					order();
					cnt++;
				}else if(cnt==0){
					System.out.println("�ֹ��Ͻ����� �����ϴ�\n�ֹ����� �ϼ���");
					continue;
				}else if(ent1==2) {
					confirm();
					break;
				}else {
					break;
				}
			}
		}else if(a==3) {
			check();
		}

	}
	private void confirm() {
		System.out.println("�ֹ�����Ʈ Ȯ���ϱ�");
		System.out.println(Main.orderList[onum][0].oname+"���� �ֹ�����Ʈ ");
		for(int i=1; i<6; i++) {
			if(Main.orderList[onum][i]!=null) {
				System.out.print(Main.orderList[onum][i].omenu+" "+Main.orderList[onum][i].count+"��\n");
			}
		}
		System.out.println();
		System.out.println("�ѱݾ��� "+Main.orderList[onum][6].price+" ��");
	}
	
	private void order() {
		for(int i=0; i<5 ;i++) {
			if(Main.menuList[i]!=null) {
				System.out.println((i+1)+"�� "+Main.menuList[i].name+" "+Main.menuList[i].price+"��");
				System.out.println(Main.menuList[i].inform);
			}
		}
		int ent1=0;
		int sumP=0;
		int dup=1;
		for(int i=0; i<5;i++) {
			System.out.println("�ֹ��� �޴��� ��ȣ�� �Է��ϼ���\n�ֹ� ��ȣ���� ��ȣ �Է½� �ֹ� ����");
			ent1=in.nextInt();
			in.nextLine();
			if(ent1<1 || ent1>5) {
				break;
			}
			String omenu=Main.menuList[ent1-1].name;
			//�ֹ��޴� �ߺ� üũ
			for(int j=1;j<6;j++) {
				if(Main.orderList[onum][j]!=null){
					if(omenu.equals(Main.orderList[onum][j].omenu)){
						dup=0;
						break;
					}
				}
			}
			System.out.println("������ �Է��ϼ���");
			int count=in.nextInt();
			in.nextLine();
			if(i>0&&dup==0) {
				System.out.println("�ߺ��ֹ�");
				Main.orderList[onum][ent1].count+=count;
				sumP+=Main.menuList[ent1-1].price*count;
				System.out.println("�ֹ��Ϸ�");
				dup=1;
				continue;
			}
			Main.orderList[onum][ent1]=new Mdata(1);
			Main.orderList[onum][ent1].omenu=omenu;
			Main.orderList[onum][ent1].count=count;
			sumP+=Main.menuList[ent1-1].price*count;
			System.out.println("�ֹ��Ϸ�\n���並 ����� ���ϽŴٸ� yes�� �Է����ּ���");
			String ent2=in.nextLine();
			if(ent2.equals("yes")) {
				review(ent1-1);
			}
			
		}
		Main.orderList[onum][6]=new Mdata(1);
		Main.orderList[onum][6].price=sumP;
		System.out.println("�ֹ��Ϸ�!!!!!");
	}

	public void check() {
		System.out.println("�ֹ��� ��ȸ");
		for(int i=0; i<10; i++) {
			if(Main.orderList[i][0]!=null) {
				System.out.print((i+1)+"�� "+Main.orderList[i][0].oname+" ");
			}
		}
		System.out.println();
		System.out.println("��ȸ�� �ֹ����� ��ȣ�� �Է��ϼ���");
		onum=in.nextInt()-1;
		confirm();
	}

	private void review(int num) {
		System.out.println(Main.menuList[num].name+"�� ���� ���並 ����ϼ���" );
		Main.review[onum][0]=new Mdata(1);
		Main.review[onum][0].oname=Main.orderList[onum][0].oname;
		Main.review[onum][1+num]=new Mdata(1);
		Main.review[onum][1+num].review=Main.menuList[num].name+": "+in.nextLine()+" by "+Main.orderList[onum][0].oname;
	}
}

