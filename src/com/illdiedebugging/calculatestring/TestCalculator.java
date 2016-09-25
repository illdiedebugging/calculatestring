package com.illdiedebugging.calculatestring;

public class TestCalculator {
	public static void main(String args[]){
		String str = null;
		try{
		str = Calculator.getResult("1-((100/5+4*2)+5)*3*(100)-(10*10^2)");
		}catch(UnableToCalculateException e) {
			System.out.println(e);
		}
		
		System.out.println(str); //Result must be -10899
	}
}
