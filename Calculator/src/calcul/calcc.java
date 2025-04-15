package calcul;
import java.util.Scanner;

public class calcc {

    public static void main(String[] args) {
        System.out.println("Vvedite operaciyu: ");
        System.out.println("1. Slojenie: ");
        System.out.println("2. Vichitanie: ");
        System.out.println("3. Umnojenie: ");
        System.out.println("4. Delenie: ");
        //Savinyh Alexey Aleksandrovich
        Scanner sc = new Scanner(System.in);
        int  operation = sc.nextInt();
        
        System.out.println("Vvedite pervoe chislo: ");
        int  x = sc.nextInt();
        System.out.println("Vvedite vtoroe chislo: ");
        int  y = sc.nextInt();
        
        int  res = 0;
        
        if (operation == 1)
            res = x + y;
        else if (operation == 2)
            res = x - y;
        else if (operation == 3)
            res = x * y;
        else if (operation == 4)
            res = x / y;
        System.out.println("Resultat = " + res);
        System.out.println("Savinyh");
    }
    
}
