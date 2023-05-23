package ro.unibuc.auction.logic;
import java.util.Scanner;

public class AuctionSubmenu implements Submenu {
    private Scanner scanner;

    public AuctionSubmenu(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void display() {
        System.out.println("Auction Submenu");
        System.out.println("2. Live Auctions");
        System.out.println("3. Closed Auctions");
        System.out.println("1. Start Auction");
        System.out.println("4. Delete Auction");
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

