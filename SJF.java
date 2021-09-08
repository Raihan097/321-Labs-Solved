package scheduling;

import java.util.LinkedList;

public class SJF /*SRTF*/ {
	String p;
	int at;
	int bt;

	public SJF(String p, int at, int bt) {
		this.p=p;
		this.at = at;
		this.bt = bt;
	}


	public static void main(String[] args) {
		LinkedList<SJF> list = new LinkedList<SJF>();
		LinkedList<Integer> c = new LinkedList<Integer>();

		list.add(new SJF("p1", 0, 8));
		list.add(new SJF("p2", 1, 4));
		list.add(new SJF("p3", 2, 9));
		list.add(new SJF("p4", 3, 5));

		int total = 26, tq=1, idx = -1, t=0;

		while(t<=total) {
			if(t<list.size()) {
				c.add(list.get(t).bt);
			}
			int min = Integer.MAX_VALUE;
			for(int i=0;i<c.size();i++) {
				if(min>c.get(i)) {
					min = c.get(i);
					idx = c.indexOf(min);
				}
			}

			System.out.println(t+" --> "+list.get(idx).p);

			if(c.get(idx)>1) {
				c.set(idx, c.get(idx)-tq);
			}
			else {
				c.set(idx,Integer.MAX_VALUE);
			}
			t+=tq;
		}

	}

}
