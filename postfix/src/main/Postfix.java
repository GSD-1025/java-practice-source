package main;

import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Postfix {

	public static void main(String[] args) {
		Stack<String> num=new Stack<>();
		Stack<String> op=new Stack<>();
		Stack<String> fnum=new Stack<>();
		Stack<String> fop=new Stack<>();
		String a="2+3*4/(2-3)+10";
		String[] o= {"+","-","*","/","(",")"};
		StringTokenizer st=new StringTokenizer(a,"()+/*-",true);
		StringTokenizer st1=new StringTokenizer(a,"()+/*-");
		ArrayList<String> f= new ArrayList<String>();
		for(;st.hasMoreTokens();) {
			f.add(st.nextToken());		
		}
		System.out.println(f);
		String ap="";
		String k=null;
		for(int i=0; i<f.size(); i++) {
			if(f.get(i).equals("+")) {
				if(op.empty()==false) {
					if(op.peek().equals("*")||op.peek().equals("/")||op.peek().equals("-")||op.peek().equals("+")) {
						k=op.pop();
						fop.push(k);
						ap+=k;
					}
				}
				op.push(f.get(i));
			}else if(f.get(i).equals("-")) {
				if(op.empty()==false) {
					if(op.peek().equals("*")||op.peek().equals("/")||op.peek().equals("-")||op.peek().equals("+")) {
						k=op.pop();
						fop.push(k);
						ap+=k;
					}
				}
				op.push(f.get(i));
			}else if(f.get(i).equals("/")) {
				if(op.empty()==false) {
					if(op.peek().equals("*")||op.peek().equals("/")) {
						k=op.pop();
						fop.push(k);
						ap+=k;
					}	
				}
				op.push(f.get(i));
			}else if(f.get(i).equals("*")) {
				if(op.empty()==false) {
					if(op.peek().equals("*")||op.peek().equals("/")) {
						k=op.pop();
						fop.push(k);
						ap+=k;
					}
				}
				op.push(f.get(i));
			}else if(f.get(i).equals("(")) {
				op.push(f.get(i));
			}else if(f.get(i).equals(")")) {
				while(!op.peek().equals("(")) {
					k=op.pop();
					fop.push(k);
					ap+=k;
				}
				op.pop();
				k=op.pop();
				fop.push(k);
				ap+=k;
			}else {
				ap+=f.get(i);
				num.push(f.get(i));
			}
		}
		for(;!op.empty();) {
			k=op.pop();
			fop.push(k);
			ap+=k;
		}
		System.out.println(op);
		System.out.println(num);
		System.out.println(ap);
		System.out.println(fop);
		for(;!num.empty();) {
			fnum.push(num.pop());
		}
		System.out.println(fnum);
		for(;!fop.empty();) {
			op.push(fop.pop());
		}
		System.out.println(op);
		int sum=0;
		int cnt=0;
		for(int i=0; i<fop.size(); i++) {
			if(i==0) {
				sum=Integer.parseInt(fop.pop());
			}else {
				String q=op.pop();
				if(q.equals("+")) {
					sum+=Integer.parseInt(fop.pop());
				}else if(q.equals("-")) {
					sum-=Integer.parseInt(fop.pop());
				}else if(q.equals("/")) {
					sum/=Integer.parseInt(fop.pop());
				}else if(q.equals("*")) {
					sum*=Integer.parseInt(fop.pop());
				}
			}
		}
		System.out.println(sum);
	}

}
