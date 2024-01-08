import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SimpleInventorySystem {
    private Map<Integer, Item> inventory;

    public SimpleInventorySystem() {
        this.inventory = new HashMap<>();
    }

    public void addItem(int itemId, String itemName, int quantity) {
        if (!inventory.containsKey(itemId)) {
            inventory.put(itemId, new Item(itemName, quantity));
            System.out.println("Item '" + itemName + "' added to inventory with ID " + itemId);
        } else {
            System.out.println("Item with ID " + itemId + " already exists. Use update to modify the quantity.");
        }
    }

    public void updateItem(int itemId, int newQuantity) {
        if (inventory.containsKey(itemId)) {
            Item item = inventory.get(itemId);
            item.setQuantity(newQuantity);
            System.out.println("Quantity updated for item ID " + itemId + ". New quantity: " + newQuantity);
        } else {
            System.out.println("Item with ID " + itemId + " not found. Use add to create a new item.");
        }
    }

    public void viewItems() {
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            System.out.println("Inventory:");
            for (Map.Entry<Integer, Item> entry : inventory.entrySet()) {
                int itemId = entry.getKey();
                Item item = entry.getValue();
                System.out.println("ID: " + itemId + ", Name: " + item.getName() + ", Quantity: " + item.getQuantity());
            }
        }
    }

    public static void main(String[] args) {
        SimpleInventorySystem inventorySystem = new SimpleInventorySystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nOptions:");
            System.out.println("1. Add Item");
            System.out.println("2. Update Item");
            System.out.println("3. View Items");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Item ID: ");
                    int itemId = scanner.nextInt();
                    System.out.print("Enter Item Name: ");
                    String itemName = scanner.next();
                    System.out.print("Enter Quantity: ");
                    int quantity = scanner.nextInt();
                    inventorySystem.addItem(itemId, itemName, quantity);
                    break;

                case 2:
                    System.out.print("Enter Item ID to update: ");
                    int updateItemId = scanner.nextInt();
                    System.out.print("Enter New Quantity: ");
                    int newQuantity = scanner.nextInt();
                    inventorySystem.updateItem(updateItemId, newQuantity);
                    break;

                case 3:
                    inventorySystem.viewItems();
                    break;

                case 4:
                    System.out.println("Exiting the program. Goodbye!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

class Item {
    private String name;
    private int quantity;

    public Item(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}