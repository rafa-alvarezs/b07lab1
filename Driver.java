public class Driver {
	public static void main(String [] args) {
		Polynomial p = new Polynomial();
		System.out.println(p.evaluate(3));
		double [] c1 = {6,2,0,5};
		int [] exp1 = {1,4,0,2};
		Polynomial p1 = new Polynomial(c1, exp1);
		double [] c2 = {0,-2,0,0,-9};
		int [] exp2 = {1, 3, 0, 5, 2};
		Polynomial p2 = new Polynomial(c2, exp2);
		Polynomial s = p1.add(p2);
		System.out.println("s(0.0) = " + s.evaluate(0.0));
		if(s.hasRoot(0))
		System.out.println("0 is a root of s");
		else
		System.out.println("0 is not a root of s");
	}
}	
