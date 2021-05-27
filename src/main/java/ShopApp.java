import java.util.ArrayList;
import java.util.Scanner;

public class ShopApp {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        System.out.println("Time to go shopping!");


        String wantToShop = "";
        String wantToDelete = "";
        ArrayList<Item> items = new ArrayList<Item>();


        do {

            System.out.print("Enter the name of the item you would like to buy: ");
            String itemName = userInput.nextLine();
            System.out.print("Enter the price of the item: ");
            double itemPrice = userInput.nextDouble();
            System.out.print("Enter the quantity to purchase: ");
            int itemQty = userInput.nextInt();

            Item itemToAdd = new Item();
            itemToAdd.name = itemName;
            itemToAdd.price = itemPrice;
            itemToAdd.quantity = itemQty;

            items.add(itemToAdd);

            updateCart(items);

            System.out.println("Continue shopping (y/n)? ");
            userInput.nextLine();
            wantToShop = userInput.nextLine();


        } while (wantToShop.equals("y"));


        // shopping has ended
        updateCart(items);


        do {
            System.out.println("Would you like to remove anything from your cart (y/n) ?");
            wantToDelete = userInput.nextLine();

            if (wantToDelete.equals("y")) {

                System.out.println("What item would you like to remove? ");
                String itemToDelete = userInput.nextLine();
                removeCart(items, itemToDelete);
            }


        } while (wantToDelete.equals("y"));


        System.out.println("Thanks for shopping! Bye.");

    } // end of PSMV


    public static void updateCart(ArrayList<Item> items) {
        double total = 0;
        double itemTotal = 0;
        System.out.println("==========================");
        System.out.println("Current Cart:");

        for (Item i : items) {
            System.out.printf("Name: %s  Price: %s  Qty: %s\n", i.name, i.price, i.quantity);

            itemTotal = i.price * i.quantity;
            total = total + itemTotal;
        }

        System.out.println("___________________________");
        System.out.println("Total Cart Price: $" + total);
    }

    public static void removeCart(ArrayList<Item> items, String itemToDelete) {

        items.removeIf(i -> i.name.equals(itemToDelete));

        updateCart(items);


    }

}


class Item {
    String name;
    double price;
    int quantity;
}
