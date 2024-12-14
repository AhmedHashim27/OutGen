package View;
import java.util.InputMismatchException;
import java.util.Scanner;
import Model.ClothingItem;
import Model.ClosetManager;
import Model.OutfitGenerator;
import Model.EColor;
import Model.ETexture;
import Model.EPattern;
import Model.EPartOfBody;
import Controller.Controller;
import Model.Closet;
import Model.EUpper;
import Model.ELower;
import Model.EOther;
import Model.EFeet;


public class UIClass implements UISystem {
    private Controller controller;

    public UIClass(Controller controller){this.controller = controller;}

    public void startApp(Closet closet, ClosetManager closetManager, Scanner scanner){
            closetManager.loadClosetFromCSV();

            while(true) {
            System.out.println("\n--- Closet System Menu ---");
            System.out.println("1. Manage items in closet");
            System.out.println("2. View all items in closet");
            System.out.println("3. Generate an outfit");
            System.out.println("4. Exit");
            System.out.print("Chose an option: ");
            int choice = 0;
            boolean validInput = false;

            while(!validInput) {
                try {
                    choice = scanner.nextInt();
                    validInput = true;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid option! Please enter a number");
                    scanner.next();
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid option! Please enter a number from 1 - 4.");
                    scanner.next();
                }
            }
            controller.useCaseChoice(choice); //call controller with choice
    }
}
    //Helper methods to check for valid inputs.
    private static int isValidInputItems(Closet closet, Scanner scanner) {
        int choice = 0;
        boolean validInput = false;
        while(!validInput) {
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();

                if (choice >= 1 && choice <= closet.getItems().size()) {
                    validInput = true;
                } else {
                    System.out.println("Invalid option! Please enter a number from 1 - " + closet.getItems().size() + ".");
                }
            }else{
                System.out.println("Invalid option! Please enter a number.");
                scanner.next();
            }
        }
        return choice ;
    }

    private static int isValidInputInt(Scanner scanner, int size) {
        int choice = 0;
        boolean validInput = false;
        while(!validInput) {
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();

                if (choice >= 1 && choice <= size) {
                    validInput = true;
                } else {
                    System.out.println("Invalid option! Please enter a number from 1 - " + size + ".");
                }
            }else{
                System.out.println("Invalid option! Please enter a number.");
                scanner.next();
            }
        }
        return choice;
    }
    public static void printNumberedList(Closet closet){
        for (int i = 0; i < closet.getItems().size(); i++) {
            System.out.println((i + 1) + ". " + closet.getItems().get(i).getItemDetails());
        }
    }
    public EPartOfBody partOfBodyEnum(Scanner scanner) {
        return promptForEnum(scanner, EPartOfBody.values(), "Select Part of Body");
    }
    public Object subTypeEnum(Scanner scanner, EPartOfBody partOfBody) {
        Object subtype;
        switch(partOfBody) {
            case EPartOfBody.UPPER -> subtype = promptForEnum(scanner, EUpper.values(), "Select Upper Body Clothing Type");
            case EPartOfBody.LOWER -> subtype = promptForEnum(scanner, ELower.values(), "Select Lower Body Clothing Type");
            case EPartOfBody.FEET -> subtype = promptForEnum(scanner, EFeet.values(), "Select Footwear Type");
            case EPartOfBody.OTHER -> subtype = promptForEnum(scanner, EOther.values(), "Select Accessory Type");
            default -> throw new IllegalStateException("Unexpected value: " + partOfBody);
        }
        return subtype;
    }
    public ETexture textureEnum(Scanner scanner) {
        return promptForEnum(scanner, ETexture.values(), "Select Texture");
    }
    public EPattern patternEnum(Scanner scanner) {
        return promptForEnum(scanner, EPattern.values(), "Select Pattern");
    }
    public EColor colorEnum(Scanner scanner) {
        return promptForEnum(scanner, EColor.values(), "Select Color");
    }

    public ClothingItem getEnumeratedChoices(Scanner scanner) {
        // Select Part of Body
        EPartOfBody partOfBody = partOfBodyEnum(scanner);
        // Select Subtype based on Part of Body
        Object subtype = subTypeEnum(scanner, partOfBody);
        // Select Texture, Pattern, and Color
        ETexture texture = textureEnum(scanner);
        EPattern pattern = patternEnum(scanner);
        EColor color = colorEnum(scanner);
        return new ClothingItem(partOfBody, subtype, texture, pattern, color);
    }
    // Manage Closet
    public void manageCloset(Closet closet, ClosetManager closetManager, Scanner scanner) {
        System.out.println("\nAdd/Delete/Edit/Filter clothing in closet:");
        System.out.println("1. Add an item to closet");
        System.out.println("2. Delete an item from closet");
        System.out.println("3. Edit an item in closet");
        System.out.println("4. Filter closet");
        System.out.print("Chose an option: ");
        int choice = isValidInputInt(scanner, 4);
        controller.managingCloset(choice);
    }

    //Add an item to closet
    public void addItemToCloset (Closet closet, ClosetManager closetManager, Scanner scanner){
        System.out.println("\nAdding a new item to your closet.");
        ClothingItem clothing = getEnumeratedChoices(scanner);

        controller.addingToCloset(clothing.getPartOfBody(), clothing.getSubtype(), clothing.getTexture(), clothing.getPattern(), clothing.getColor());
    }

    public void removeItemFromCloset(Closet closet, ClosetManager closetManager, Scanner scanner) {
        printNumberedList(closet);
        System.out.print("Enter your choice: ");

        int choice = isValidInputItems(closet, scanner);

        System.out.println("\nRemoving an item from your closet");
        if(controller.deletingFromCloset(choice)){
            closet.displayItems();
            System.out.println("Item removed.");
        } else {
            closet.displayItems();
            System.out.println("Item not found.");
        }
    }

    //Edit item in Closet
    public void editItemsInCloset(Closet closet, ClosetManager closetManager, Scanner scanner) {
        printNumberedList(closet);
        System.out.print("Enter your choice: ");

        int choice = isValidInputItems(closet, scanner);
        ClothingItem item = controller.getItemChoice(choice);
        System.out.println("Enter new information for what you would like to change: Part of Body, Subtype, Color, Texture, Pattern");
        ClothingItem clothing = getEnumeratedChoices(scanner);
        controller.editingCloset(item, clothing);

        closet.displayItems();
        System.out.println("Item edited: " + item.getItemDetails());
    }

    // Filter items in closet
    public void filterItemsInCloset(Closet closet, ClosetManager closetManager, Scanner scanner) {
        System.out.println("\nChoose a filter to apply to closet:");
        System.out.println("1. Part of Body");
        System.out.println("2. Subtype");
        System.out.println("3. Texture");
        System.out.println("4. Pattern");
        System.out.println("5. Color");
        System.out.println("Chose an option: ");

        int choice = isValidInputInt(scanner, 5);

        controller.filteringCloset(choice);
        System.out.println("Filtered items in closet!");
    }

    public void generateOutfit(OutfitGenerator outfitGenerator) {
        System.out.println("\nCurrent Weather in New York:");
        controller.generatingOutfit();

    }

    private static <T extends Enum<T>> T promptForEnum(Scanner scanner, T[] values, String message) {
        System.out.println(message + ":");
        for (int i = 0; i < values.length; i++) {
            System.out.println((i + 1) + ". " + values[i]);
        }
        System.out.print("Enter your choice: ");

        while(true){
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                if (choice > 0 && choice <= values.length) {
                    return values[choice - 1];
                } else {
                    System.out.println("Invalid option! Try again.");
                }
            } else {
                System.out.println("Invalid option! Enter a valid number: 1 - " + values.length + ".");
                scanner.next();
            }
        }
    }
}
