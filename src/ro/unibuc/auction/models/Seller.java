package ro.unibuc.auction.models;

public class Seller extends User {
    private String firstName;
    private String lastName;

    public Seller(String username, String email, String firstName, String lastName) {
        super(username, email);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}