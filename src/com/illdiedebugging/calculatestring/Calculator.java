package com.illdiedebugging.calculatestring;
import java.util.Arrays;

public class Calculator {
	
	public static String getResult(String input) throws UnableToCalculateException {
		
		String[] sp = input.split("(?<=[+-//*/^()])|(?=[+-//*/^()])");
		checkInput(sp);
		
		sp = concat(new String[] { "(" }, sp, new String[] { ")" });

		
		
		int currentlevel = 0, maxlevel = 0;

		for (int i = 0; i < sp.length; i++)
		{
			if (sp[i].equals("(")) {
				currentlevel++;
				maxlevel = (currentlevel > maxlevel) ? currentlevel : maxlevel;
			} else if (sp[i].equals(")")) {
				currentlevel--;
			}
		}
		
		String[] p;
		int startOfp = 0, endOfp = 0;

		for (int j = maxlevel; j >= 1; j--) {
			while (!finishedLevel(j, sp)) {
				currentlevel = 0;
				for (int i = 0; i < sp.length; i++) {

					if (sp[i].equals("(")) {
						currentlevel++;
					} else if (sp[i].equals(")")) {
						currentlevel--;
					}

					if (currentlevel == j) {
						if (sp[i].equals("(")) {
							startOfp = i;
						}
					} else if (currentlevel == j - 1 && sp[i].equals(")")) {
						endOfp = i;
						p = Arrays.copyOfRange(sp, startOfp, endOfp + 1);
						sp = concat(Arrays.copyOfRange(sp, 0, startOfp), calculate(p),
								Arrays.copyOfRange(sp, endOfp + 1, sp.length));
						break;
					}
				}
			}
		}
		return transformResult(sp);
	}

	private static String[] calculate(String[] p) 
	{
		double result = 0;
		p = Arrays.copyOfRange(p, 1, p.length - 1);
		if (p.length == 1){return p;}

		while (!finishedOperatorsCalculation(p, new String[] { "^" })) {
			for (int i = 0; i < p.length; i++) {
				if (p[i].equals("^")) {
					result = Math.pow(Double.parseDouble(p[i - 1]), Double.parseDouble(p[i + 1])); // Math.pow(x,y))

					if (i == 1) {
						p = concat(new String[] { String.valueOf(result) }, Arrays.copyOfRange(p, i + 2, p.length),
								new String[] {});
					} else if (i == p.length - 2) {
						p = concat(Arrays.copyOfRange(p, 0, i - 1), new String[] { String.valueOf(result) },
								new String[] {});
					} else {
						p = concat(Arrays.copyOfRange(p, 0, i - 1), new String[] { String.valueOf(result) },
								Arrays.copyOfRange(p, i + 2, p.length));
					}
					break;
				}
			}
		}

		while (!finishedOperatorsCalculation(p, new String[] { "*", "/" })) {
			for (int i = 0; i < p.length; i++) {
				if (p[i].equals("*") || p[i].equals("/")) {
					if (p[i].equals("*")) {
						result = Double.parseDouble(p[i - 1]) * Double.parseDouble(p[i + 1]);
					} else if (p[i].equals("/")) {
						result = Double.parseDouble(p[i - 1]) / Double.parseDouble(p[i + 1]);
					}

					if (i == 1) {
						p = concat(new String[] { String.valueOf(result) }, Arrays.copyOfRange(p, i + 2, p.length),
								new String[] {});
					} else if (i == p.length - 2) {
						p = concat(Arrays.copyOfRange(p, 0, i - 1), new String[] { String.valueOf(result) },
								new String[] {});
					} else {
						p = concat(Arrays.copyOfRange(p, 0, i - 1), new String[] { String.valueOf(result) },
								Arrays.copyOfRange(p, i + 2, p.length));
					}
					break;
				}
			}
		}

		while (!finishedOperatorsCalculation(p, new String[] { "+", "-" })) {
			for (int i = 0; i < p.length; i++) {
				if (p[i].equals("+") || p[i].equals("-")) {
					if (p[i].equals("+")) {
						result = Double.parseDouble(p[i - 1]) + Double.parseDouble(p[i + 1]);

					} else if (p[i].equals("-")) {
						result = Double.parseDouble(p[i - 1]) - Double.parseDouble(p[i + 1]);
					}

					if (i == 1) {
						p = concat(new String[] { String.valueOf(result) }, Arrays.copyOfRange(p, i + 2, p.length),
								new String[] {});
					} else if (i == p.length - 2) {
						p = concat(Arrays.copyOfRange(p, 0, i - 1), new String[] { String.valueOf(result) },
								new String[] {});
					} else {
						p = concat(Arrays.copyOfRange(p, 0, i - 1), new String[] { String.valueOf(result) },
								Arrays.copyOfRange(p, i + 2, p.length));
					}

					break;
				}
			}
		}
		return p;
	}

	private static boolean finishedLevel(int j, String[] sp) {
		int c = 0, maxc = 0;
		for (int i = 0; i < sp.length; i++)
		{
			if (sp[i].equals("(")) {
				c++;
				maxc = (c > maxc) ? c : maxc;
			} else if (sp[i].equals(")")) {
				c--;
			}
		}
		if (maxc >= j) {
			return false;
		}
		return true;
	}

	private static boolean finishedOperatorsCalculation(String[] s, String[] symbols) {
		for (int i = 0; i < s.length; i++) {
			for (int j = 0; j < symbols.length; j++) {
				if (s[i].equals(symbols[j])) {
					return false;
				}
			}
		}
		return true;
	}

	private static String[] concat(String[] a, String[] b, String[] c) {
		String[] d = new String[a.length + b.length + c.length];
		for (int i = 0; i < a.length; i++) {
			d[i] = a[i];
		}
		for (int i = 0; i < b.length; i++) {
			d[a.length + i] = b[i];
		}
		for (int i = 0; i < c.length; i++) {
			d[a.length + b.length + i] = c[i];
		}
		return d;
	}

	private static void checkInput(String s[]) throws UnableToCalculateException {
		
		int op = 0, cp = 0, cn = 0;

		for (int i = 0; i < s.length; i++) {
			if (s[i].equals("(")) {
				op++;
				cn = 0;
			}else if (s[i].equals(")")) {
				cp++;
				cn = 0;
			}else if (	s[i].equals("^") ||
						s[i].equals("*") ||
						s[i].equals("/") ||
						s[i].equals("+") ||
						s[i].equals("-") ){
				cn = 0;
			}else if (!isNumeric(s[i])) {
				throw new UnableToCalculateException("Mistyped spelling on expression.");
			}else {
				cn++;
				if (cn >= 2) {throw new UnableToCalculateException("Mistyped spelling on expression.");}
			}
		}
		if(op != cp){ throw new UnableToCalculateException("Missing parenthesis on expression");}
		
	}
	
	private static boolean isNumeric(String s)  
	{  
	  try  
	  {  
		  Double.parseDouble(s);
	  }  
	  catch(NumberFormatException e)  
	  {  
		  return false;  
	  }  
	  return true;  
	}
	
	public static String transformResult(String[] s){
		StringBuilder sb = new StringBuilder();
		
		for (int i=0; i<s.length; i++) {
			sb.append(s[i]);
		}
		return sb.toString();
	}
}
