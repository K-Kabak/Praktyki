import  java.util.Scanner;



public class Zadanie1
{
    String imie;
    String nazwisko;
    int wiek;
}

class info
{
    public static void  main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        Zadanie1 zadanie1 = new Zadanie1();

        System.out.println("Podaj swoje imię?: ");
        zadanie1.imie = scan.nextLine();
        System.out.println("Podaj swoje nazwisko: ");
        zadanie1.nazwisko = scan.nextLine();
        System.out.println("Podaj swój wiek: ");
        zadanie1.wiek = scan.nextInt();

        System.out.println("Twoje dane które podałeś: ");
        System.out.println(zadanie1.imie+"\n"+zadanie1.nazwisko+"\n"+zadanie1.wiek+" lat"+"\n");
    }
}
