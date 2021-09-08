package scheduling;

import java.util.LinkedList;

public class FCFSusingLList {
	public String p;
	public int bt, at;

	public FCFSusingLList(String s, int bt, int at) {
		this.p=s;
		this.bt=bt;
		this.at=at;
	}

	public static void main(String []args) {
		LinkedList<FCFSusingLList> list = new LinkedList<FCFSusingLList>();
		LinkedList<WaitingTime> out = new LinkedList<WaitingTime>();

		list.add(new FCFSusingLList("p1",24,0));
		list.add(new FCFSusingLList("p2",3,1));
		list.add(new FCFSusingLList("p3",3,2));

		int end=0, sum=0;

		System.out.println("Process\t\t"+"Waiting time");
		for(int i=0;i<list.size();i++) {
			out.add(new WaitingTime(list.get(i).p, end-list.get(i).at));
			end+=list.get(i).bt;
		}
		for(int i=0;i<out.size();i++) { 
			System.out.println(out.get(i).pro+"\t\t"+out.get(i).wt);
			sum+=out.get(i).wt;
		}
		System.out.println("\nAverage waiting time: "+(float)sum/out.size());
	}
}
