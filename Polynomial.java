public class Polynomial {
	double[] Coefficients;
	
	public Polynomial() {
		Coefficients = new double[1];
	}
	
	public Polynomial(double[] arr) {
		Coefficients = arr;
	}
	
	public Polynomial add(Polynomial p) {
		Polynomial result = new Polynomial();
		Polynomial bigger = new Polynomial();

		if (Coefficients.length <= p.Coefficients.length) {
			bigger = p;
		}
		else {
			bigger = this;
		}

		result.Coefficients = new double[bigger.Coefficients.length];

		for (int i=0; i< bigger.Coefficients.length;i++) {
			if (i< Math.min(Coefficients.length, p.Coefficients.length)) {
				result.Coefficients[i] = Coefficients[i] + p.Coefficients[i];
			}
			else {
				result.Coefficients[i] = bigger.Coefficients[i];
			}
		}
		return result;
			
	}

	public double evaluate(double d) {
		double result=0;
		for (int i=0; i< Coefficients.length;i++) {
			result = result + (Coefficients[i] * Math.pow(d,i));
		}
		return result;
	}

	public boolean hasRoot(double d) {
		double result = evaluate(d);
		return result == 0;
	}
	
}	