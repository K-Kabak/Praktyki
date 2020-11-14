import java.util.*;
public class driver {
    static Scanner scan = new Scanner(System.in);
    static Random rand = new Random();
    static dice die = new dice();
    public static String playerName;
    public static int playerhp;
    public static int maxhp;
    public static int maxmana;
    public static int mana;
    public static int playerdmg;
    public static int xp;
    public static int enemyhp;
    public static int enemydmg;
    public static int Level;
    public static String charclass;
    public static boolean walka = false;

    private static void statystyki() {
        if(charclass.equals("mag")){
            System.out.println(playerName + "\nhp: " + playerhp + "\nmana: " + mana + "\ndamage: " + playerdmg + "\nxp: " + xp + "\n");
        }else{
            System.out.println(playerName + "\nhp: " + playerhp + "\ndamage: " + playerdmg + "\nxp: " + xp + "\n");
        }
    }
    private static void StatystkiPrzeciwnika() {
        System.out.println("Enemy "+"\nhp: " + enemyhp + "\ndmg: " + enemydmg + "\n");
    }

    private static void Wojownik() {
        charclass = "wojownik";
        maxhp = 20;
        playerhp = 20;
        playerdmg = 4;
        xp = 0;
        Level = 1;
    }
    private static void Łucznik() {
        charclass = "łucznik";
        maxhp = 14;
        playerhp = 14;
        playerdmg = 6;
        xp = 0;
        Level = 1;
    }
    private static void Mag() {
        charclass = "mag";
        maxhp = 10;
        playerhp = 10;
        mana = 20;
        maxmana = 20;
        playerdmg = 2;
        xp = 0;
        Level = 1;
    }
    private static void Przeciwnik() {
        switch(Level){
            case 1:
                enemyhp = 9;
                enemydmg = 1;
                break;
            case 2:
                enemyhp = 19;
                enemydmg = 4;
                break;
            case 3:
                enemyhp = 24;
                enemydmg = 6;
                break;
            case 4:
                enemyhp = 32;
                enemydmg = 7;
                break;
            case 5:
                enemyhp = 40;
                enemydmg = 9;
                break; //statystyki przeciwnika w zależności od levela postaci
        }
    }
    private static void fight() {
        String action;
        String spellAction = null;
        System.out.println("Trafiłeś na przeciwnika!");
        Przeciwnik();
        walka = true;
        while(walka = true){
            System.out.println("Naciśnij 'a' żeby zaatakować\nNaciśnij 'i' żeby wyświetlić info");
            if(charclass.equals("mage")){
                System.out.print("Naciśnij 's' żeby użyć umiejętnośći\n");
            }
            action = scan.nextLine();
            if(action.charAt(0) == 'a'){
                walka = attack();
                if(walka == false){
                    switch(Level){
                        case 1:
                            xp = xp + 4;
                            break;
                        case 2:
                            xp = xp + 6;
                            break;
                        case 3:
                            xp = xp + 9;
                            break;
                        case 4:
                            xp = xp + 12;
                            break;
                    }
                    System.out.println("Zdobyłeś :" + xp + " xp");
                    LevelUp();
                    return;
                }
                enemyattack();
            }

            if(action.charAt(0) == 'i'){
                statystyki();
                StatystkiPrzeciwnika();

            }
            if(action.charAt(0) == 's'){
                System.out.println("Naciśnij 'f' żeby użyć fireball'a\n naciśnij 'u' żeby się uleczyć\n");
                spellAction = scan.nextLine();
                if(spellAction.charAt(0) == 'f'){
                    if(die.roll10() > 2){
                        mana = mana - 10;
                        if(mana <0){
                            System.out.println("Nie masz wystarczająco many!");
                            mana = mana + 10;
                            System.out.println("Twoja mana została odnowiona o 10!");
                        }else{
                            int k = die.roll10(); //Wybiera randomowy dmg od 1 do 10
                            System.out.println("Udeżyłeś za " + k + " obrażeń!");
                            enemyhp = enemyhp - k;
                            if(enemyhp <= 0){
                                System.out.println("Wygrałeś!");
                                switch(Level){
                                    case 1:
                                        xp = xp + 4;
                                        break;
                                    case 2:
                                        xp = xp + 6;
                                        break;
                                    case 3:
                                        xp = xp + 9;
                                        break;
                                    case 4:
                                        xp = xp + 12;
                                        break;
                                }
                                System.out.println("You earned :" + xp + " xp");
                                LevelUp();
                                return;
                            }
                            enemyattack();
                        }
                    }
                    else{
                        System.out.println("Nie trafiłeś!");
                        enemyattack();
                    }
                }else
                if(spellAction.charAt(0) == 'h'){
                    mana = mana - 8;
                    if(mana <0){
                        System.out.println("Nie masz wystarczająco many!");
                        mana = mana + 8;
                        System.out.println("Twoja mana została odnowiona o 8!");
                    }else{
                        int x = die.roll10(); //healuje randomowo  1-8
                        System.out.println("Wyleczyłeś się!");
                        System.out.println("+ " + x + " hp");
                        playerhp = playerhp + x;
                        if(playerhp>maxhp){
                            playerhp = maxhp;
                        }
                        enemyattack();
                    }
                }

            }
        }
    }

