package scheduling;

import java.util.LinkedList;
import java.util.*;

public class PriorityScheduling {
	public String p;
	public  int bt;
	public  int pr;
	public  int at;
	
	public PriorityScheduling(String s, int bt, int pr, int at) {
		p=s;
		this.bt=bt;
		this.pr=pr;
		this.at=at;
	}
	public static void main(String []args) {
		LinkedList<PriorityScheduling> list = new LinkedList<PriorityScheduling>();
		LinkedList<WaitingTime> out = new LinkedList<WaitingTime>();
		LinkedList<Integer> temp = new LinkedList<Integer>();
		PriorityQueue<Integer> pl = new PriorityQueue<Integer>();
		
		int end=0;
		
		list.add(new PriorityScheduling("p1", 10, 3, 0));
		list.add(new PriorityScheduling("p2", 1, 1, 0));
		list.add(new PriorityScheduling("p3", 2, 4, 0));
		list.add(new PriorityScheduling("p4", 1, 5, 0));
		list.add(new PriorityScheduling("p5", 5, 2, 0));
		
		//storing values in pl & temp 
		for(int i=0;i<list.size();i++) {
			pl.add(list.get(i).pr);
			temp.add(list.get(i).pr);
		}
		
		while (!(pl.isEmpty())) {
			int x = pl.poll();
			int idx = temp.indexOf(x);
			out.add(new WaitingTime(list.get(idx).p, end-list.get(idx).at));
			end+=list.get(idx).bt;
		}
		int sum =0;
		System.out.println("Process\t\t"+"Waiting time");
		for(int i=0;i<out.size();i++) { 
			System.out.println(out.get(i).pro+"\t\t"+out.get(i).wt);
			sum+=out.get(i).wt;
		}
		System.out.println("\nAverage waiting time: "+(float)sum/out.size());
	}
}
