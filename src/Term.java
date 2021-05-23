
public class Term {

	private double coefficient;
	private int degree;

	public Term(double coefficient, int degree){
		if(degree != 0) {
			this.coefficient = coefficient;
			this.degree = degree;
		}
		else{
			System.out.println("Terms of degree 0 are not allowed!, Term creation cancelled");
		}
	}
	
	public Term(Term t1, Term t2){
		if(t1.degree == t2.degree) {
			this.setDegree(t1.degree);
			this.setCoefficient(t1.getCoefficient() + t2.getCoefficient());
		}
	}

	public void add(Term t2){
		if(this.degree == t2.degree) {
			double coeff1 = this.getCoefficient();
			double coeff2 = t2.getCoefficient();
			double finalCoefficient = coeff1 + coeff2;
			this.setCoefficient(finalCoefficient);
		}
	}

	public double evaluate(double x){
		return coefficient * Math.pow(x, degree);
	}

	public void setCoefficient(double coefficient) {
		this.coefficient = coefficient;
	}

	public void setDegree(int degree) {
		this.degree = degree;
	}

	public double getCoefficient() {
		return coefficient;
	}

	public int getDegree() {
		return degree;
	}

	public int compareTo(Term other){
		if(this.degree > other.degree)
			return 1;
		else if(this.degree < other.degree)
			return -1;
		else
			return 0;
	}

	public void print(){
		System.out.print(toString());
	}
	
	public String toString(){
		if(degree == 1){
			if(coefficient == 1) {
				return String.format("+x ");
			}
			else if(coefficient == -1) {
				return String.format("-x ");
			}
			else{
				return String.format("%1$+3.2fx ",coefficient);
			}
		}
		else{
			if(coefficient == 1) {
				return String.format("+x^%1$d ", degree);
			}
			else if(coefficient == -1) {
				return String.format("-x^%1$d ", degree);
			}
			else{
				return String.format("%1$+3.2fx^%2$d ",coefficient,degree);
			}
		}
	}

	public boolean equals(Object o){
		Term t = (Term)o;
		if(t.degree == this.degree)
			return true;
		else
			return false;
	}

}
