package cwiczenia;

public class Human {
    private double wzrost;
    private char plec;
    private double rozmiar_buta;
    private boolean czy_lysy = false;
    private String color_wlosow;
    private int wiek;
    private Human[] rodzice;


    static  String gatunek = "homo sapiens";
    static String krolestwo = "ssaki";
    static String rzad = "pis";


    static long liczba_ludzi_na_ziemi = 7800000000l;


    static void nowy_czlowiek(){
        liczba_ludzi_na_ziemi++;
    }

    public Human(double wzrost, char plec, double rozmiar_buta, boolean czy_lysy, String color_wlosow, int wiek, Human[] rodzice) {
        this.wzrost = wzrost;
        this.plec = plec;
        this.rozmiar_buta = rozmiar_buta;
        this.czy_lysy = czy_lysy;
        this.color_wlosow = color_wlosow;
        this.wiek = wiek;
        this.rodzice = rodzice;
    }
}
