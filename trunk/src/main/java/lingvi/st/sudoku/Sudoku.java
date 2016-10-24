package lingvi.st.sudoku;

import java.util.Set;
import java.util.TreeSet;
import java.util.Vector;

public class Sudoku {
	static int DIMENSION = 9;

	Cell[][] matrix = new Cell[DIMENSION][DIMENSION];
	Row[] ruudut = new Row[DIMENSION];
	Row[] rows = new Row[DIMENSION];
	Row[] cols = new Row[DIMENSION];
	Vector<Cell> cells = new Vector<Cell>(DIMENSION*DIMENSION);

	public Sudoku() {
		Set<Arvo> arvoSet = new TreeSet<Arvo>(Arvo.alla());
		for (int i = 0; i < DIMENSION; i++) {
			ruudut[i] = new Row("Box "+i);
			rows[i] = new Row("Row "+i);
			cols[i] = new Row("Col "+i);
		}
		for (int i = 0; i < DIMENSION; i++) {
			for (int j = 0; j < DIMENSION; j++) {
				Cell c = new Cell();
				matrix[i][j] = c;
				c.x = i;
				c.y = j;
				c.line = rows[i];
				c.line.cells.add(c);
				c.col = cols[j];
				c.col.cells.add(c);
				c.ruutu = ruudut[mapit(i,j)];
				c.ruutu.cells.add(c);
				cells.add(c);
			}
		}
		for (int i = 0; i < DIMENSION; i++) {
			rows[i].initialise();
			cols[i].initialise();
			ruudut[i].initialise();
		}
	}
	private int mapit(int i, int j) {
		if (i < 3) {
			if (j < 3) return 0;
			if (j < 6) return 1;
			return 2;
		}
		if (i < 6) {
			if (j < 3) return 3;
			if (j < 6) return 4;
			return 5;
		}
		if (j < 3) return 6;
		if (j < 6) return 7;
		return 8;
	}
	public String toString() {
		String s = "";
		for (int i = 0; i < DIMENSION; i++) {
			for (int j = 0; j < DIMENSION; j++) {
				s += matrix[i][j];
				if (j == 2 || j == 5) s += " | ";
			}
			s += "\n";
			if (i == 2 || i == 5) s += "\n";
		}
		return s;
	}
	private void accept(String input) {
		int i = 0;
		int j = 0;
		String[] chars = input.split("");
		for (String in:chars) {
			if (in.equals(" ")) {continue;}
			try {
			int val = Integer.parseInt(in);
			if (val >= 1 && val <= DIMENSION) {
				matrix[i][j].set(Arvo.val(val));
			}
			} catch (NumberFormatException e) {
				// nop
			}
			j++; if (j >= DIMENSION) {j = 0; i++;}
			if (i > DIMENSION) {System.err.println("Warning: input string longer than "+DIMENSION*DIMENSION+" at <"+i+","+j+">:"+in);break;}
		}
	}
	public static void main(String[] args) {
		Sudoku s = new Sudoku();
		System.out.println(s);
		s.accept(
				  ".2. .8. .7.   "
				+ "4.. ... ..6   "
				+ "... 941 ...   "
				+ "..1 .6. 8..   "
				+ "5.2 4.8 3.7   "
				+ "..3 .7. 9..   "
				+ "... 756 ...   "
				+ "2.. ... ..1   "
				+ ".6. .3. .4."
				);
//				  "3.7 618 ..2   "
//				+ "... ... 3..   "
//				+ "2.. .3. .68   "
//				+ "... ..7 ...   "
//				+ "..1 ... ...   "
//				+ "... 9.. 4..   "
//				+ "7.3 .6. 2..   "
//				+ "..8 2.1 .9.   "
//				+ "1.. .9. ...");
		System.out.println("-----");
		System.out.println(s);
		System.out.println("-----");
		for (Row r : s.rows )	r.settle();
		for (Row r : s.cols )	r.settle();
		for (Row r : s.ruudut )	r.settle();
		System.out.println(s);
		System.out.println("-----\nCells");
		for (Cell c: s.cells) c.consolidate();
		System.out.println(s);
		System.out.println("-----");
		for (Row r : s.rows )	r.settle();
		for (Row r : s.cols )	r.settle();
		for (Row r : s.ruudut )	r.settle();
		System.out.println(s);
		System.out.println("-----\nCells");
		for (Cell c: s.cells) c.consolidate();
		System.out.println(s);
		System.out.println("-----");
		for (Row r : s.rows )	r.settle();
		for (Row r : s.cols )	r.settle();
		for (Row r : s.ruudut )	r.settle();
		System.out.println(s);
		System.out.println("-----\nCells");
		for (Cell c: s.cells) c.consolidate();
		System.out.println(s);
		System.out.println("-----");
		for (Row r : s.rows )	r.settle();
		for (Row r : s.cols )	r.settle();
		for (Row r : s.ruudut )	r.settle();
		System.out.println(s);
		System.out.println("-----\nCells");
		for (Cell c: s.cells) c.consolidate();
		System.out.println(s);
		System.out.println("-----");
		for (Row r : s.rows )	r.settle();
		for (Row r : s.cols )	r.settle();
		for (Row r : s.ruudut )	r.settle();
		System.out.println(s);
		System.out.println("-----\nCells");
		for (Cell c: s.cells) c.consolidate();
		System.out.println(s);
		System.out.println("-----");
		for (Row r : s.rows )	r.settle();
		for (Row r : s.cols )	r.settle();
		for (Row r : s.ruudut )	r.settle();
		System.out.println(s);
		System.out.println("-----\nCells");
		for (Cell c: s.cells) c.consolidate();
		System.out.println(s);
		System.out.println("-----");
		for (Row r : s.rows )	r.settle();
		for (Row r : s.cols )	r.settle();
		for (Row r : s.ruudut )	r.settle();
		System.out.println(s);
		System.out.println("-----\nCells");
		for (Cell c: s.cells) c.consolidate();
		System.out.println(s);
		System.out.println("-----");
		for (Row r : s.rows )	r.settle();
		for (Row r : s.cols )	r.settle();
		for (Row r : s.ruudut )	r.settle();
		System.out.println(s);
		System.out.println("-----\nCells");
		for (Cell c: s.cells) c.consolidate();
		System.out.println(s);
		System.out.println("-----");
		for (Row r : s.rows )	r.settle();
		for (Row r : s.cols )	r.settle();
		for (Row r : s.ruudut )	r.settle();
		System.out.println(s);
		System.out.println("-----\nCells");
		for (Cell c: s.cells) c.consolidate();
		System.out.println(s);
		System.out.println("-----");
		for (Row r : s.rows )	r.settle();
		for (Row r : s.cols )	r.settle();
		for (Row r : s.ruudut )	r.settle();
		System.out.println(s);
		System.out.println("-----\nCells");
		for (Cell c: s.cells) c.consolidate();
		System.out.println(s);
		System.out.println("-----");
		for (Row r : s.rows )	r.settle();
		for (Row r : s.cols )	r.settle();
		for (Row r : s.ruudut )	r.settle();
		System.out.println(s);
		System.out.println("-----\nCells");
		for (Cell c: s.cells) c.consolidate();
		System.out.println(s);
		System.out.println("-----");
		for (Row r : s.rows )	r.settle();
		for (Row r : s.cols )	r.settle();
		for (Row r : s.ruudut )	r.settle();
		System.out.println(s);
		System.out.println("-----\nCells");
		for (Cell c: s.cells) c.consolidate();
		System.out.println(s);


	}
}

