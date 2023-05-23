package ro.unibuc.auction;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import ro.unibuc.auction.db.dbCon;
import ro.unibuc.auction.models.*;
//import ro.unibuc.auction.services.*;

public class App {
    public static void main(String[] args) {
        dbCon con_object = dbCon.getInstance();
        Connection con = con_object.getConnection();

        // READ
        try {
            String selectQuery = "SELECT * FROM test";
            Statement selectStatement = con.createStatement();
            ResultSet resultSet = selectStatement.executeQuery(selectQuery);
            while (resultSet.next()) {
                String col1 = resultSet.getString("col1");
                String col2 = resultSet.getString("col2");
                String col3 = resultSet.getString("col3");
                String col4 = resultSet.getString("col4");
                System.out.println("col1: " + col1 + ", col2 " + col2 + ", col3: " + col3 + ", col4: " + col4);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        con_object.closeConnection();

        // Create Seller object
        Seller seller = new Seller("sellerUser", "gigi.vanzatoru@example.com", "Gigi", "Vanzatoru");

        // Create Product object
        Product product = new Product("Product 1", seller, "Description", "New", "Card");

        // Create Auction object
        Auction auction = new Auction("Auction 1", product, "2023-05-22 10:00", "2023-05-23 10:00");

        // Create Buyer object
        Buyer buyer = new Buyer("buyerUser", "titi.cumparatoru@example.com", "Titi", "Cumparatoru");

        // Add bid to auction object
        auction.addBid(buyer, 100.0, "2023-05-22 11:30");
        auction.addBid(buyer, 150.0, "2023-05-22 12:00");

        // Close auction
        auction.closeAuction(buyer);

        // Display auction details
        System.out.println("Auction ID: " + auction.getId());
        System.out.println("Product: " + auction.getProduct().getName());
        System.out.println("Start Time: " + auction.getStartTime());
        System.out.println("End Time: " + auction.getEndTime());
        System.out.println("Status: " + auction.getStatus());
        System.out.println("Winner: " + auction.getWinner().getFirstName() + " " + auction.getWinner().getLastName());

        // Display bids
        List<Bid> bids = auction.getBidsList();
        for (Bid bid : bids) {
            // exemplu downcasting
            Buyer bidder = (Buyer) bid.getBidder();
            System.out.println("Bid: " + bid.getPrice() + " by " + bidder.getFirstName() + " " + bidder.getLastName() + " at " + bid.getTimestamp());
        }
    }
}
