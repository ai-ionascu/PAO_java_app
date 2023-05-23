package ro.unibuc.auction.models;

public class Bid {
    private User bidder;
    private double price;
    private String timestamp;

    public Bid(User bidder, double price, String timestamp) {
        this.bidder = bidder;
        this.price = price;
        this.timestamp = timestamp;
    }

    public User getBidder() {
        return bidder;
    }

    public void setBidder(User bidder) {
        this.bidder = bidder;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}