//
//
//s.matrix[0][0].set(Arvo.KOLME);
////		s.matrix[0][1].set(Arvo.YKSI);
//s.matrix[0][2].set(Arvo.SEITSEMÄN);
//s.matrix[0][3].set(Arvo.KUUSI);
//s.matrix[0][4].set(Arvo.YKSI);
//s.matrix[0][5].set(Arvo.KAHDEKSAN);
////		s.matrix[0][6].set(Arvo.YKSI);
////		s.matrix[0][7].set(Arvo.YKSI);
//s.matrix[0][8].set(Arvo.KAKSI);
////		s.matrix[1][0].set(Arvo.YKSI);
////		s.matrix[1][1].set(Arvo.YKSI);
////		s.matrix[1][2].set(Arvo.YKSI);
////		s.matrix[1][3].set(Arvo.YKSI);
////		s.matrix[1][4].set(Arvo.YKSI);
////		s.matrix[1][5].set(Arvo.YKSI);
//s.matrix[1][6].set(Arvo.KOLME);
////		s.matrix[1][7].set(Arvo.YKSI);
////		s.matrix[1][8].set(Arvo.YKSI);

//s.matrix[2][0].set(Arvo.KAKSI);
////		s.matrix[2][1].set(Arvo.YKSI);
////		s.matrix[2][2].set(Arvo.YKSI);
////		s.matrix[2][3].set(Arvo.YKSI);
//s.matrix[2][4].set(Arvo.KOLME);
////		s.matrix[2][5].set(Arvo.YKSI);
////		s.matrix[2][6].set(Arvo.KOLME);
//s.matrix[2][7].set(Arvo.KUUSI);
//s.matrix[2][8].set(Arvo.KAHDEKSAN);
////		s.matrix[3][0].set(Arvo.YKSI);
////		s.matrix[3][1].set(Arvo.YKSI);
////		s.matrix[3][2].set(Arvo.YKSI);
////		s.matrix[3][3].set(Arvo.YKSI);
////		s.matrix[3][4].set(Arvo.YKSI);
//s.matrix[3][5].set(Arvo.SEITSEMÄN);
////		s.matrix[3][6].set(Arvo.YKSI);
////		s.matrix[3][7].set(Arvo.YKSI);
////		s.matrix[3][8].set(Arvo.YKSI);

