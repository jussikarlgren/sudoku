package lingvi.st.sudoku;

import java.util.Set;
import java.util.TreeSet;

public class Cell {

	int x;
	int y;
	Row line;
	Row col;
	Row ruutu;
	Arvo a;
	Set<Arvo> possibles;

	public Cell() {
		possibles = new TreeSet<Arvo>(); 
		possibles.addAll(Arvo.alla());
		a = null;
	}
	public void set(Arvo a1) {
		this.a = a1;
		possibles.clear();
		possibles.add(a1);
	}
	public void consolidate() {
		indicate(col.request(this));
		indicate(line.request(this));
		indicate(ruutu.request(this));
		if (possibles.size() == 1) {set((Arvo) possibles.toArray()[0]);}
	}
	private void indicate(Set<Arvo> tilaus) {
		Set<Arvo> np = new TreeSet<Arvo>(); 
		for (Arvo aa: possibles) {
			if (tilaus.contains(aa)) {np.add(aa);} 
		}
		possibles = np;
	}
	public String xy() {
		return "<"+x+";"+y+"> ";
	}
	public String toString() {
		String p = "";
		if (a != null) { p += "   ["+(a.ordinal()+1)+"]   ";} 
		else 
		for (Arvo i: Arvo.alla()) {
			if (possibles.contains(i)) {p += i;} else {p += ".";}
		}
		return p; 
	}
}
