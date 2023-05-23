package ro.unibuc.auction.logic;
import ro.unibuc.auction.models.User;
import ro.unibuc.auction.services.UserService;

import java.util.List;
import java.util.Scanner;

public class UserSubmenu implements Submenu {
    private Scanner scanner;

    public UserSubmenu (Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void display() {
        System.out.println("User Submenu");
        System.out.println("1. Show All");
        System.out.println("2. New");
        System.out.println("3. Update");
        System.out.println("4. Delete");
        System.out.println("5. Back");

        System.out.print("Select option: ");
    }

    @Override
    public void handleOption(int option) {
        UserService userService = new UserService();
        List<User> userList = userService.read();
        switch (option) {
            case 1:
                for (User user : userList) {
                    System.out.println(userList.indexOf(user) + ". Name: " + user.getUsername() + "   Email: " + user.getEmail());
                    System.out.println("--------------------");
                }
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                for (User user : userList) {
                    System.out.println(userList.indexOf(user) + ". Name: " + user.getUsername() + "   Email: " + user.getEmail());
                }
                System.out.println("Enter the index number of the item to delete:");
                Scanner scanner = new Scanner(System.in);
                int selectedIndex = scanner.nextInt();
                User selectedUser = userList.get(selectedIndex);
                userService.delete(selectedUser);
                break;
            case 5:
                break;
            default:
                System.out.println("Error, please make a valid selection.");
        }
    }
}
