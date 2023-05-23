package ro.unibuc.auction.logic;
import java.util.Scanner;

public class ProductSubmenu implements Submenu {
    private Scanner scanner;

    public ProductSubmenu(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void display() {
        System.out.println("Product Submenu");
        System.out.println("1. Show All");
        System.out.println("2. New");
        System.out.println("3. Back");

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
            default:
                System.out.println("Error, please make a valid selection.");
        }
    }
}
