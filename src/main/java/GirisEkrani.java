import java.util.Objects;
import java.util.Scanner;

public class GirisEkrani {

    public static void acilisEkrani() {

        System.out.println("**************************");
        System.out.println("Press '1' to log in");
        System.out.println("Press '2' to register");
        System.out.println("Press '0' to exit");
        System.out.println("**************************");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        if (choice == 1) {
            OturumAc.oturumAc(scanner);
        } else if (choice == 2) {
            KayitOl.kayit(scanner);

        } else if (choice == 0) {
            System.out.println("Application exited");

        } else {
            System.out.println("Please enter one of the values given above");
        }


    }


}
