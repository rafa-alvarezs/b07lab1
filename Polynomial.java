import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Polynomial {
	double[] Coefficients;
	int[] Exponents; 
	
	public Polynomial() {
		Coefficients = new double[1];
		Exponents = new int[1];
	}
	
	public Polynomial(double[] arr, int[] exp) {
		Coefficients = arr;
		Exponents = exp;
	}
	
//	public Polynomial(File file) {
//		BufferedReader input = new BufferedReader(new FileReader(file));
//        String eq = input.readLine();
//		input.close();

//		String[] terms = eq.split("+-");
		
//		Coefficients = new double[terms.length];
//		Exponents = new int[terms.length];
		
//		for (int i=0; i<terms.length;i++) {
//			if(terms[i].contains("x")) {
//				String[] term = terms[i].split("x");
//				if (term.length==2) {
//					Coefficients[i] = Double.parseDouble(term[0]);
//					Exponents[i] = Integer.parseInt(term[1]);
//				}
//				else if (terms[i].charAt(0) == 'x') {
//					Coefficients[i] = 1;
//					Exponents[i] = Integer.parseInt(term[0]);
//				}
//				else if (terms[i].charAt(1) == 'x') {
//					Coefficients[i]=Double.parseDouble(term[0]);
//					Exponents[i]= 1;
//				}
//				else {
//					Coefficients[i] = 1;
//					Exponents[i]=1;
//				}
//			}
//			else {
//				Coefficients[i] = Double.parseDouble(terms[i]);
//				Exponents[i]= 0;
//			}
//		}
//		
//	}
	

	
	
	public Polynomial add(Polynomial p) {
		
		int total = p.Coefficients.length + this.Coefficients.length;
		Polynomial decoy = new Polynomial();
		Polynomial result = new Polynomial();

		decoy.Coefficients = new double[total];
		decoy.Exponents = new int[total];
		
		int index =0;

		for (int i=0; i< this.Coefficients.length;i++) {
			boolean found = false;
			
			for (int j=0; j< p.Coefficients.length;j++) {
				if (this.Exponents[i] == p.Exponents[j]) {
					decoy.Coefficients[index]= this.Coefficients[i] + p.Coefficients[j];
					decoy.Exponents[index]= this.Exponents[i];
					found = true;
					index ++;
					break;
				}
			}
			
			if (!found) {
				decoy.Coefficients[index] = this.Coefficients[index];
				decoy.Exponents[index]=this.Exponents[index];
				index ++;
			}
		}
		
		for (int m=0; m<p.Coefficients.length;m++) {
			boolean found2= false;
			
			for (int n=0; n<this.Coefficients.length;n++) {
				if (p.Exponents[m]==this.Exponents[n]) {
					found2 = true;
					break;
				}
				
			}
			
			if (!found2) {
				decoy.Coefficients[index] = p.Coefficients[m];
				decoy.Exponents[index]=p.Exponents[m];
				index ++;
			}	
		}
		
		result.Exponents = new int[index];
		result.Coefficients = new  double[index];
		
		for (int t=0; t<index;t++) {
			result.Coefficients[t]=decoy.Coefficients[t];
			result.Exponents[t]=decoy.Exponents[t];
		}
		
		return result;
			
	}

	public double evaluate(double d) {
		double result=0;
		for (int i=0; i< Coefficients.length;i++) {
			result = result + (Coefficients[i] * Math.pow(d,this.Exponents[i]));
		}
		return result;
	}

	public boolean hasRoot(double d) {
		double result = evaluate(d);
		return result == 0;
	}
	
	
	public Polynomial multiply(Polynomial p1) {
		int len = this.Exponents.length * p1.Exponents.length;
		Polynomial decoy = new Polynomial();
		decoy.Exponents= new int[len];
		decoy.Coefficients= new double[len];
		int index = 0;
		for(int i=0; i<this.Coefficients.length; i++) {
			for (int j=0; j< p1.Coefficients.length;j++) {

				decoy.Coefficients[index]=this.Coefficients[i] * p1.Coefficients[j];
				decoy.Exponents[index] = this.Exponents[i] + p1.Exponents[j];
				index ++;
			}
		}
		
		int count = 0;
		for(int j=0; j<len;j++) {
			for(int m=j; m<len;m++) {
				if (decoy.Exponents[j]==decoy.Exponents[m] & decoy.Coefficients[m] != 0) {
					decoy.Coefficients[j] += decoy.Coefficients[m];
					decoy.Coefficients[m]=0;
					count++;
				}
			}
			
		}
		
		Polynomial result = new Polynomial();
		result.Exponents = new int[len-count];
		result.Coefficients = new double[len-count];
		int ind=0;
		for(int i=0;i<len;i++) {
			if (decoy.Coefficients[i] != 0) {
				result.Coefficients[ind] = decoy.Coefficients[i];
				result.Exponents[ind] = decoy.Exponents[i];
				ind++;
			}
		}
		
		return result;
		
	}
}								