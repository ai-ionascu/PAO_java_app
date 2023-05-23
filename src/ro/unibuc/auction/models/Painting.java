package ro.unibuc.auction.models;

public class Painting extends Product {
    private String author;
    private String style;
    private String medium;

    public Painting(int id, String name, Seller seller, String description, String state, String payment,
                    String author, String style, String medium) {
        super(id, name, seller, description, state, payment);
        this.author = author;
        this.style = style;
        this.medium = medium;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }
}
