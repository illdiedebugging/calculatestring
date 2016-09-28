package com.illdiedebugging.calculatestring;

public class TestCalculation {
	public static void main(String args[]){
		String str = null;
		try{
		str = Calculate.getResult("1-((100.5443/5+4.12333*2)+5)*√3(-100)-(10*10^2)"); //Result must be -6714.767664977295
		//str = Calculate.getResult("(3.345+4.567)(2+5)"); //Result must be 55.38400000000001
		}catch(UnableToCalculateException e) {
			System.out.println(e);
		}
		System.out.println(str); 
	}
}
