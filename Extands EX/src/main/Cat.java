package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import inf.ServiceINF;

public class Cat extends Super{
	String catname;
	ArrayList<String> record=new ArrayList<>();
	ServiceTool st=ServiceTool.getInstance();
	List<ServiceINF> servicelist=new ArrayList<>();
	int catage;
	Scanner in=new Scanner(System.in);
	
	
	public Cat() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void eating() {
		System.out.println("고양이밥");
	}
	private void beforeeat() {
		System.out.println("밥 먹기전에 세수");
	}
	
	
	@Override
	public void menu() {
		System.out.println("보호자 입력");
		String username=in.nextLine();
		System.out.println("고양이 이름입력");
		String catname=in.nextLine();
		super.username=username;
		this.catname=catname;
		System.out.println("1. 등록  2.먹이주기  3.잠자기");
		addservice();
	}
	
	
	private void addservice() {
		ServiceINF service=st.choiceService();
		servicelist.add(service);
	}
	
	private void servicePrt() {
		System.out.println("서비스 리스트 출력");
		for(ServiceINF s:servicelist) {
			s.info();
		}
	}
	
	@Override
	public void prt() {
		super.prt();
		System.out.println("고양이 이름: "+this.catname);
		System.out.println("고양이 진료 리스트");
		for(String s:record) {
			System.out.println(s);
			
		}
		servicePrt();
	}

}
