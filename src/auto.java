
class Opony
{
String marka;
double tarcie;

}

public class auto
{

String color;
int liczba_miejsc;
int pojemnosc_silnika;
double velocity;
Opony opony;

void jedz()
{
    System.out.println("brum brum");
}

Opony get_opony()
{
    return  opony;
}

    public double getVelocity() {
        return velocity;
    }

    void  set_all(String color, int liczba_miejsc, int pojemnosc_silnika, double velocity) {
    this.color = color;
    this.liczba_miejsc = liczba_miejsc;
    this.pojemnosc_silnika = pojemnosc_silnika;
    this.velocity = velocity;
    }
}


