package cwiczenia;

public class Czlowiek extends Human {
    protected int telefon;
    protected String ulica_zakladu;
    boolean czy_dobry = true;
    String[] zakres_pracy;

    public Czlowiek(double wzrost, char plec, double rozmiar_buta, boolean czy_lysy, String color_wlosow, int wiek, Human[] rodzice, int telefon, String ulica_zakladu, boolean czy_dobry, String[] zakres_pracy) {
        super(wzrost, plec, rozmiar_buta, czy_lysy, color_wlosow, wiek, rodzice);
        this.telefon = telefon;
        this.ulica_zakladu = ulica_zakladu;
        this.czy_dobry = czy_dobry;
        this.zakres_pracy = zakres_pracy;
    }
}
