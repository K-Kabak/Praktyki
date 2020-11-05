public class SzyfrCezara {
    public static void main(String[] args) {
     String wiadomosc = "chuj";

     System.out.println(wiadomosc);

     char[] arr = wiadomosc.toCharArray();

     for(int i=0; i<wiadomosc.length(); i++)
     {
         if(arr[i] >= 65 && arr[i] <= 87 || arr[i] >= 97 && arr[i] <= 119 )
         {
             arr[i] += 3;
         }
         switch(arr[i])
         {
             case 'X': arr[i] = 'A';
             break;
             case 'Y': arr[i] = 'B';
             break;
             case 'Z': arr[i] = 'C';
             break;
             case 'x': arr[i] = 'a';
             break;
             case 'y': arr[i] = 'b';
             break;
             case 'z': arr[i] = 'c';
             break;
         }
     }
     System.out.println(arr);
    }
}
