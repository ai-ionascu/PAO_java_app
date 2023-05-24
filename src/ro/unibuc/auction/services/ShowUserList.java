package ro.unibuc.auction.services;
import ro.unibuc.auction.models.User;
import java.util.List;

public class ShowUserList {
    public void showList(List<User> userList) {
        for (User user : userList) {
            System.out.println(userList.indexOf(user)+1 + ". Name: " + user.getUsername() + "   Email: " + user.getEmail());
            System.out.println("--------------------");
        }
    }
}
