package ro.unibuc.auction.services;
import java.util.Scanner;
import ro.unibuc.auction.models.User;

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
        switch (option) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            default:
                System.out.println("Error, please make a valid selection.");
        }
    }
}