    private static void LevelUp() {
        if(xp >= 100 && Level == 4){
            System.out.println("Level 5!");
            Level = Level + 1;
            maxhp = maxhp + 25;
            playerhp = maxhp;
            if(charclass.equals("mag")){
                maxmana = maxmana + 7;
                mana = maxmana;
            }
            playerdmg = playerdmg + 3;
            statystyki();
        }else
        if(xp >= 50 && Level == 3){
            System.out.println("Level 4!");
            Level = Level + 1;
            maxhp = maxhp + 20;
            playerhp = maxhp;
            if(charclass.equals("mag")){
                maxmana = maxmana + 7;
                mana = maxmana;
            }
            playerdmg = playerdmg + 2;
            statystyki();
        }else
        if(xp >= 25 && Level == 2){
            System.out.println("Level 3!");
            Level = Level + 1;
            maxhp = maxhp + 10;
            playerhp = maxhp;
            if(charclass.equals("mag")){
                maxmana = maxmana + 7;
                mana = maxmana;
            }
            playerdmg = playerdmg + 2;
            statystyki();
        }else
        if(xp >= 10 && Level == 1){
            System.out.println("Level 2!");
            Level = Level + 1;
            maxhp = maxhp + 5;
            playerhp = maxhp;
            if(charclass.equals("mag")){
                maxmana = maxmana + 7;
                mana = maxmana;
            }
            playerdmg = playerdmg + 1;
            statystyki();
        }//Dodaje statystki wraz z rosnącym levelem

    }
    private static void enemyattack() {
        if(die.roll6() > 2){
            System.out.println("Enemy hits!");
            playerhp = playerhp - enemydmg;
            if(playerhp <= 0){
                gameover();
                System.exit(0);//Gra się kończy wraz z hp  < 0
            }
        }else{
            System.out.println("Przeciwnik nie trafił!");
        }
    }
    private static boolean attack() {
        if(die.roll6() > 2){
            System.out.println("Trafiłeś!");
            enemyhp = enemyhp - playerdmg;
            if(enemyhp <= 0){
                System.out.println("Wygrałeś!"); //Wyświetla się napis jeśli hp przeciwnika < 0
                return false;
            }
        }else{
            System.out.println("Nie trafiłeś!");
        }
        return true;
    }

    private static void gameover() {
        System.out.println(playerName + " Umrał!") ;
        System.out.println("Przegrałeś!");
        System.exit(0); //koniec jeśli przegrałeś
        return;
    }
    public static void main(String[] args) {
        String charclass;
        int num = 2;
        while(num > 1){
            System.out.println("Podaj swoje imię podróżniku!: ");
            playerName = scan.nextLine();
            System.out.println("Wybierz klase: ");
            System.out.println("'w' = Wojownik");
            System.out.println("'l' = Łucznik");
            System.out.println("'m' = Mag");
            charclass = scan.nextLine();
            while(charclass.charAt(0) != 'w' && charclass.charAt(0) != 'a' && charclass.charAt(0) != 'm'){
                System.out.println("'w' = wojownika");
                System.out.println("'l' = łucznika");
                System.out.println("'m' = Maga");
                charclass = scan.nextLine();
            }
            if(charclass.charAt(0) == 'w'){
                Wojownik();
            }
            if(charclass.charAt(0) == 'a'){
                Łucznik();
            }
            if(charclass.charAt(0) == 'm'){
                Mag();
            }
            statystyki();
            while(Level == 1){
                fight();
            }
            System.out.println("Pokonałeś przeciwnika, idz dalej!\n");
            while(Level == 2){
                fight();
            }
            System.out.println("Pokonałeś przeciwnika, idz dalej!\n");
            while(Level == 3){
                fight();
            }
            System.out.println("Pokonałeś przeciwnika, idz dalej!\n");
            while(Level == 4){
                fight();
            }
            System.out.println("Pokonałeś przeciwnika, idz dalej!\n");
            while(Level == 5){
                fight();
            }//
        }

    }
}




class dice {

    public int roll6(){
        Random rand = new Random();
        int a = rand.nextInt(7);
        while(a == 0){
            a = rand.nextInt(7);
        }//1-6
        return a;
    }
    public int roll10(){
        Random rand = new Random();
        int a = rand.nextInt(11);
        while(a == 0){
            a = rand.nextInt(11);
        }
        return a;
    }//1-10
    public int roll20(){
        Random rand = new Random();
        int a = rand.nextInt(21);
        while(a == 0){
            a = rand.nextInt(21);
        }//1-20
        return a;
    }

}