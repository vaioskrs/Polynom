
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Term t4 = new Term(2,4);
		Term t3 = new Term(-3,3);
		Term t2 = new Term(-6,2);
		
		Polynom P = new Polynom("P",+2);
		P.addTerm(t4);
		P.addTerm(t3);
		P.addTerm(t2);
		
		P.print();

		Term q4 = new Term(-4,4);
		Term q3 = new Term(2,3);
		Term q2 = new Term(6,2);
		Term q1 = new Term(1,1);

		Polynom Q = new Polynom("Q",+1);
		Q.addTerm(q4);
		Q.addTerm(q3);
		Q.addTerm(q2);
		Q.addTerm(q1);
		Q.print();
		
		Polynom PplusQ = P.add(Q);
		PplusQ.print();

		P.printValue(10);
		Q.printValue(10);
		PplusQ.printValue(-10);
		
	}

}
