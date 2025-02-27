package main;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class TimeAttack {
	Thousand tAddr = null;
	private Thousand t = new Thousand();
	private ArrayList<Character> cheonja= new ArrayList<Character>();
	private ArrayList<Character> cheonjayin= new ArrayList<Character>();
	
	public void start(Thousand tAddr) {
		this.tAddr = tAddr;
		startPreparing();
		Scanner in = new Scanner(System.in);
		Random r = new Random();
		double timeElapsed = 0;
		int endTime = 20;
		int intFinish = 0;
		double finish = 0;
		double remainTime = endTime;
		int rIndex = 0;
		String input = null;
		int point = 0;
		
		System.out.println("타임어택에 오신 것을 환영합니다");
		System.out.println("이 게임은 제한 시간 안에 얼마나 많은 한자의 음을 맞추는지 테스트합니다");
		System.out.println("제한 시간은 "+endTime+"초입니다 게임을 시작하시려면 enter를 누르십시오");
		in.nextLine();
		System.out.println("게임을 시작합니다");
		
		double start = System.currentTimeMillis()/1000;
		int i = 0;
		
		while(true) {
			finish = System.currentTimeMillis()/(double)1000;
			timeElapsed = finish - start;
			remainTime = ((int)((endTime-timeElapsed)*10))/(double)10;
				
			if(remainTime <= 0)
				break;
			
			if(i < 4)
				rIndex = i;
			else
				rIndex = r.nextInt(1000);
			i++;
			
			if(remainTime >= 100)
				System.out.println("남은 시간: "+remainTime+"   한자: "+cheonja.get(rIndex)+"   "+"   현재 스코어: "+point);
			else if(remainTime >= 10)
				System.out.println("남은 시간: "+remainTime+"    한자: "+cheonja.get(rIndex)+"   "+"   현재 스코어: "+point);
			else
				System.out.println("남은 시간: "+remainTime+"     한자: "+cheonja.get(rIndex)+"   "+"   현재 스코어: "+point);
			
			input = in.nextLine();
			
			if(input.equals(""+cheonjayin.get(rIndex))) {
				point++;				
				System.out.println("점수를 획득하셨습니다");
			}
		}
		System.out.println("게임이 끝났습니다\n");
		System.out.println("최종 스코어: "+point+"\n\n");
	}
	private void startPreparing() {
		setCheonja();
		setCheonjayin();
	}
	private void setCheonja() {
		this.cheonja = new ArrayList<Character>(tAddr.getCheonja());
	}
	private void setCheonjayin() {	
		this.cheonjayin = new ArrayList<Character>(tAddr.getCheonjayin());
	}
}
	