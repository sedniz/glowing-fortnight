import java.util.Scanner;

public class LoginScreen {

    public static void startScreen() {

        System.out.println("**************************");
        System.out.println("Press '1' to log in");
        System.out.println("Press '2' to register");
        System.out.println("Press '0' to exit");
        System.out.println("**************************");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        if (choice == 1) {
            LogIn.logIn(scanner);
        } else if (choice == 2) {
            Register.register(scanner);

        } else if (choice == 0) {
            System.out.println("Application exited");

        } else {
            System.out.println("Please enter one of the values given above");
        }


    }


}
