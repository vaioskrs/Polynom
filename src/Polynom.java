import java.text.DecimalFormat;
import java.util.ArrayList;

public class Polynom {
	
	private ArrayList<Term> terms;
	private String name;
	private double constantTerm;
	
	public Polynom(String name, double constantTerm){
		terms = new ArrayList<Term>();
		this.name = name;
		this.constantTerm = constantTerm;
	}
	
	public int getDegree(){
		int maxDegree = 0;
		for(Term t : terms){
			if(t.getDegree() > maxDegree){
				maxDegree = t.getDegree();
			}
		}
		return maxDegree;
	}
	
	public void addTerm(Term t){
		if(!terms.contains(t) && t.getCoefficient() != 0){
			terms.add(t);
		}
		else{
			int degree = t.getDegree();
			Term theTermWithEqualDegree = getTermOfDegree(degree);
			theTermWithEqualDegree.add(t);
			if(t.getCoefficient() == 0)
				terms.remove(theTermWithEqualDegree);			
		}	
	}
	
	public Polynom add(Polynom Q){
		double constant = this.constantTerm + Q.constantTerm;
		Polynom PplusQ = new Polynom(this.name+"+"+Q.name,constant);
		Polynom maxDegreePolynom = this;
		Polynom otherPolynom = Q;
		if(Q.getDegree() > this.getDegree()){
			maxDegreePolynom = Q;
			otherPolynom = this;
		}
		int maxDegree = maxDegreePolynom.getDegree();
		for(int i=maxDegree; i>0; i--){
			Term t1 = otherPolynom.getTermOfDegree(i);
			Term t2 = this.getTermOfDegree(i);
			PplusQ.addTerm(new Term(t1,t2));
		}
		return PplusQ;
	}
	
	public double evaluate(double x){
		double value = 0;
		for(Term t : terms) value += t.evaluate(x);
		return value + constantTerm;
	}
	
	public void printValue(double x){
		double value = evaluate(x);
		DecimalFormat dc = new DecimalFormat("#.##");
		System.out.println(name+"("+x+") = "+dc.format(value));
	}
	
	public void print(){
		System.out.print(name+"(x) = ");
		for(Term t : terms){
			t.print();
		}
		if(constantTerm > 0)
			System.out.println("+"+constantTerm);
		else
			System.out.println(constantTerm);
	}
	
	public String toString(){
		String res = name+"(x) = ";
		for(Term t : terms)
			res += t;
		return res;
	}
	
	public Term getTermOfDegree(int degree){
		for(Term term : terms){
			if(term.getDegree() == degree){
				return term;
			}
		}
		return new Term(0,1);
	}

	public double getConstantTerm() {
		return constantTerm;
	}

	public void setConstantTerm(double constantTerm) {
		this.constantTerm = constantTerm;
	}

}
