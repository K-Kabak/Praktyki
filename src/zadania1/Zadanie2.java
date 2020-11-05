import  java.util.Scanner;



public class Zadanie2
{

}

class Matma {
    public static void main(String[] args) {
        double PI = 3.14;
        double E = 2.71;
        double sqrt = Math.sqrt(PI); //pierwiastek kwadratowy
        double powerr = Math.pow(E, 3); //E do potęgi 3
        double power = Math.pow(PI, 3); //PI do potęgi 3

        System.out.println("Pierwiastek z " + PI + " wynosi: " + sqrt);
        System.out.println("Liczba " + E + " podniesiona do potegi " + 3 + " to " + powerr);
        System.out.println("Liczba " + PI + " podniesiona do potegi " + 3 + " to " + power);
        System.out.println("Suma "+ (PI+E));
        System.out.println("Różnica "+ (PI-E));
        System.out.println("Iloczyn "+ (PI*E));
    }
}
