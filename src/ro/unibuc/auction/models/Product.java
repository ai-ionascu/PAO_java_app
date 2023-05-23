package ro.unibuc.auction.models;

public class Product {
    private String name;
    private Seller seller;
    private String description;
    private String state;
    private String payment;

    public Product(String name, Seller seller, String description, String state, String payment) {
        this.name = name;
        this.seller = seller;
        this.description = description;
        this.state = state;
        this.payment = payment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }
}
