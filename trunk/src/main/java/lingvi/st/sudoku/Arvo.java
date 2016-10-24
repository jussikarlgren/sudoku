package lingvi.st.sudoku;

import java.util.Vector;

public enum Arvo {
YKSI,KAKSI,KOLME,NELJÄ,VIISI,KUUSI,SEITSEMÄN,KAHDEKSAN,YHDEKSÄN;
public static Arvo val(int v) {
	if (v == 1) return YKSI;
	if (v == 2) return KAKSI;
	if (v == 3) return KOLME;
	if (v == 4) return NELJÄ;
	if (v == 5) return VIISI;
	if (v == 6) return KUUSI;
	if (v == 7) return SEITSEMÄN;
	if (v == 8) return KAHDEKSAN;
	if (v == 9) return YHDEKSÄN;
	return null;
}
public static Vector<Arvo> alla() {
	Vector<Arvo> v = new Vector<Arvo>();
	for (Arvo a: Arvo.values()) {v.add(a);}
	return v;
}
public String toString() {
	return 	(this.ordinal()+1)+"";
}
}
