package buru;

import java.util.Random;
import java.util.Scanner;

public class example {
	static String[][][] map= new String[11][11][7];
	static int player=1;
	static int dice;
	static int duobdice;
	static Random ran= new Random();
	static Scanner in= new Scanner(System.in); 
	public static void main(String[] args) {
		temp();
		mapinfo();
		mapprint();
		while(true) {
			System.out.println("게임 시작");
			in.nextLine();
			while(true) {
				System.out.println("플레이어 "+player);
				//주사위 굴리기
				dice=0;
				dice=rolldice();
				movingupdate(2+player);
				mapprint();
				if(duobdice==1) {
					System.out.println();
					System.out.println("더블 한번 더");
					dice=0;
					dice=rolldice();
					
					movingupdate(2+player);
					mapprint();
				}
				player++;
				if (player>4) {
					player=1;
				}
				//땅정보 갱신
				System.out.println("다음 순서");
				String next=in.nextLine();
				if (next.equals("종료")){
					break;
				}
			}
			
		}
		
	}
	public static void mapprint() {
		for(int i=0; i<11; i++) {
			for(int j=0; j<11; j++) {
				System.out.print(map[i][j][0]+"  ");
				if(map[i][j][3].equals("p1")) {
					System.out.print("<-"+map[i][j][3]);
				}
				if(map[i][j][4].equals("p2")) {
					System.out.print("<-"+map[i][j][4]);
				}
				if(map[i][j][5].equals("p3")) {
					System.out.print("<-"+map[i][j][5]);
				}
				if(map[i][j][6].equals("p4")) {
					System.out.print("<-"+map[i][j][6]);
				}
			}
			System.out.println();
		}
	}
	public static void mapprint2() {
		for(int i=0; i<11; i++) {
			for(int j=0; j<11; j++) {
				System.out.print(map[i][j][2+player]+" ");
			}
			System.out.println();
			System.out.println();
		}
	}
	//맵 정보 넣기
	public static void mapinfo() {
		map[0][0][0]="기부 복권";
		map[10][10][0]="출발";
		map[10][0][0]="무인도";
		map[0][10][0]="우주 여행";
		String[] mapl1= {"대만","기부","중국","필리핀","제주도","싱가포르","기부","이집트","터키"};
		String[] mapl2= {"그리스","기부","덴마크","스웨덴","여객기","스위스","기부","독일","캐나다"};
		String[] mapl3= {"아르헨티나","기부","브라질","기부","부산","하와이","포르투갈","크루즈","스페인"};
		String[] mapl4= {"일본","우주선","프랑스","이탈리아","기부","영국","미국","기부","대한민국"};
		//라인1
		for(int i=0; i<3;i++) {
			for(int j=0; j<9; j++) {
				if(i==0) {
				  map[10][9-j][i]=mapl1[j];
				}else if(map[10][9-j][0].equals("기부")) {
				  map[10][9-j][1]="100000";
				  map[10][9-j][2]="0";
				}else if(i==1) {
				  map[10][9-j][i]="200000";
				}else if(i==2) {
				  map[10][9-j][i]="0";
				}else if(i==3) {
				  map[10][9-j][i]=" ";
				}
			}
		}
		//라인2
		for(int i=0; i<3;i++) {
			for(int j=0; j<9; j++) {
				if(i==0) {
				  map[9-j][0][i]=mapl2[j];
				}else if(map[9-j][0][0].equals("기부")) {
				  map[9-j][0][1]="100000";
				  map[9-j][0][2]="0";
				}else if(i==1) {
				  map[9-j][0][i]="300000";
				}else if(i==2) {
				  map[9-j][0][i]="0";
				}else if(i==3) {
				  map[9-j][0][i]=" ";
				}
			}
		}
		//라인3
		for(int i=0; i<3;i++) {
			for(int j=0; j<9; j++) {
				if(i==0) {
				  map[0][j+1][i]=mapl3[j];
				}else if(map[0][j+1][0].equals("기부")) {
				  map[0][j+1][1]="100000";
				  map[0][j+1][2]="0";
				}else if(i==1) {
				  map[0][j+1][i]="400000";
				}else if(i==2) {
				  map[0][j+1][i]="0";
				}else if(i==3) {
				  map[0][j+1][i]=" ";
				}
			}
		}
		//라인4
		for(int i=0; i<3;i++) {
			for(int j=0; j<9; j++) {
				if(i==0) {
				  map[j+1][10][i]=mapl4[j];
				}else if(map[j+1][10][0].equals("기부")) {
				  map[j+1][10][1]="100000";
				  map[j+1][10][2]="0";
				}else if(i==1) {
				  map[j+1][10][i]="500000";
				}else if(i==2) {
				  map[j+1][10][i]="0";
				}else if(i==3) {
				  map[j+1][10][i]=" ";
				}
			}
		}
		map[10][10][3]="p1";
		map[10][10][4]="p2";
		map[10][10][5]="p3";
		map[10][10][6]="p4";
	}
	//주사위 굴리기
	public static int rolldice() {
		duobdice=0;
		int dice1=ran.nextInt(6)+1;
		int dice2=ran.nextInt(6)+1;
		if(dice1==dice2) {
			duobdice=1;
		}
		return dice1+dice2;
	}
	//이동정보 갱신
	public static void movingupdate(int a){
		System.out.println("주사위 "+dice);
		int cnt=dice;
		int s=0;
		String start=null;
		while(cnt>0) {
			start=map[0][10][a];
			for(int i=(map.length-1);i>s; i--) {
				map[s][i][a]=map[s][i-1][a];
			}
			for(int i=s; i<map.length-1; i++) {
				map[i][s][a]=map[i+1][s][a];
			}
			for(int i=s; i<map.length-1; i++) {
				map[map.length-1][i][a]=map[map.length-1][i+1][a];
			}
			for(int i=map.length-1; i>s; i--) {
				map[i][map.length-1][a]=map[i-1][map.length-1][a];
			}
			map[0][10][a]=start;
			cnt--;
		}
		
	}
	//땅정보 갱신
	public static void landupdate() {
		
	}
	public static void temp() {
		for(int i=0; i<11; i++) {
			for(int j=0; j<11; j++) {
				for(int k=0; k<3; k++) {
					map[i][j][k]="        ";
				}
				for(int k=3; k<7; k++) {
					map[i][j][k]="+";
				}
			}
			
		}
	}
	
	
	
	
	
	
	
}
