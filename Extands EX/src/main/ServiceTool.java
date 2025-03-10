package main;

import java.util.Scanner;

import inf.Analasis;
import inf.Bloodtest;
import inf.ServiceINF;
import inf.Xray;

public class ServiceTool {
	
	private static ServiceTool st=null;
	
	
	public ServiceTool() {
		
	}
	
	public static ServiceTool getInstance() {
		if(st==null) {
			st=new ServiceTool();
		}
		return st;
	}
	
	public ServiceINF choiceService() {
		Scanner in=new Scanner(System.in);
		ServiceINF service=null;
		System.out.println("원하는 서비스를 선택하세요");
		System.out.println("1.엑스레이  2.소변  3.혈액");
		int a=in.nextInt();
		in.nextLine();
		switch(a) {
		case 1:
			service=new Xray();
			break;
		case 2:
			service=new Analasis();
			break;
		case 3:
			service=new Bloodtest();
			break;
		}
		return service;
	}

}
