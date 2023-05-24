package ro.unibuc.auction.logic;
import ro.unibuc.auction.models.User;
import ro.unibuc.auction.services.*;

import java.util.List;
import java.util.Scanner;

public class UserSubmenu implements Submenu {
    private Scanner scanner;
    private UserService userService;
    private ShowUserList showUserList;
    private boolean back = false;
    private boolean goToMainMenu = false;

    public UserSubmenu (Scanner scanner) {
        this.scanner = scanner;
        this.showUserList = new ShowUserList();
        this.userService = new UserService();
    }

    @Override
    public void display() {
        while (!back && !goToMainMenu) {
            System.out.println("User Submenu");
            System.out.println("1. Show All");
            System.out.println("2. New");
            System.out.println("3. Update");
            System.out.println("4. Delete");
            System.out.println("0. Back");
            System.out.print("Select option: ");

            int option = scanner.nextInt();
            scanner.nextLine();

            handleOption(option);

            if (goToMainMenu) {
                return;
            }
        }
    }

    @Override
    public void handleOption(int option) {
        List<User> userList = userService.read();

        switch (option) {
            case 1:
                showUserList.showList(userList);
                break;
            case 2:
                boolean newBack = false;
                while (!newBack){
                    System.out.println("New User Submenu");
                    System.out.println("Enter the following inputs, separated by comma: username, email");
                    System.out.println("0. Back");
                    String input = scanner.nextLine();
                    if (input.equals("0")){
                        newBack = true;
                    }
                    String[] inputArray = input.split(",");
                    if (inputArray.length != 2) {
                        System.out.println("Invalid input format. Please provide username and email separated by comma.");
                        return;
                    }
                    String username = inputArray[0].trim();
                    String email = inputArray[1].trim();
                    User newUser = new User(username, email);
                    userService.create(newUser);
                }
                break;
            case 3:
                boolean updateBack = false;
                while (!updateBack) {
                    showUserList.showList(userList);
                    System.out.println("User Update Submenu");
                    System.out.println("Enter the index number of the item to update:");
                    System.out.println("0. Back");
                    int updateIndex = scanner.nextInt();
                    scanner.nextLine();

                    if (updateIndex == 0) {
                        updateBack = true;
                        return;
                    } else if (updateIndex > 0 && updateIndex <= userList.size()) {
                        User oldUser = userList.get(updateIndex - 1);
                        boolean innerBack = false;
                        while (!innerBack) {
                            System.out.println("Enter the following inputs, separated by a comma: username, email");
                            System.out.println("0. Back");
                            String input = scanner.nextLine();
                            if (input.equals("0")) {
                                innerBack = true;
                            } else {
                                String[] inputArray = input.split(",");
                                if (inputArray.length != 2) {
                                    System.out.println("Invalid input format. Please provide username and email separated by a comma.");
                                    continue;
                                }
                                String username = inputArray[0].trim();
                                String email = inputArray[1].trim();
                                User newUser = new User(username, email);
                                userService.update(oldUser, newUser);
                                innerBack = true;
                            }
                        }
                    } else {
                        System.out.println("Invalid index number. Please try again.");
                    }
                }
                break;
            case 4:
                boolean deleteBack = false;
                while (!deleteBack){
                    System.out.println("User Delete Submenu");
                    showUserList.showList(userList);
                    System.out.println("0. Back");
                    System.out.println("Enter the index number of the item to delete:");
                    int deleteIndex = scanner.nextInt();
                    if (deleteIndex == 0) {
                        deleteBack = true;
                    } else if (deleteIndex > 0 && deleteIndex <= userList.size()) {
                        User selectedUser = userList.get(deleteIndex - 1);
                        userService.delete(selectedUser);
                    } else {
                        System.out.println("Invalid index number. Please try again.");
                    }
                }
                break;
            case 0:
                back = true;
                goToMainMenu = true;
                break;
            default:
                System.out.println("Error, please make a valid selection.");
        }
    }
}
