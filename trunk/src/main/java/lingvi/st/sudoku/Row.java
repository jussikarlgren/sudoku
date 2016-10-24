package lingvi.st.sudoku;

import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;
import java.util.Vector;

public class Row {

	private HashMap<Arvo,Vector<Cell>> assignments;
	Vector<Cell> cells;
	String name;

	public Row(String name) {
		this.name = name;
		cells = new Vector<Cell>(Sudoku.DIMENSION);
		assignments = new HashMap<Arvo,Vector<Cell>>(Arvo.values().length);
		for (Arvo a: Arvo.alla()) {
			Vector<Cell> cs = new Vector<Cell>();
			fix(a, cs);
		}
	}
	public void initialise() {
		for (Arvo a: assignments.keySet()) {
			Vector<Cell> cs = new Vector<Cell>();
			for (Cell c: cells) {
				cs.add(c);
			}
			fix(a, cs);			
		}
	}
	private void fix(Arvo a, Vector<Cell> cs) {
		assignments.put(a, cs);
	}

	public Set<Arvo> request(Cell cell) {
		Set<Arvo> p = new TreeSet<Arvo>();
		for (Arvo a: assignments.keySet()) {
			if (assignments.get(a).contains(cell)) {
				p.add(a);
			}
		}
		return p;
	}

	public void settle() {
		for (Arvo a: assignments.keySet()) {
			Vector<Cell> ns = new Vector<Cell>();
			for (Cell c: assignments.get(a)) {
				if (c.possibles.contains(a)) {
					ns.add(c);
				}
			}
			fix(a,ns);
		}	
		for (int k = 1; k < Sudoku.DIMENSION; k++) {
			for (Cell c1: cells) {
				Set<Arvo> p1 = c1.possibles; 
				if (p1.size() == k) {
					Vector<Cell> nc = new Vector<Cell>();
					nc.add(c1);
					for (Cell c2: cells) {
						if ((! c2.equals(c1)) && p1.equals(c2.possibles)) {
							nc.add(c2);
						}
					}
					if (nc.size() == k) {
							block(nc,p1); 
					}
				}
			}
		}

	}
	private void block(Vector<Cell> cs, Set<Arvo> as) {
		for (Arvo a: as) {fix(a,cs);} 
		for (Arvo a: assignments.keySet()) { 
			if (as.contains(a)) continue;
			else {
				Vector<Cell> vs = assignments.get(a);
				Vector<Cell> ns = new Vector<Cell>();
				for (Cell c: vs) {
					if (! cs.contains(c)) ns.add(c);
				} 
				fix(a, ns);
			}
		}
	}
	public String toString() {
		String p = "";
		for (Arvo a : Arvo.alla()) {
			p += a+"\t"+assignments.get(a)+"\n";
		}
		for (Cell c: cells) {
			p += " "+c.xy()+":{"+c+"}";
		}
		return p;
	}
}
