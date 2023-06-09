package ro.unibuc.auction;

import java.util.Scanner;
import ro.unibuc.auction.logic.AuctionSubmenu;
import ro.unibuc.auction.logic.ProductSubmenu;
import ro.unibuc.auction.logic.Submenu;
import ro.unibuc.auction.logic.UserSubmenu;

public class App {
    public static void main(String[] args) {
//        dbCon con_object = dbCon.getInstance();
//        Connection con = con_object.getConnection();
//
//        // READ
//        try {
//            String selectQuery = "SELECT * FROM test";
//            Statement selectStatement = con.createStatement();
//            ResultSet resultSet = selectStatement.executeQuery(selectQuery);
//            while (resultSet.next()) {
//                String col1 = resultSet.getString("col1");
//                String col2 = resultSet.getString("col2");
//                String col3 = resultSet.getString("col3");
//                String col4 = resultSet.getString("col4");
//                System.out.println("col1: " + col1 + ", col2 " + col2 + ", col3: " + col3 + ", col4: " + col4);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        con_object.closeConnection();

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Menu");
            System.out.println("1. Product");
            System.out.println("2. Auction");
            System.out.println("3. User");
            System.out.println("0. Exit");

            System.out.print("Select Option: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    // Product submenu
                    Submenu productSubmenu = new ProductSubmenu(scanner);
                    productSubmenu.display();
//                    int productOption = scanner.nextInt();
                    productSubmenu.handleOption(option);
                    break;
                case 2:
                    // Auction submenu
                    Submenu auctionSubmenu = new AuctionSubmenu(scanner);
                    auctionSubmenu.display();
//                    int auctionOption = scanner.nextInt();
                    auctionSubmenu.handleOption(option);
                    break;
                case 3:
                    // User submenu
                    Submenu userSubmenu = new UserSubmenu(scanner);
                    userSubmenu.display();
//                    int userOption = scanner.nextInt();
                    userSubmenu.handleOption(option);
                    break;
                case 0:
                    // Exit
                    exit = true;
                    break;
                default:
                    System.out.println("Error, please make a valid selection.");
            }
        }
    }
}
