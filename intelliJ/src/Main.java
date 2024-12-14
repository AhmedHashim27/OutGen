//import java.util.Scanner;
//
//public class Main {
//
//    public static void main(String[] args) {
//        Model.Closet closet = new Model.Closet();
//        Model.ClosetManager closetManager = new Model.ClosetManager(closet);
//        Scanner scanner = new Scanner(System.in);
//
//        // Load existing items from CSV
//        closetManager.loadClosetFromCSV();
//
//        while (true) {
//            System.out.println("\n--- Model.Closet System Menu ---");
//            System.out.println("1. Add a new item to closet");
//            System.out.println("2. View all items in closet");
//            System.out.println("3. Exit");
//            System.out.print("Choose an option: ");
//            int choice = scanner.nextInt();
//            scanner.nextLine(); // Consume newline
//
//            switch (choice) {
//                case 1 -> addItemToCloset(closet, closetManager, scanner); // Add and auto-save
//                case 2 -> {
//                    closetManager.loadClosetFromCSV(); // Reload to ensure the latest items are displayed
//                    closet.displayItems();
//                }
//                case 3 -> {
//                    System.out.println("Exiting...");
//                    return;
//                }
//                default -> System.out.println("Invalid choice. Please try again.");
//            }
//        }
//    }
//
//    private static void addItemToCloset(Model.Closet closet, Model.ClosetManager closetManager, Scanner scanner) {
//        System.out.println("\nAdding a new item to your closet.");
//
//        // Select Part of Body
//        EPartOfBody partOfBody = promptForEnum(scanner, EPartOfBody.values(), "Select Part of Body");
//
//        // Select Subtype based on Part of Body
//        Object subtype;
//        switch (partOfBody) {
//            case UPPER -> subtype = promptForEnum(scanner, EUpper.values(), "Select Upper Body Clothing Type");
//            case LOWER -> subtype = promptForEnum(scanner, ELower.values(), "Select Lower Body Clothing Type");
//            case FEET -> subtype = promptForEnum(scanner, EFeet.values(), "Select Footwear Type");
//            case OTHER -> subtype = promptForEnum(scanner, EOther.values(), "Select Accessory Type");
//            default -> throw new IllegalStateException("Unexpected value: " + partOfBody);
//        }
//
//        // Select Texture, Pattern, and Color
//        ETexture texture = promptForEnum(scanner, ETexture.values(), "Select Texture");
//        EPattern pattern = promptForEnum(scanner, EPattern.values(), "Select Pattern");
//        EColor color = promptForEnum(scanner, EColor.values(), "Select Color");
//
//        // Create and add new item
//        ClothingItem newItem = new ClothingItem(partOfBody, subtype, texture, pattern, color);
//        closet.addClothing(newItem); // Add to the closet in memory
//        closetManager.saveSingleItemToCSV(newItem); // Save to CSV file
//        System.out.println("Item added: " + newItem.getItemDetails());
//    }
//
//    private static <T extends Enum<T>> T promptForEnum(Scanner scanner, T[] values, String message) {
//        System.out.println(message + ":");
//        for (int i = 0; i < values.length; i++) {
//            System.out.println((i + 1) + ". " + values[i]);
//        }
//        System.out.print("Enter your choice: ");
//        int choice = scanner.nextInt() - 1;
//        scanner.nextLine(); // Consume newline
//        return values[Math.max(0, Math.min(choice, values.length - 1))];
//    }
//}

import Controller.Controller;
import View.UIClass;

//import static com.sun.tools.javac.code.Type.UndetVar.InferenceBound.UPPER;

public class Main {

    public static void main(String[] args) {
        Controller controller = new Controller();
        UIClass ui = new UIClass(controller);
        controller.linkUISystem(ui);
    }
}