package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import inf.Analasis;
import inf.Bloodtest;
import inf.ServiceINF;
import inf.Xray;

public class Dog extends Super{

	String dogname;
	int dogage;
	Scanner in=new Scanner(System.in);
	ServiceTool st=ServiceTool.getInstance();
	List<ServiceINF> servicelist=new ArrayList<>();
	
	public Dog() {	
	}
	
	@Override
	public void eating() {
		System.out.println("개밥");
	}
	private void beforeeat() {
		System.out.println(username);
		System.out.println("밥 먹기전에 세수");
	}
	
	@Override
	public void menu() {
		System.out.println("보호자 입력");
		String username=in.nextLine();
		System.out.println("강아지 이름입력");
		String dogname=in.nextLine();
		super.username=username;
		this.dogname=dogname;
		System.out.println("1. 등록  2.먹이주기  3.잠자기");
		System.out.println("서비스 등록");
		addservice();
	}
	
	
	private void addservice() {
		ServiceINF service=st.choiceService();
		servicelist.add(service);
	}

	@Override
	public void prt() {
		super.prt();
		System.out.println("강아지 이름 :"+this.dogname);
		servicePrt(); 
	}
	
	private void servicePrt() {
		System.out.println("서비스 리스트 출력");
		for(ServiceINF s:servicelist) {
			s.info();
		}
	}


}
