package ro.unibuc.auction.models;

public class Furniture extends Product {
    private String material;
    private String room;
    private String color;

    public Furniture(int id, String name, Seller seller, String description, String state, String payment, String material,
                     String room, String color) {
        super(id, name, seller, description, state, payment);
        this.material = material;
        this.room = room;
        this.color = color;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
