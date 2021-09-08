package scheduling;

import java.util.*;

public class RRusingLL {
	String p;
	int at;
	int bt;

	public RRusingLL(String p, int at, int bt) {
		this.p = p;
		this.at = at;
		this.bt = bt;
	}

	public static void main(String[] args) {
		LinkedList<RRusingLL> list = new LinkedList<RRusingLL>();
		LinkedList<String> p = new LinkedList<String>();  // for id tracing
		LinkedList<Integer> c = new LinkedList<Integer>(); // track burst time

		Queue<String> q = new LinkedList<String>(); 

		list.add(new RRusingLL("p1", 0, 24));
		list.add(new RRusingLL("p2", 1, 3));
		list.add(new RRusingLL("p3", 2, 3));


		for(int i=0;i<list.size();i++) {
			p.add(list.get(i).p);
			c.add(list.get(i).bt);
			q.add(list.get(i).p);
		}

		int t=0, idx =-1, tq=4;

		System.out.println("ending time per process \t\n");
		while(!q.isEmpty()) {
			String v = q.remove();
			idx = p.indexOf(v);

			if(c.get(idx)>=tq) {
				c.set(idx, c.get(idx)-tq);

				if(c.get(idx)>0) {
					q.add(p.get(idx));
				}
				t+=tq;

			}
			else {
				t+=c.get(idx);
				c.set(idx,  c.get(idx)-c.get(idx));
			}
			System.out.println(t+" --> "+list.get(idx).p);
		}

	}


}
