package calculator;

import java.util.ArrayList;

public class Functions {
	public static int factorial(double firstValue) {
		if(firstValue < 0) {
			 throw new IllegalArgumentException("Input must be a non-negative integer.");
		}
		int Answer;
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
	
	public static int sumFactorial(double firstValue, double secondValue) {
		return Functions.factorial(firstValue) + Functions.factorial(secondValue);
	}
	
	public static int divideFactorial(double firstValue, double secondValue) {
		return Functions.factorial(firstValue) / Functions.factorial(secondValue);
	}
	
	public static double summation(double firstValue, double secondValue, double thirdValue) {
		int start = (int) firstValue;
		int end = (int) secondValue;
		int constant = (int) thirdValue;
		int sum = 0;
		if (constant == 0 || constant == 1) {
			for (int n = start; n <= end; n++) {
				sum += n;
			}
		} else {
			for (int n = start; n <= end; n++) {
				sum +=constant;
        	}
		}
		return sum;
	}
	
	public static double doubleSummation(double firstValue, double secondValue, double thirdValue, double fourthValue) {
		int start = (int) firstValue;
		int end = (int) secondValue;
		int jstart = (int) thirdValue;
		int jend = (int) fourthValue;
		int sum = 0;
		
		for(int n = start; n <= end; n++) {
			for(int j = jstart; j <= jend; j++) {
				sum += (3*n*j);
			}
		}
		return sum;
	}
	
	public static int prodnot(double firstValue, double secondValue, double thirdValue) {
		int start = (int) firstValue;
		int end = (int) secondValue;
		int constant = (int) thirdValue;
		int sum = 1;
		if (constant == 0 || constant == 1) {
			for (int n = start; n <= end; n++) {
				sum *= n;
			}
		} else {
			for (int n = start; n <= end; n++) {
				sum *= constant;
        	}
		}
		return sum;
	}
	
	public static double doubleProdNot(double firstValue, double secondValue, double thirdValue, double fourthValue) {
		int start = (int) firstValue;
		int end = (int) secondValue;
		int jstart = (int) thirdValue;
		int jend = (int) fourthValue;
		int sum = 1;
		
		for(int n = start; n <= end; n++) {
			for(int j = jstart; j <= jend; j++) {
				sum *= (3*n*j);
			}
		}
		return sum;
	}
	
	public static double basicCalculation(String operator, double firstValue, double secondValue) {
		double Answer = 0;
		switch(operator) {
		case "//":
			Answer = firstValue / secondValue;
			Answer = (int) Answer;
			break;
		case "%":
			Answer = firstValue % secondValue;
			break;
		case "x^y":
			Answer = Math.pow(firstValue, secondValue);
			break;
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
			formattedAnswer = String.valueOf((int) Answer);
		} else {
			formattedAnswer = String.format("%.2f", Answer);
		}
		
		return formattedAnswer;
	}
}