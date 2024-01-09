import java.sql.*;
import java.util.Objects;
import java.util.Scanner;

public class LogIn {

    private static final String URL = "jdbc:postgresql://localhost:5432/site";
    private static final String USER = "sitemanager";
    private static final String PASSWORD = "password";

    public static void logIn(Scanner scanner) {



        System.out.println("Enter your username");
        String kullaniciAdi = scanner.next();
        System.out.println("Enter your password");
        String password = scanner.next();



            try {
                Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                String sql = "select username,password from users";
                PreparedStatement prst = conn.prepareStatement(sql);

                ResultSet rs = prst.executeQuery();


                while (rs.next()) {
                    String username = rs.getString("username");
                    String pw = rs.getString("password");


                    if (Objects.equals(username, kullaniciAdi) && Objects.equals(password, pw)) {
                        System.out.println("You are logged in");
                        prst.close();
                        conn.close();
                        break;

                    } else {
                        System.out.println("Username or password is incorrect, try again.");
                        prst.close();
                        conn.close();
                        LoginScreen.startScreen();

                    }
                }


            } catch (SQLException e) {
                e.printStackTrace();
            }


    }
}