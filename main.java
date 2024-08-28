
import java.lang.Math;

public class main{

    public static void main(String[] args){

        //change nalang to depende sa nature ng intput kineme
        double expression;


        //list lang muna to ng functions, later on nalang yung sa input handling, 
        //di ko pa alam kung pano eh
        double sqroot = Math.sqrt(expression);//square root
        double cbroot = Math.cbrt(expression);//cube root
        int numCeil = Math.ceil(expression);
        int numFloor = Math.floor(expression);
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
}

// yan lang muna mga nagawa ko, nag hanap ako ng aso eh, nakawala kasi HAHAHAH
=======