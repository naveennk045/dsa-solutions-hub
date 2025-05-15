package solvedproblems.companywise.servicenow;


public class CalculateRoot {
    public static double squareRoot(double number){
        double guess=number/2.0;
        double epsilon=0.001;
        while(Math.abs(guess*guess -number)>epsilon){
            guess=(guess+(number/guess))/2.0;
        }
        return  guess;
    }

    public static double cubeRoot(int number){
        double guess = number / 3.0; // Initial guess
        double epsilon = 0.0001; // Precision threshold

        while (Math.abs(guess * guess * guess - number) > epsilon) {
            guess = guess - (guess * guess * guess - number) / (3 * guess * guess);
        }
        return guess;
    }



    public static void main(String[] args) {
        System.out.printf("%.2f",squareRoot(16));
        System.out.println(squareRoot(16.0));
    }
}