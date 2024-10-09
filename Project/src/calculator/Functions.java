package calculator;

import java.util.ArrayList;

public class Functions {
	public static long factorial(double firstValue) {
		if(firstValue < 0) {
			 throw new IllegalArgumentException("Input must be a non-negative integer.");
		}
		long Answer;
		if(firstValue == 0 || firstValue == 1) {
			Answer = 1;
		} else {
			Answer = 1;
			for (int i = 2; i <= firstValue; i++) {
				Answer *= i; 
			}
		}
		return Answer;
	}
	
	public static long sumFactorial(double firstValue, double secondValue) {
		return Functions.factorial(firstValue) + Functions.factorial(secondValue);
	}
	
	public static long divideFactorial(double firstValue, double secondValue) {
		return Functions.factorial(firstValue) / Functions.factorial(secondValue);
	}
	
	public static long summation(String equation, double firstValue, double secondValue, double thirdValue) {
		long start = (long) firstValue;
		long end = (long) secondValue;
		long constant = (long) thirdValue;
		long sum = 0;
		
		switch(equation) {
			case "Cx":
				for (long n = start; n <= end; n++) {
					sum += constant * n;
				}
				break;
				
			case "x+C":
				for (long n = start; n <= end; n++) {
					sum += n + constant;
				}
				break;
				
			case "x^C":
				for (long n = start; n <= end; n++) {
					sum += Math.pow(n, constant);
				}
				break;
			
			default:
				if (constant == 0 || constant == 1) {
					for (long n = start; n <= end; n++) {
						sum += n;
					}
				} else {
					for (long n = start; n <= end; n++) {
						sum +=constant;
		        	}
				}
		}
		return sum;
	}
	
	public static long doubleSummation(int nValue, String equation, double firstValue, double secondValue, double thirdValue, double fourthValue) {
		long start = (long) firstValue;
		long end = (long) secondValue;
		long jstart = (long) thirdValue;
		long jend = (long) fourthValue;
		long sum = 0;
			
		nValue = (nValue == 0) ? 1 : nValue;
		
		for(long n = start; n <= end; n++) {
			for(long j = jstart; j <= jend; j++) {
				switch (equation) {
					case "xy":
						sum += (nValue * n * j);
						break;
					case "x+y":
						sum += (nValue * n + j);
						break;
					case "x^y":
						sum += (nValue * Math.pow(n, j));
						break;
					default:
						sum += n * j;
				 }
			}
		}
		return sum;
	}
	
	public static long prodnot(String equation, double firstValue, double secondValue, double thirdValue) {
		long start = (long) firstValue;
		long end = (long) secondValue;
		long constant = (long) thirdValue;
		long sum = 1;
		
		switch(equation) {
			case "Cx":
				for (long n = start; n <= end; n++) {
					sum *= constant * n;
				}
				break;
				
			case "x+C":
				for (long n = start; n <= end; n++) {
					sum *= n + constant;
				}
				break;
				
			case "x^C":
				for (long n = start; n <= end; n++) {
					sum *= Math.pow(n, constant);
				}
				break;
			
			default:
				if (constant == 0 || constant == 1) {
					for (long n = start; n <= end; n++) {
						sum *= n;
					}
				} else {
					for (long n = start; n <= end; n++) {
						sum *= constant;
		        	}
				}
		}
		
		return sum;
	}
	
	public static long doubleProdNot(int nValue, String equation, double firstValue, double secondValue, double thirdValue, double fourthValue) {
		long start = (long) firstValue;
		long end = (long) secondValue;
		long jstart = (long) thirdValue;
		long jend = (long) fourthValue;
		long sum = 1;
		
		nValue = (nValue == 0) ? 1 : nValue;
		
		for(long n = start; n <= end; n++) {
			for(long j = jstart; j <= jend; j++) {
				switch (equation) {
					case "xy":
						sum *= (nValue * n * j);
						break;
					case "x+y":
						sum *= (nValue * n + j);
						break;
					case "x^y":
						sum *= (nValue * Math.pow(n, j));
						break;
					default:
						sum *= n * j;
				 }
			}
		}
		return sum;
	}
	
	public static double basicCalculation(String operator, double firstValue, double secondValue) {
		double Answer = 0;
		switch(operator) {
		case "//":
			Answer = firstValue / secondValue;
			Answer = (long) Answer;
			break;
		case "%":
			Answer = firstValue % secondValue;
			break;
		case "x^y":
			Answer = Math.pow(firstValue, secondValue);
			break;
		case "numroot":
			Answer = Math.pow(secondValue, 1.0 / firstValue);
		}
		
		return Answer;
	}
	
	public static double calculateResult(ArrayList<Double> numbers,  ArrayList<String> operators) {
	    double result = numbers.get(0);
	    
	    for (int i = 1; i < numbers.size(); i++) {
	    	String operator = operators.get(0);
	    	switch(operator) {
	            case "+":
	                result += numbers.get(i);
	                break;
	            case "-":
	                result -= numbers.get(i);
	                break;
	            case "*":
	                result *= numbers.get(i);
	                break;
	            case "÷":
	                result /= numbers.get(i);
	                break;
	        }
	        operators.remove(0);
	    }

	    return result;
	}
	
	public static String formatString(double Answer) {
		String formattedAnswer;
		if (Answer % 1 == 0) {
			formattedAnswer = String.valueOf((long) Answer);
		} else {
			formattedAnswer = String.format("%.2f", Answer);
		}
		
		return formattedAnswer;
	}
}