////		s.matrix[4][0].set(Arvo.YKSI);
////		s.matrix[4][1].set(Arvo.YKSI);
//s.matrix[4][2].set(Arvo.YKSI);
////		s.matrix[4][3].set(Arvo.YKSI);
////		s.matrix[4][4].set(Arvo.YKSI);
////		s.matrix[4][5].set(Arvo.YKSI);
////		s.matrix[4][6].set(Arvo.YKSI);
////		s.matrix[4][7].set(Arvo.YKSI);
////		s.matrix[4][8].set(Arvo.YKSI);
////		s.matrix[5][0].set(Arvo.YKSI);
////		s.matrix[5][1].set(Arvo.YKSI);
////		s.matrix[5][2].set(Arvo.YKSI);
//s.matrix[5][3].set(Arvo.YHDEKSÄN);
////		s.matrix[5][4].set(Arvo.YKSI);
////		s.matrix[5][5].set(Arvo.YKSI);
//s.matrix[5][6].set(Arvo.NELJÄ);
////		s.matrix[5][7].set(Arvo.YKSI);
////		s.matrix[5][8].set(Arvo.YKSI);


//s.matrix[6][0].set(Arvo.SEITSEMÄN);
////		s.matrix[6][1].set(Arvo.YKSI);
//s.matrix[6][2].set(Arvo.KOLME);
////		s.matrix[6][3].set(Arvo.YKSI);
//s.matrix[6][4].set(Arvo.KUUSI);
////		s.matrix[6][5].set(Arvo.YKSI);
//s.matrix[6][6].set(Arvo.KAKSI);
////		s.matrix[6][7].set(Arvo.YKSI);
////		s.matrix[6][8].set(Arvo.YKSI);
////		s.matrix[7][0].set(Arvo.YKSI);
////		s.matrix[7][1].set(Arvo.YKSI);
//s.matrix[7][2].set(Arvo.KAHDEKSAN);
//s.matrix[7][3].set(Arvo.KAKSI);
////		s.matrix[7][4].set(Arvo.YKSI);
//s.matrix[7][5].set(Arvo.YKSI);
////		s.matrix[7][6].set(Arvo.YKSI);
//s.matrix[7][7].set(Arvo.YHDEKSÄN);
////		s.matrix[7][8].set(Arvo.YKSI);


//s.matrix[8][0].set(Arvo.YKSI);
////		s.matrix[8][1].set(Arvo.YKSI);
////		s.matrix[8][2].set(Arvo.YKSI);
////		s.matrix[8][3].set(Arvo.YKSI);
//s.matrix[8][4].set(Arvo.YHDEKSÄN);
////		s.matrix[8][5].set(Arvo.YKSI);
////		s.matrix[8][6].set(Arvo.YKSI);
////		s.matrix[8][7].set(Arvo.YKSI);
////		s.matrix[8][8].set(Arvo.YKSI);

