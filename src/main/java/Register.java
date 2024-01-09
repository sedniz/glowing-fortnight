import java.sql.*;
import java.util.Objects;
import java.util.Scanner;

public class Register {
    private static final String URL = "jdbc:postgresql://localhost:5432/site";
    private static final String USER = "sitemanager";
    private static final String PASSWORD = "password";
    static void register(Scanner scanner) {

        System.out.println("Enter your name: ");
        String name = scanner.next();
        System.out.println("Enter your surname: ");
        String surname = scanner.next();
        System.out.println("Specify the username: ");
        String username = scanner.next();
        System.out.println("Specify the password: ");
        String password = scanner.next();
        System.out.println("Repeat password: ");
        String passwordR = scanner.next();

        if (Objects.equals(passwordR, password)){
            try {
                Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                String sql = "INSERT INTO users VALUES (?, ?, ?, ?)";
                PreparedStatement prst = conn.prepareStatement(sql);
                prst.setString(1,name);
                prst.setString(2,surname);
                prst.setString(3,username);
                prst.setString(4,password);
                int result = prst.executeUpdate();
                if (result > 0) {
                    System.out.println("Register Successful!");
                }
                prst.close();
                conn.close();


                System.out.println("Would you like to take any further action?");
                System.out.println("Yes to press 'e'");
                System.out.println("No to press 'h'");
                String repeat = scanner.next();


                if (repeat.equalsIgnoreCase("e")){
                    LoginScreen.startScreen();
                }else if (repeat.equalsIgnoreCase("h")){
                    System.out.println("Have a nice day...");
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else {
            System.out.println("Passwords do not match");
        }


    }
}
