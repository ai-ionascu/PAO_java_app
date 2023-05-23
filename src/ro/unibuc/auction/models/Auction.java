package ro.unibuc.auction.models;

import java.util.ArrayList;
import java.util.List;

public class Auction {
    private int id;
    private Product product;
    private List<Bid> bidsList;
    private String startTime;
    private String endTime;
    private String status;
    private Buyer winner;

    public Auction(int id, Product product, String startTime, String endTime) {
        this.id = id;
        this.product = product;
        this.startTime = startTime;
        this.endTime = endTime;
        this.bidsList = new ArrayList<>();
        this.status = "Active";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<Bid> getBidsList() {
        return bidsList;
    }

    public void setBidsList(List<Bid> bidsList) {
        this.bidsList = bidsList;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Buyer getWinner() {
        return winner;
    }

    public void setWinner(Buyer winner) {
        this.winner = winner;
    }

    public void addBid(User bidder, double price, String timestamp) {
        Bid bid = new Bid(bidder, price, timestamp);
        bidsList.add(bid);
    }

    public void closeAuction(Buyer winner) {
        this.winner = winner;
        this.status = "Closed";
    }
}
