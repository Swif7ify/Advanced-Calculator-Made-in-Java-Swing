
import java.lang.Math;

public class main{

    public static void main(String[] args){

        //change nalang to depende sa nature ng intput kineme
        double expression;


        //list lang muna to ng functions, later on nalang yung sa input handling, 
        //di ko pa alam kung pano eh
        double sqroot = Math.sqrt(expression);//square root
        double cbroot = Math.cbrt(expression);//cube root
        double numCeil = Math.ceil(expression);
        double numFloor = Math.floor(expression);
        int numRound = Math.round(expression);
    }

    // pythagorean
    public static double pyhtagorean(double a, double b){
        return Math.sqrt(a*a + b*b);
    }

    public static double pythaMissingSide(double c, double knownside, boolean forA){
    double missingSide = c*c - knownside * knownside;

    if (c <= knownside || missingSide < 0) throw new IllegalArgumentException("Invalid Dimensions");

    return Math.sqrt(missingSide);
    }


    //quadratic equation
    public static void quadraticSolution(double a, double b, double c){

        if (a == 0){
            //print invalid input
        }

        double discri = b*b-4*a*c;

        if (discri > 0){
            double root_1st = (-b + Math.sqrt(discri)) / (2 * a);
            double root_2nd = (-b - Math.sqrt(discri)) / (2 * a);
            //output output
        }

        else if (discri == 0){
            double rootAns = -b / (2*a);
            //output output
        }

        else {
            double realNum = -b / (2*a);
            double imagiNum = Math.sqrt(-discri) / (2*a);
            //output output
        }
    }

    //factorial
    public static int factorialFunc(int inputNum){
        int factProd = 1;

        for(int i = 1; i <= inputNum; i++){
            factProd *= i; 
        }
        
        return factProd;
    }

    public static int capitalSigma(int InitialNum, int LastNum){
        int totalSum = 0; 

        for(int i = InitialNum; i <= LastNum; i++){
            int valueOrExpression = i;
            totalSum += valueOrExpression; 
            //or depende pa yung equation nilagay nila dito, kayo decide
        }
        return totalSum;
    }

    //the same lang sa summation sa taas, pero multiply
    public static int capitalPi(int InitialNum, int LastNum){
        int totalProd = 1; 

        for(int i = InitialNum; i <= LastNum; i++){
            int valueOrExpression = i;
            totalProd *= valueOrExpression; 
            //or depende pa yung equation nilagay nila dito, kayo decide
        }
        return totalProd;
    }

    // double summation naman na to
    public static int doubleSummation(int lastNum1, int lastNum2) {
        int totalSum = 0;
        
        for (int i = 1; i <= lastNum1; i++) {
            for (int j = 1; j <= lastNum2; j++) {
                totalSum += (i + j); 
            }
        }   
        return totalSum;
    }

    public static int doubleProduct(int lastNum1, int lastNum2) {
        int totalProd = 0;
        
        for (int i = 1; i <= lastNum1; i++) {
            for (int j = 1; j <= lastNum2; j++) {
                totalProd += (i * j); 
            }
        }
        return totalProd;
    }

    public static int factorialSum(int a, int b){
        int num1 = factorialFunc(a);
        int num2 = factorialFunc(b);

        int totalSum = num1 + num2;
        return totalSum;
    }

    public static itn factorialQuo(int a, int b){
        int num1 = factorialFunc(a);
        int num2 = factorialFunc(b);

        int totalQuo = num1 / num2;
        return totalQuo;
    }
}

// yan lang muna mga nagawa ko, nag hanap ako ng aso eh, nakawala kasi HAHAHAH
=======